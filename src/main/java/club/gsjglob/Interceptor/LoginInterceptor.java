package club.gsjglob.Interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import club.gsjglob.domain.GsjUser;
import club.gsjglob.service.IUserService;
import club.gsjglob.tools.CookieUtils;

/**
 *  登陆拦截器
 * @author gengzi
 * @time 2018年3月26日10:13:45
 *
 */
public class LoginInterceptor implements HandlerInterceptor{
	
	@Autowired
	private IUserService userservice;
	
	/**
	 *  拦截器，在访问页面的时候，判断该页面是否可以有权限访问
	 *  （1） 无需登陆，都可以访问的页面
	 *  （2）普通用户登陆即可，访问的页面
	 *  （3）管理员登陆才可，访问的页面
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
//		System.out.println("拦截了");
//		System.out.println("路径"+request.getServletPath().toString());
		//获取cookie
		//普通用户
		String requesturl = request.getServletPath().toString();
		if (requesturl.contains("admin")) {
			System.out.println("路径"+request.getServletPath().toString());
			String cookieValue = CookieUtils.getCookieValue(request, "gsjcookie");
			//判断是否存在该cookie
			if(cookieValue != null) {
				//判断登陆信息是否过期
				String loginInfo = userservice.getLoginInfo(cookieValue);
				if (loginInfo != null) {
					ObjectMapper mapperblog = new ObjectMapper();
					GsjUser userjson = mapperblog.readValue(loginInfo, GsjUser.class);
					if (userjson.getUsertype() != 1) {
						response.sendRedirect(request.getContextPath()+"/index");  
						return false;
					}
				}
				response.sendRedirect(request.getContextPath()+"/login");  
				return false;
			}
			response.sendRedirect(request.getContextPath()+"/login");  
			return false;
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	

}
