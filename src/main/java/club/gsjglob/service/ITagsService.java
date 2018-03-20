package club.gsjglob.service;

import club.gsjglob.domain.GsjTags;

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
	GsjTags  getTagsInfo(String gsjtype);

}
