package club.gsjglob.dao.mapper.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import club.gsjglob.dao.mapper.UserMapper;
import club.gsjglob.domain.User;


@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})

public class MyTest{
	
	@Resource
	private UserMapper mapper = null;
	
	@Test
	public void fun01(){
		User user = new User();
		user.setId(1);
		User selectOne = mapper.selectOne(user);
		System.out.println(selectOne);
		
		
		
		
	}
	
	
}
