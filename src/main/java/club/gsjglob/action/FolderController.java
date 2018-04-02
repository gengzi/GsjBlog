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
	
	
	
	@RequestMapping(value = "/updatefolder",method=RequestMethod.POST)
	@ResponseBody
	public String updatefolderInfo(String id,String name,String parentid,String key) {
	   	 return folderservice.updateFolderById(id,name,parentid,key);
	}
	


	
	
	
}
