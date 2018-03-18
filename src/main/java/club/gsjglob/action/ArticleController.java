package club.gsjglob.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.gsjglob.domain.GsjArticle;
import club.gsjglob.service.IArticleService;

/**
 * 博客文章管理
 * @author gengzi
 * @time 2018年3月18日13:37:19
 *
 */
@Controller
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	/**
	 * 分页显示，根据类别返回文章信息
	 * @param blogtype 博客类别
	 * @param labeltype 标签类别
	 * @param startpage 开始页码
	 * @param endpage 结束页码
	 * @param response json数据
	 */
	@RequestMapping(value="/article/{blogtype}/{labeltype}/{startpage}/{pagesize}")
	@ResponseBody
	public PageInfo getArticleInfo(@PathVariable String blogtype,@PathVariable String labeltype,@PathVariable String startpage,@PathVariable String pagesize,HttpServletResponse response) {
		//PageHelper.startPage(Integer.parseInt(startpage), Integer.parseInt(pagesize)); 
		List<GsjArticle> articleInfo = articleService.getArticleInfo(blogtype, labeltype,startpage,pagesize);
		PageInfo<GsjArticle> pageInfo = new PageInfo<>(articleInfo);
		return pageInfo;
	}

}
