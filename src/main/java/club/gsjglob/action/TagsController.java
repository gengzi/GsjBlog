package club.gsjglob.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import club.gsjglob.domain.GsjTags;
import club.gsjglob.service.ITagsService;

/**
 * 标签管理的controller
 * 
 * @author gengzi
 *
 */
@Controller
public class TagsController {

	@Autowired
	private ITagsService tagsService;

	/**
	 * 返回标签信息
	 * 
	 * @param tagsname
	 *            tagstype 可能以后会有变化，先这样设计
	 * @return json数据
	 */
	@RequestMapping(value = "/tags/{tagsname}")
	@ResponseBody
	public GsjTags getTagsInfo(@PathVariable String tagsname) {
		GsjTags tagsInfo = tagsService.getTagsInfo(tagsname);
		return tagsInfo;
	}

}
