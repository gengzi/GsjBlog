package club.gsjglob.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import club.gsjglob.domain.GsjArticle;
import club.gsjglob.domain.GsjFolder;
import club.gsjglob.domain.GsjTags;
import club.gsjglob.dto.SaveArticle;
import club.gsjglob.service.IArticleService;
import club.gsjglob.service.ITagsService;
import club.gsjglob.vo.ArticleContent;

/**
 * 博客文章管理
 * 
 * @author gengzi
 * @time 2018年3月18日13:37:19
 *
 */
@Controller
public class ArticleController {

	@Autowired
	private IArticleService articleService;

	@Autowired
	private ITagsService tagsService;

	/**
	 * 分页显示，根据类别返回文章信息
	 * 
	 * @param blogtype
	 *            博客类别
	 * @param labeltype
	 *            标签类别
	 * @param startpage
	 *            开始页码
	 * @param endpage
	 *            结束页码
	 * @param response
	 *            json数据
	 */
	@RequestMapping(value = "/article/{blogtype}/{labeltype}/{startpage}/{pagesize}")
	@ResponseBody
	public PageInfo getArticleInfo(@PathVariable String blogtype, @PathVariable String labeltype,
			@PathVariable String startpage, @PathVariable String pagesize, HttpServletResponse response) {
		// PageHelper.startPage(Integer.parseInt(startpage),
		// Integer.parseInt(pagesize));
		List<GsjArticle> articleInfo = articleService.getArticleInfo(blogtype, labeltype, startpage, pagesize);
		PageInfo<GsjArticle> pageInfo = new PageInfo<>(articleInfo);
		return pageInfo;
	}
	
	
	
	/**
	 * 分页显示，根据类别返回专栏中的文章信息
	 * 
	 * @param blogtype
	 *            博客类别
	 * @param labeltype
	 *            标签类别
	 * @param startpage
	 *            开始页码
	 * @param endpage
	 *            结束页码
	 * @param iszl
	 *            是否是专栏
	 * @param response
	 *            json数据
	 */
	@RequestMapping(value = "/article/{blogtype}/{labeltype}/{startpage}/{pagesize}/{iszl}")
	@ResponseBody
	public PageInfo getArticlezlInfo(@PathVariable String blogtype, @PathVariable String labeltype,
			@PathVariable String startpage, @PathVariable String pagesize,  @PathVariable String iszl,HttpServletResponse response) {
		if ("zl".equals(iszl)) {
			List<GsjArticle> articleInfo = articleService.getArticlezlInfo(blogtype, labeltype, startpage, pagesize);
			PageInfo<GsjArticle> pageInfo = new PageInfo<>(articleInfo);
			return pageInfo;
		}
		return null;
	}

	/**
	 * 跳转到文章的详情页面
	 * 
	 * @param articleid
	 *            文章的id
	 * @return GsjArticle 对象
	 */
	@RequestMapping(value = "/article/{articleid}")
	public String getArticleInfo(@PathVariable String articleid) {
		return "article";
	}

	/**
	 * 查看文章的详情
	 * 
	 * @param articleid
	 *            文章的id
	 * @return GsjArticle 对象
	 */
	@RequestMapping(value = "/article/content/{articleid}")
	@ResponseBody
	public ArticleContent getArticleContentInfo(@PathVariable String articleid) {
		// 返回文章详情
		GsjArticle articleContent = articleService.getArticleContent(Integer.parseInt(articleid));
		// 返回文章的标签
		List<GsjTags> tagByArticleid = tagsService.getTagByArticleid(Integer.parseInt(articleid));
		ArticleContent articleContentVo = new ArticleContent();
		articleContentVo.setGsjArticle(articleContent);
		articleContentVo.setGsjTagslist(tagByArticleid);
		return articleContentVo;
	}

	/**
	 * 保存文章的内容
	 * 
	 * @param article
	 *            保存的入参对象
	 * @return
	 */
	@RequestMapping(value = "/article/savearticle", method = RequestMethod.POST)
	@ResponseBody
	public String saveArticleContent(SaveArticle article) {
		// 解析post请求的示例
		return articleService.saveArticleContent(article);

	}

	/**
	 * 后台管理-文章管理分页查询
	 * 
	 * @param blogtype 博客的类型
	 * @param labeltype 博客的标签类型
	 * @param startpage 页码
	 * @param pagesize 每页显示的条数
	 *           
	 * @return
	 */
	@RequestMapping(value = "/article/admin", method = RequestMethod.GET)
	@ResponseBody
	public PageInfo getArticleLimitInfo(String blogtype, String labeltype, String startpage, String pagesize,
			HttpServletResponse response) {
		List<GsjArticle> articleInfo = articleService.getArticleInfo(blogtype, labeltype, startpage, pagesize);
		PageInfo<GsjArticle> pageInfo = new PageInfo<>(articleInfo);
		return pageInfo;
	}
	
	
	/**
	 * 跳转到文章的详情页面
	 * 
	 * @param articleid
	 *            文章的id
	 * @return GsjArticle 对象
	 */
	@RequestMapping(value = "/articleupdate/{articleid}")
	public String updateArticleInfo(@PathVariable String articleid) {
		return "gsj_article";
	}
	
	
	/** 
	 * 修改文章信息
	 * @param id 文章的编号
	 * @return
	 */
	@RequestMapping(value = "/article/updatearticle", method = RequestMethod.POST)
	@ResponseBody
	public String updateArticleInfo(SaveArticle saveArticle) {
		 return  articleService.updateArticleById(saveArticle);
	}
	
	
	
	/** 
	 * 根据id删除文章信息
	 * @param id 文章的编号
	 * @return
	 */
	@RequestMapping(value = "/article/remove/{articleid}", method = RequestMethod.GET)
	@ResponseBody
	public String removeArticleInfo(@PathVariable String articleid,ModelAndView model) {
	    return articleService.remove(Integer.parseInt(articleid));
	}
	
	/**
	 * 跳转到文章的详情页面
	 * 
	 * @param articleid
	 *            文章的id
	 * @return GsjArticle 对象
	 */
	@RequestMapping(value = "/article_zl/{articletype}")
	public String forwordArticlezl(@PathVariable String articletype) {
		return "article_zl";
	}
	
	
	
	/**
	 * 设置文章的专栏信息
	 * @return
	 */
	@RequestMapping(value = "/updatearticelezl",method=RequestMethod.POST)
	@ResponseBody
	public String updatefolderInfo(GsjArticle article) {
	   	 return articleService.updateArtcilezlById(article);
	}
	
	

}