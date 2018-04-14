package club.gsjglob.service;

import java.util.Map;

/**
 * 处理微信service
 * @author gengzi
 * @time 2018年4月14日22:56:27
 *
 */
public interface IWeiXinService {
	
	/**
	 * 处理请求参数转换后的 map
	 * @param map
	 * @return
	 */
	String processRequest(Map<String,String> map);
	
	

}
