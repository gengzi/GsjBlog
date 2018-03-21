package club.gsjglob.service;

import java.util.List;

import club.gsjglob.domain.GsjArticle;
import club.gsjglob.dto.SaveArticle;

/**
 *  博客管理的service
 * @author gengzi
 * @time 2018年3月18日13:49:12
 *
 */
public interface IArticleService {
	
	/**
	 * 根据类型返回分页的博客信息
	 * @param blogtype 博客类别
	 * @param labeltype 标签类别
	 * @return List 集合
	 */
	List<GsjArticle> getArticleInfo(String blogtype,String labeltype,String startpage,String pagesize);
	

	/**
	 *  返回文章的内容
	 * @param articleid 文章的id
	 * @return GsjArticle 对象
	 */
	GsjArticle getArticleContent(Integer articleid);


	/**
	 *   发表文章信息
	 * @param article  保存的文章字段实体
	 * @return json  success 成功， error 失败
	 */
	String saveArticleContent(SaveArticle article);
	
	

}
