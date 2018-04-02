package club.gsjglob.service;

import club.gsjglob.domain.GsjUser;
import club.gsjglob.dto.User;

/**
 *  用户管理的service
 * @author gengzi
 * @time 2018年3月22日10:38:56
 *
 */
public interface IUserService {
	
	/**
	 *  登陆
	 * @param user  User 入参实体类
	 * @return  GsjUser 登录人的对象
	 */
	GsjUser login(User user);
	
	/**
	 *  根据token，去redis 中查询用户信息
	 * @return json
	 */
	String getLoginInfo(String token);

	/**
	 * 更新用户信息
	 * @param user user对象
	 * @return json
	 */
	String updateUserinfo(GsjUser user);

	/**
	 * 根据cookie，更新redis用户信息
	 * @param cookie
	 * @return
	 */
	GsjUser updateUserRedis(String cookie);
	
	

}
