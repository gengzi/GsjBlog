package club.gsjglob.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import club.gsjglob.service.IUserService;

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
		System.out.println("拦截了");
		System.out.println("路径"+request.getServletPath().toString());
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
