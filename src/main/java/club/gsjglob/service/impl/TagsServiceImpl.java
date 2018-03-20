package club.gsjglob.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.gsjglob.dao.GsjTagsMapper;
import club.gsjglob.domain.GsjTags;
import club.gsjglob.domain.GsjTagsExample;
import club.gsjglob.service.ITagsService;


/**
 *  标签管理service
 * @author gengzi
 * @time 2018年3月20日13:38:49 
 *
 */
@Service
public class TagsServiceImpl implements ITagsService {

	@Autowired
	private  GsjTagsMapper  tagsdao;

	@Override
	public GsjTags getTagsInfo(String gsjtype) {
		
		switch (gsjtype) {
		case "only":  // 返回常见的标签
			
			
			
			
			
			break;

		default:
			break;
		}
		
		
		return null;
	}

}
