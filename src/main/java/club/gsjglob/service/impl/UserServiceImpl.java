package club.gsjglob.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.gsjglob.dao.GsjUserMapper;
import club.gsjglob.domain.GsjUser;
import club.gsjglob.domain.GsjUserExample;
import club.gsjglob.domain.GsjUserExample.Criteria;
import club.gsjglob.dto.User;
import club.gsjglob.service.IUserService;

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

}
