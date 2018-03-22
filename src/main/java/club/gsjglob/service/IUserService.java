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
	
	

}
