package club.gsjglob.tools;

import java.io.Serializable;


/**
 *  项目的全局常量
 * @author gengzi
 * @time 2018年3月23日14:15:37
 *
 */
public class GsjParams  implements Serializable{

	// 设置单点登陆的session过期时间  redis 中以秒为单位
	public static final Integer SESSION_EXPIRE = 30*60; 
	// 设置cookie 的名称
	public static final String GSJCOOKIE =  "gsjcookie";
	
	
}

