package club.gsjglob.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import club.gsjglob.domain.GsjUser;
import club.gsjglob.dto.User;
import club.gsjglob.service.IUserService;

/**
 *  用户管理的controller
 * @author gengzi
 * @time 2018年3月22日10:24:50
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private IUserService userservice;
	
	
	/**
	 *  用户登陆
	 * @param user 用户入参字段对象
	 * @return 是否登陆成功
	 */
	@RequestMapping(value = "/user/login",method=RequestMethod.POST)
	@ResponseBody
	public GsjUser login( User user,HttpServletRequest request) {
		GsjUser gsjuser = null;
		String isadmin = user.getIsadmin();
		switch (isadmin) {
		case "admin":  //管理员
			gsjuser = userservice.login(user);
			if (gsjuser.getUserid() != null) {
				HttpSession session = request.getSession();
				session.setAttribute("gsjuser", gsjuser);
			}
			break;
			
		case "noadmin": // 一般用户
			
			break;

		default:
			break;
		}
		return gsjuser;
		
	}
	
	
	

}
