package club.gsjglob.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
	
	@RequestMapping("/")
	public String index(){
		System.out.println("跳转到主页面");
		 return "index";
	}
}
