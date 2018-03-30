package club.gsjglob.service.impl;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import club.gsjglob.dao.GsjArticleMapper;
import club.gsjglob.dao.GsjFolderMapper;
import club.gsjglob.dao.GsjTagsMapper;
import club.gsjglob.domain.GsjArticle;
import club.gsjglob.domain.GsjArticleExample;
import club.gsjglob.domain.GsjArticleExample.Criteria;
import club.gsjglob.domain.GsjFolder;
import club.gsjglob.domain.GsjFolderExample;
import club.gsjglob.domain.GsjTags;
import club.gsjglob.domain.GsjTagsExample;
import club.gsjglob.dto.SaveArticle;
import club.gsjglob.service.IArticleService;
import club.gsjglob.tools.DateUtils;

/**
 * 博客管理serviceimpl
 * 
 * @author gengzi
 * @time 2018年3月21日18:06:36
 *
 */
@Service
public class ArticleServiceImpl implements IArticleService {

	@Autowired
	private GsjArticleMapper articledao;

	@Autowired
	private GsjFolderMapper folderdao;

	@Autowired
	private GsjTagsMapper tagdao;

	private List<GsjArticle> data;

	@Override
	public List<GsjArticle> getArticleInfo(String blogtype, String labeltype, String startpage, String pagesize) {

		GsjArticleExample articleExample;
		data = new ArrayList<GsjArticle>();
		// 查询全部
		if ("全部".equals(blogtype) && "全部".equals(labeltype)) {
			PageHelper.startPage(Integer.parseInt(startpage), Integer.parseInt(pagesize));
			articleExample = new GsjArticleExample();
			articleExample.setOrderByClause("create_time DESC");
			data = articledao.selectByExample(articleExample);
			setTagInfos(data);
		} else if ("全部".equals(labeltype)) { // 按照博客类别查询
			// 先查询目录表中，博客的类别
			GsjFolderExample example = new GsjFolderExample();
			club.gsjglob.domain.GsjFolderExample.Criteria foldercriteria = example.createCriteria();
			foldercriteria.andKeyEqualTo("blog");
			foldercriteria.andNameEqualTo(blogtype.trim());
			List<GsjFolder> selectByExample = folderdao.selectByExample(example);
			if (selectByExample.size() > 0) {
				// 根据目录id 查询文章表
				PageHelper.startPage(Integer.parseInt(startpage), Integer.parseInt(pagesize));
				articleExample = new GsjArticleExample();
				Criteria createCriteria = articleExample.createCriteria();
				createCriteria.andFolderIdEqualTo(selectByExample.get(0).getId());
				articleExample.setOrderByClause("create_time DESC");
				data = articledao.selectByExample(articleExample);
				setTagInfos(data);
			}
		} else if ("全部".equals(blogtype)) { // 按照标签查询
			// 查询标签表中，博客的id
			List<Integer> articleIds = tagdao.getArticleIdByTagname(labeltype);
			if (articleIds.size() > 0) {
				// for (Integer articleId : articleIds) {
				PageHelper.startPage(Integer.parseInt(startpage), Integer.parseInt(pagesize));
				// 采用连表查询
				articleExample = new GsjArticleExample();
				articleExample.createCriteria().andIdIn(articleIds);
				articleExample.setOrderByClause("create_time DESC");
				data = articledao.selectByExample(articleExample);
				// 设置每篇文章的tags
				setTagInfos(data);
				// }
			}
		}
		return data;
	}

	/**
	 * 设置每篇文章的tags
	 */
	private void setTagInfos(List<GsjArticle> data) {
		for (int i = 0; i < data.size(); i++) {
			GsjArticle gsjArticle = data.get(i);
			Integer articid = gsjArticle.getId();
			GsjTagsExample example = new GsjTagsExample();
			example.createCriteria().andArticleIdEqualTo(articid);
			List<GsjTags> tags = tagdao.selectByExample(example);
			gsjArticle.setTags(tags);
		}
	}

	@Override
	public GsjArticle getArticleContent(Integer articleid) {
		GsjArticleExample articleExample = new GsjArticleExample();
		GsjArticle selectByPrimaryKey = articledao.selectByPrimaryKey(articleid);
		return selectByPrimaryKey;
	}

	@Override
	public String saveArticleContent(SaveArticle article) {
		// 解析SaveArticle 设置给 GsjArticle
		GsjArticle gsjArticle = new GsjArticle();
		gsjArticle.setCreateId(article.getCreateId()); // 创建者
		gsjArticle.setTitle(article.getTitle()); // 标题
		gsjArticle.setContent(article.getContent()); // 内容
		gsjArticle.setFolderId(article.getFolderId()); // 目录id
		gsjArticle.setCreateTime(DateUtils.getStringDate()); // 创建时间
		gsjArticle.setPublishTime(DateUtils.getStringDate()); // 发布时间
		gsjArticle.setPublishUser(article.getPublishUser());
		gsjArticle.setCountView(0); // 浏览数
		gsjArticle.setCountComment(0); // 评论数
		gsjArticle.setType(article.getType()); // 正常显示
		int insertSelective = articledao.insertSelective(gsjArticle);
		// 保存成功后的id
		Integer id = gsjArticle.getId();
		boolean flag = true;
		// 解析Tags
		String articleTags = article.getArticleTags();
		if (articleTags.length() > 0) {
			// 根据;解析
			String[] split = articleTags.split(";");
			// 根据文章id插入
			for (String tag : split) {
				GsjTags record = new GsjTags();
				record.setArticleId(id);
				record.setTagname(tag);
				record.setCreateTime(DateUtils.getStringDate());
				record.setCreateId(article.getCreateId());
				int insert = tagdao.insertSelective(record);
				if (insert > 0) {
					// 成功
				} else {
					// 不成功
					tagdao.deleteByPrimaryKey(record.getId());
					flag = false;
				}
			}
		}
		if (insertSelective > 0 && flag) {
			// 插入成功
			return "{\"message\":\"success\"}";
		} else {
			// 不成功
			articledao.deleteByPrimaryKey(gsjArticle.getId());
			return "{\"message\":\"error\"}";
			
		}
	}

	@Override
	public String remove(int id) {
		
		int deleteByPrimaryKey = articledao.deleteByPrimaryKey(id);
		if (deleteByPrimaryKey < 0) {
			return "{\"message\":\"error\"}";
		}
		return "{\"message\":\"success\"}";
	}

	@Override
	public String updateArticleById(SaveArticle article) {
		Integer id = article.getId();
		if (id != null && id != 0) {
			// 解析SaveArticle 设置给 GsjArticle
			GsjArticle gsjArticle = new GsjArticle();
			gsjArticle.setId(id);
			gsjArticle.setCreateId(article.getCreateId()); // 创建者
			gsjArticle.setTitle(article.getTitle()); // 标题
			gsjArticle.setContent(article.getContent()); // 内容
			gsjArticle.setFolderId(article.getFolderId()); // 目录id
			gsjArticle.setCreateTime(DateUtils.getStringDate()); // 创建时间
			gsjArticle.setPublishTime(DateUtils.getStringDate()); // 发布时间
			gsjArticle.setPublishUser(article.getPublishUser());
			gsjArticle.setType(article.getType()); // 类型
			int insertSelective = articledao.updateByPrimaryKeySelective(gsjArticle);
			// 保存成功后的id
			Integer aid = gsjArticle.getId();
			boolean flag = true;
			// 解析Tags
			String articleTags = article.getArticleTags();
			if (articleTags.length() > 0) {
				// 根据;解析
				String[] split = articleTags.split(";");
				// 根据文章id插入
				for (String tag : split) {
					//先删除再插入
					GsjTagsExample example = new GsjTagsExample();
					example.createCriteria().andArticleIdEqualTo(id);
					int deleteByExample = tagdao.deleteByExample(example);
					if (deleteByExample > 0 ) {
						GsjTags record = new GsjTags();
						record.setArticleId(aid);
						record.setTagname(tag);
						record.setCreateTime(DateUtils.getStringDate());
						record.setCreateId(article.getCreateId());
						int insert = tagdao.insertSelective(record);
							if (insert > 0) {
								// 成功
							} else {
								// 不成功
								tagdao.deleteByPrimaryKey(record.getId());
								flag = false;
							}
					}else {
						flag = false;
					}
				}
			}
			if (insertSelective > 0 && flag) {
				// 插入成功
				return "{\"message\":\"success\"}";
			} else {
				// 不成功
				articledao.deleteByPrimaryKey(gsjArticle.getId());
				return "{\"message\":\"error\"}";
			}
			
		}else {
			return "{\"message\":\"error\"}";
		}
	}

}
