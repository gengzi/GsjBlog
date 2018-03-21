package club.gsjglob.service;

import java.util.List;

import club.gsjglob.domain.GsjTags;
import club.gsjglob.vo.TagsAll;

/**
 *  标签管理的service
 * @author gengzi
 *
 */
public interface ITagsService {
	
	/**
	 *  根据类型返回标签的信息
	 * @param gsjtype  类型
	 * @return  GsjTags 
	 */
	List<TagsAll>  getTagsInfo(String gsjtype);

	/**
	 * 根据文章的id 返回该文章对应的标签
	 * @param parseInt
	 */
	List<GsjTags> getTagByArticleid(int articleid);

}
