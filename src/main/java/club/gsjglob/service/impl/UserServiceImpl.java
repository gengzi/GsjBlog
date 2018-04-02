package club.gsjglob.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import club.gsjglob.dao.GsjUserMapper;
import club.gsjglob.domain.GsjUser;
import club.gsjglob.domain.GsjUserExample;
import club.gsjglob.domain.GsjUserExample.Criteria;
import club.gsjglob.dto.User;
import club.gsjglob.service.IUserService;
import club.gsjglob.tools.GsjParams;
import club.gsjglob.tools.JedisClient;

/**
 * 用户登陆的serviceimpl
 * 
 * @author gengzi
 * @time 2018年3月22日10:40:39
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private GsjUserMapper userdao;

	@Autowired
	private JedisClient jedisClient;

	@Override
	public GsjUser login(User user) {
		GsjUserExample example = new GsjUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(user.getAdminname());
		createCriteria.andPasswordEqualTo(user.getAdminpasswd());
		List<GsjUser> gsjUserlist = userdao.selectByExample(example);
		if (gsjUserlist.size() == 1) {
			GsjUser gsjUser = gsjUserlist.get(0);
			return gsjUser;
		} else {
			// 验证失败
			return new GsjUser();
		}
	}

	@Override
	public String getLoginInfo(String gsjcookie) {
		// 从cookie 中拿到token,并查询用户信息
		String userinfo = null;
		if (jedisClient.exists(gsjcookie)) {
			userinfo = jedisClient.get(gsjcookie);
			// 重新设置该token 的ttl
			// 设置超时时间
			jedisClient.expire(gsjcookie, GsjParams.SESSION_EXPIRE);
		}
		return userinfo;
	}

	@Override
	public String updateUserinfo(GsjUser user) {
		int updateByPrimaryKey = userdao.updateByPrimaryKeySelective(user);
		if (updateByPrimaryKey > 0) {
			return "{\"message\":\"success\"}";
		}
		return "{\"message\":\"error\"}";
	}

	@Override
	public GsjUser updateUserRedis(String cookie) {
		try {
			if (jedisClient.exists(cookie)) {
				// 先查询最新的user信息，再设置到redis中。
				String json = jedisClient.get(cookie);
				ObjectMapper mapper = new ObjectMapper();
				GsjUser user = mapper.readValue(json, GsjUser.class);
				GsjUser selectUser = userdao.selectByPrimaryKey(user.getUserid());
				ObjectMapper mapperblog = new ObjectMapper();
				String userjson = mapperblog.writeValueAsString(selectUser);
				jedisClient.set(cookie, userjson);
				jedisClient.expire(cookie, GsjParams.SESSION_EXPIRE);
				return selectUser;
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}catch (IOException e ) {
			e.printStackTrace();
		}
		return  null;
	}

}
