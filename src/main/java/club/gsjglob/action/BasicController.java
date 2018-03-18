package club.gsjglob.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("")
	public String index(){
		System.out.println("跳转到主页面");
		 return "index";
	}
	
	/**
	 * 路径跳转处理
	 * @param address
	 * @return
	 */
	@RequestMapping(value= "/{address}")
	public String forword(@PathVariable String address){
		System.out.println("跳转到qita页面"+address);
		 return address;
	}
}
