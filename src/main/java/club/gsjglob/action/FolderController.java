package club.gsjglob.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import club.gsjglob.domain.GsjFolder;
import club.gsjglob.service.IFolderService;
import club.gsjglob.vo.ArticleChar;
import club.gsjglob.vo.FolderChar;

/**
 * 项目的目录管理
 * @author gengzi
 * @time 2018年3月17日15:41:25
 *
 */
@Controller
public class FolderController {
	

	@Autowired
	private IFolderService folderservice;
	
	
	/**
	 * 返回菜单目录
	 * @return
	 */
	@RequestMapping(value="/folder/{name}")
	public void getIndexFolder(@PathVariable String name,HttpServletResponse httpResponse) {
		
		String folderInfo = null;
		try {
			folderInfo = folderservice.getFolderInfo(name);
			httpResponse.setCharacterEncoding("UTF-8");
			httpResponse.setContentType("application/json;charset=utf-8");
			PrintWriter writer = httpResponse.getWriter();
			writer.print(folderInfo);
			writer.close();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	/**
	 * 查询所有的博客分类
	 * @param blog
	 * @return
	 */
	@RequestMapping(value = "/articletype/{blog}")
	public void getBlogTypeInfo(@PathVariable String blog,HttpServletResponse httpResponse) {
		getIndexFolder("blogtype", httpResponse);
	}
	
	
	/**
	 * 更新博客分类的类别名称
	 * @param id 类别id
	 * @param name 类别名称
	 * @param parentid 父编号
	 * @param key key
	 * @return
	 */
	@RequestMapping(value = "/updatefolder",method=RequestMethod.POST)
	@ResponseBody
	public String updatefolderInfo(String id,String name,String parentid,String key) {
	   	 return folderservice.updateFolderById(id,name,parentid,key);
	}
	
	

	/**
	 * 创建新博客类别
	 * @param folder GsjFolder
	 * @return
	 */
	@RequestMapping(value = "/folder/createfolder",method=RequestMethod.POST)
	@ResponseBody
	public String createfolder(GsjFolder folder) {
	   	 return folderservice.InsertFolder(folder);
	}
	
	

	/**
	 * 创建目录个数对应的图数据
	 * @return
	 */
	@RequestMapping(value = "/folder/getfoldereachartu1")
	@ResponseBody
	public FolderChar createFolderchartu1() {
		return folderservice.createFoldertu1();
	}
	
	/**
	 * 创建月份对应文章数目
	 * @return
	 */
	@RequestMapping(value = "/folder/getfoldereachartu2")
	@ResponseBody
	public ArticleChar createFolderchartu2() {
		return folderservice.createFoldertu2();
	}
	
	

	
	
	
	
	


	
	
	
}
