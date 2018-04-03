package club.gsjglob.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import club.gsjglob.dao.GsjArticleMapper;
import club.gsjglob.dao.GsjFolderMapper;
import club.gsjglob.domain.GsjArticleExample;
import club.gsjglob.domain.GsjFolder;
import club.gsjglob.domain.GsjFolderExample;
import club.gsjglob.domain.GsjFolderExample.Criteria;
import club.gsjglob.service.IFolderService;
import club.gsjglob.tools.DateUtils;
import club.gsjglob.vo.ArticleChar;
import club.gsjglob.vo.FolderChar;

@Service
public class FolderServiceImpl implements IFolderService {

	@Autowired
	private GsjFolderMapper folderdao;
	// 返回的json数据
	private String folderjson;
	@Autowired
	private GsjArticleMapper articledao;

	/**
	 * 根据类型返回目录信息
	 * 
	 * @throws JsonProcessingException
	 */
	@Override
	public String getFolderInfo(String type) throws JsonProcessingException {
		GsjFolderExample example;
		switch (type) {
		case "index": // 主页
			example = new GsjFolderExample();
			Criteria criteria = example.createCriteria();
			criteria.andKeyEqualTo("index");
			criteria.andParentIdEqualTo(0);
			List<GsjFolder> indexFolders = folderdao.selectByExample(example);
			GsjFolderExample indexexample = null;
			List<GsjFolder> jsonList = new ArrayList<GsjFolder>();
			for (GsjFolder gsjFolder : indexFolders) {
				Integer id = gsjFolder.getId();
				indexexample = new GsjFolderExample();
				indexexample.createCriteria().andParentIdEqualTo(id);
				List<GsjFolder> subList = folderdao.selectByExample(indexexample);
				gsjFolder.setSubsetlist(subList);
				jsonList.add(gsjFolder);
			}
			ObjectMapper mapper = new ObjectMapper();
			folderjson = mapper.writeValueAsString(jsonList);
			break;

		case "blogtype": // 主页博客分类
			// 查询key是 blog的目录信息
			example = new GsjFolderExample();
			Criteria blogcriteria = example.createCriteria();
			blogcriteria.andKeyEqualTo("blog");
			blogcriteria.andParentIdNotEqualTo(1);
			List<GsjFolder> blogFolders = folderdao.selectByExample(example);
			for (GsjFolder gsjFolder : blogFolders) {
				Integer blogid = gsjFolder.getId();
				GsjArticleExample gsjarticleexample = new GsjArticleExample();
				gsjarticleexample.createCriteria().andFolderIdEqualTo(blogid);
				int countByExample = articledao.countByExample(gsjarticleexample);
				gsjFolder.setBlogtypenum(countByExample);
			}
			ObjectMapper mapperblog = new ObjectMapper();
			folderjson = mapperblog.writeValueAsString(blogFolders);
			break;
		default:
			break;
		}
		return folderjson;
	}

	@Override
	public String updateFolderById(String id, String name, String parentid, String key) {

		GsjFolder gsjFolder = new GsjFolder();
		gsjFolder.setId(Integer.parseInt(id));
		gsjFolder.setName(name);
		gsjFolder.setParentId(Integer.parseInt(parentid));
		gsjFolder.setKey(key);
		gsjFolder.setUpdateTime(DateUtils.getStringDate());
		gsjFolder.setUpdateId(3);
		int updateByPrimaryKey = folderdao.updateByPrimaryKey(gsjFolder);
		if (updateByPrimaryKey > 0) {
			return "{\"message\":\"success\"}";
		}
		return "{\"message\":\"error\"}";
	}

	@Override
	public String InsertFolder(GsjFolder folder) {
		// 判断是否存在
		GsjFolderExample example = new GsjFolderExample();
		example.createCriteria().andNameEqualTo(folder.getName());
		List<GsjFolder> selectByExample = folderdao.selectByExample(example);
		if (selectByExample.size() <= 0) {
			folder.setCreateTime(DateUtils.getStringDate());
			folder.setCreateId(3);
			folder.setSort(1);
			folder.setStatus(1);
			folder.setType(1);
			int insert = folderdao.insert(folder);
			if (insert > 0) {
				return "{\"message\":\"success\"}";
			}
		}
		return "{\"message\":\"error\"}";
	}

	@Override
	public FolderChar createFoldertu1() {
		GsjFolderExample example = new GsjFolderExample();
		Criteria blogcriteria = example.createCriteria();
		blogcriteria.andKeyEqualTo("blog");
		blogcriteria.andParentIdNotEqualTo(1);
		List<GsjFolder> blogFolders = folderdao.selectByExample(example);
		for (GsjFolder gsjFolder : blogFolders) {
			Integer blogid = gsjFolder.getId();
			GsjArticleExample gsjarticleexample = new GsjArticleExample();
			gsjarticleexample.createCriteria().andFolderIdEqualTo(blogid);
			int countByExample = articledao.countByExample(gsjarticleexample);
			gsjFolder.setBlogtypenum(countByExample);
		}
		FolderChar folderChar = new FolderChar();
		List folder = folderChar.getFolder();
		List num = folderChar.getNum();
		for (GsjFolder gsjFolder : blogFolders) {
			folder.add(gsjFolder.getName());
			num.add(gsjFolder.getBlogtypenum());
		}
		folderChar.setFolder(folder);
		folderChar.setNum(num);
		return folderChar;

	}

	@Override
	public ArticleChar createFoldertu2() {
		List<ArticleChar> articleNumCharByTime = folderdao.getArticleNumCharByTime();
		ArticleChar articleChar2 = new ArticleChar();
		List ydl = articleChar2.getYdl();
		List numydl = articleChar2.getNumydl();
		for (ArticleChar articleChar : articleNumCharByTime) {
			String yd = articleChar.getYd();
			String numyd = articleChar.getNumyd();
			ydl.add(yd);
			numydl.add(numyd);
		}
		articleChar2.setYdl(ydl);
		articleChar2.setNumydl(numydl);
		return articleChar2;
	}

}
