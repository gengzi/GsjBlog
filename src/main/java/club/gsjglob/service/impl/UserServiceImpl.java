package club.gsjglob.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import club.gsjglob.dao.GsjUserMapper;
import club.gsjglob.domain.GsjUser;
import club.gsjglob.domain.GsjUserExample;
import club.gsjglob.domain.GsjUserExample.Criteria;
import club.gsjglob.dto.User;
import club.gsjglob.service.IUserService;
import club.gsjglob.tools.GsjParams;
import club.gsjglob.tools.JedisClient;

/**
 *  用户登陆的serviceimpl
 * @author gengzi
 * @time 2018年3月22日10:40:39
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private GsjUserMapper userdao ;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public GsjUser login(User user) {
		GsjUserExample example  = new GsjUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(user.getAdminname());
		createCriteria.andPasswordEqualTo(user.getAdminpasswd());		
		List<GsjUser> gsjUserlist = userdao.selectByExample(example);
		if (gsjUserlist.size() == 1) {
			GsjUser gsjUser = gsjUserlist.get(0);
			return gsjUser;
		}else {
			// 验证失败
			return new GsjUser();
		}
	}

	@Override
	public String getLoginInfo(String gsjcookie) {
		 //从cookie 中拿到token,并查询用户信息
		String userinfo = null;
		if (jedisClient.exists(gsjcookie)) {
			userinfo = jedisClient.get(gsjcookie);
			try {
				userinfo = new String(userinfo.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			//重新设置该token 的ttl
			// 设置超时时间
			jedisClient.expire(gsjcookie, GsjParams.SESSION_EXPIRE);
		}
		return userinfo;
	}


}
