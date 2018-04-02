package club.gsjglob.action;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import club.gsjglob.domain.GsjUser;
import club.gsjglob.dto.User;
import club.gsjglob.service.IUserService;
import club.gsjglob.tools.GsjParams;
import club.gsjglob.tools.JedisClient;

/**
 * 用户管理的controller
 * 
 * @author gengzi
 * @time 2018年3月22日10:24:50
 *
 */
@Controller
public class UserController {

	@Autowired
	private IUserService userservice;

	@Autowired
	private JedisClient jedisClient;

	/**
	 * 用户登陆
	 * 
	 * @param user
	 *            用户入参字段对象
	 * @return 是否登陆成功
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public GsjUser login(User user, HttpServletRequest request, HttpServletResponse response) {
		GsjUser gsjuser = null;
		try {
			String isadmin = user.getIsadmin();
			// switch (isadmin) {
			// case "admin": // 管理员
			gsjuser = userservice.login(user);
			if (gsjuser.getUserid() != null) {
				// 使用单点登陆，在页面是无法拿到session的
				// HttpSession session = request.getSession();
				// session.setAttribute("gsjuser", gsjuser);
				// 登陆成功，生成token
				String token = UUID.randomUUID().toString();
				// 将用户信息存储到redis中，key 就是 token，value 是 用户的信息的json格式
				ObjectMapper mapperblog = new ObjectMapper();
				String userjson = mapperblog.writeValueAsString(gsjuser);
				// token
				String tokenkey = "userInfo:" + token;
				// 设置,进行编码处理
				jedisClient.set(tokenkey, userjson);
				// 设置超时时间
				jedisClient.expire(tokenkey, GsjParams.SESSION_EXPIRE);
				// 将其token 设置到cookie 中
				club.gsjglob.tools.CookieUtils.setCookie(request, response, GsjParams.GSJCOOKIE, tokenkey);
			}
			// break;
			//
			// case "noadmin": // 一般用户
			//
			// break;

			// default:
			// break;
			// }
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return gsjuser;
	}
	
	
	/**
	 * 获取登陆信息
	 * 
	 * @param user
	 *            用户入参字段对象
	 * @return 是否登陆成功
	 */
	@RequestMapping(value = "/user/logininfo/{gsjcookie}",produces = "application/json;charset=utf-8")  //加上 produces 防止中文乱码
	@ResponseBody
	public String getLoginInfo(@PathVariable String gsjcookie) {
		return userservice.getLoginInfo(gsjcookie);
	}
	
	
	/**
	 * 根据用户id更新用户信息
	 * @param gsjcookie
	 * @return
	 */
	@RequestMapping(value = "/user/updateuser",produces = "application/json;charset=utf-8")  //加上 produces 防止中文乱码
	@ResponseBody
	public String updateUserInfo(GsjUser user) {
		return userservice.updateUserinfo(user);
	}
	
	

	
	/**
	 * 更新redis中的用户信息，根据cookie
	 * 
	 * @param gsjcookie
	 * @return
	 */
	@RequestMapping(value = "/user/updateredis/{cookie}",produces = "application/json;charset=utf-8")  //加上 produces 防止中文乱码
	@ResponseBody
	public GsjUser updateUserInfo(@PathVariable String cookie) {
		return userservice.updateUserRedis(cookie);
	}
	


}
