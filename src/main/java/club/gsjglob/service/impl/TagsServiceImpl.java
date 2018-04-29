package club.gsjglob.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.gsjglob.dao.GsjTagsMapper;
import club.gsjglob.domain.GsjTags;
import club.gsjglob.domain.GsjTagsExample;
import club.gsjglob.service.ITagsService;
import club.gsjglob.vo.TagsAll;


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
	public List<TagsAll> getTagsInfo(String gsjtype) {
		
		List<TagsAll> alls = new ArrayList<TagsAll>();
		
		switch (gsjtype) {
		case "only":  // 返回常见的标签
			List<String> tagnames = tagsdao.getTagsOnlyByTagname();
			//解析组拼好的数据,以;分隔
			for (String tagname : tagnames) {
				String[] tagNameAndValue = tagname.split(";");
				if (tagNameAndValue.length == 2) {
					int tagnum = Integer.parseInt(tagNameAndValue[1]);
					if (tagnum >= 3) { //控制超过几个以上的显示出来
						TagsAll tagsAll = new TagsAll();
						tagsAll.setTagName(tagNameAndValue[0]);
						tagsAll.setTagNameNum(tagnum);
						alls.add(tagsAll);
					}
				}	
			}
			break;

		default:
			break;
		}
		return alls;
	}

	@Override
	public List<GsjTags> getTagByArticleid(int articleId) {
		GsjTagsExample example = new GsjTagsExample();
		example.createCriteria().andArticleIdEqualTo(articleId);
		return tagsdao.selectByExample(example);
	}

}
