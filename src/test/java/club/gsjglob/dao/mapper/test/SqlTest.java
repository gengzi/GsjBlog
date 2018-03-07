package club.gsjglob.dao.mapper.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.gsjglob.dao.mapper.UserMapper;
import club.gsjglob.domain.User;
import club.gsjglob.domain.UserExample;
import club.gsjglob.domain.UserExample.Criteria;

public class SqlTest {
	private ApplicationContext context;
	private SqlSessionFactory factory;

	@Before
	public void befor() {
//		context = new ClassPathXmlApplicationContext("classpath:spring/spring-mybatis.xml");
//		factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");

	}

	@Test
	public void fun01() {
		SqlSession openSession = factory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		UserExample example = new UserExample();
		// 构造查询条件
		Criteria criteria = example.createCriteria();
		criteria.andAddressIsNull();
		List<User> selectByExample = mapper.selectByExample(example);
		for (User user : selectByExample) {
			System.out.println(user.toString());

		}

	}

}
