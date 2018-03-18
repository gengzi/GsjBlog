package club.gsjglob.service.impl;

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
import club.gsjglob.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService{

	@Autowired
	private GsjArticleMapper articledao;
	
	@Autowired
	private GsjFolderMapper folderdao;
	
	@Autowired
	private GsjTagsMapper  tagdao;

	private List<GsjArticle> data;

	@Override
	public List<GsjArticle> getArticleInfo(String blogtype, String labeltype,String startpage,String pagesize) {
		
		GsjArticleExample articleExample ;
		data = new ArrayList<GsjArticle>();
		//查询全部
		if ("全部".equals(blogtype) && "全部".equals(labeltype)) {
			PageHelper.startPage(Integer.parseInt(startpage), Integer.parseInt(pagesize)); 
			articleExample = new GsjArticleExample();
			data = articledao.selectByExample(articleExample);
			setTagInfos(data);
		}else if ("全部".equals(labeltype)) { //按照博客类别查询
			//先查询目录表中，博客的类别		
			GsjFolderExample example = new GsjFolderExample();
			club.gsjglob.domain.GsjFolderExample.Criteria foldercriteria = example.createCriteria();
			foldercriteria.andKeyEqualTo("blog");
			foldercriteria.andNameEqualTo(blogtype.trim());
			List<GsjFolder> selectByExample = folderdao.selectByExample(example);
			if (selectByExample.size() > 0) {
				//根据目录id 查询文章表
				PageHelper.startPage(Integer.parseInt(startpage), Integer.parseInt(pagesize)); 
				articleExample  =new GsjArticleExample();
				Criteria createCriteria = articleExample.createCriteria();
				createCriteria.andFolderIdEqualTo(selectByExample.get(0).getId());
				data = articledao.selectByExample(articleExample);
				setTagInfos(data);
			}
		}else if("全部".equals(blogtype)) {	//按照标签查询
			//查询标签表中，博客的id
			List<Integer> articleIds= tagdao.getArticleIdByTagname(labeltype);
			if (articleIds.size() > 0) {
			//	for (Integer articleId : articleIds) {
				PageHelper.startPage(Integer.parseInt(startpage), Integer.parseInt(pagesize)); 
				//采用连表查询
				articleExample = new GsjArticleExample();
				articleExample.createCriteria().andIdIn(articleIds);
				data =  articledao.selectByExample(articleExample);
				// 设置每篇文章的tags
				setTagInfos(data);
				
			//	}
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
	
	

}
