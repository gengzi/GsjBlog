package club.gsjglob.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.gsjglob.domain.GsjArticle;
import club.gsjglob.domain.GsjFriendlylink;
import club.gsjglob.domain.GsjFriendlylinkExample;
import club.gsjglob.service.IFriendlyLikeService;
import club.gsjglob.vo.ShowUrlInfo;

/**
 * 友情链接controller
 * 
 * @author gengzi
 * @time 2018年3月31日12:33:53
 *
 */
@Controller
public class FriendlyLikeController {

	@Autowired
	private IFriendlyLikeService friendlyLikeService;

	/**
	 * 查询收藏的父网址信息
	 * 
	 * @return ShowUrlInfo
	 */
	@RequestMapping(value = "friendlike/parentinfo")
	@ResponseBody
	public List<ShowUrlInfo> shwoUrlcollectionInfo() {
		return friendlyLikeService.selectParentInfo();
	}

	/**
	 * 页面跳转
	 * 
	 * @param id
	 *            父id
	 * @return
	 */
	@RequestMapping(value = "ziurlconllection/{id}")
	public String getArticleInfo(@PathVariable String id) {
		return "ziurlconllection";
	}

	/**
	 * 查询收藏的父网址信息
	 * 
	 * @return ShowUrlInfo
	 */
	@RequestMapping(value = "/friendlike/ziinfo")
	@ResponseBody
	public PageInfo getziUrlInfo(String parentid, String startpage, String pagesize, HttpServletResponse response) {
		PageHelper.startPage(Integer.parseInt(startpage), Integer.parseInt(pagesize));
		List<GsjFriendlylink> selectziUrlInfo = friendlyLikeService.selectziUrlInfo(parentid);
		PageInfo<GsjFriendlylink> pageInfo = new PageInfo<>(selectziUrlInfo);
		return pageInfo;
	}
	
	
	/**
	 * 添加子分类url信息
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/ziinfo/save")
	@ResponseBody
	public String saveziUrlInfo(GsjFriendlylink gsjfriendlylink) {
 		return  friendlyLikeService.saveziUrlInfo(gsjfriendlylink);
	}

}
