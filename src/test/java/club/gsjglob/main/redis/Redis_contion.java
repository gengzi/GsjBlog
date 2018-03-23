package club.gsjglob.main.redis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import club.gsjglob.tools.JedisClient;
import club.gsjglob.tools.JedisClientPool;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 单机版请求redis
 * @author Administrator
 *
 */
public class Redis_contion {

	@Test
	public void testJedis() throws Exception {
		// 第一步：创建一个Jedis对象。需要指定服务端的ip及端口。
		Jedis jedis = new Jedis("123.206.30.117", 6379);
		// 提交redis 的验证密码
		 jedis.auth("gengzi666");  
		// 第二步：使用Jedis对象操作数据库，每个redis命令对应一个方法。
		Long result = jedis.setnx("hello", "11");
		String string = jedis.get("hello");
		
		// 第三步：打印结果。
		System.out.println(string);
		// 第四步：关闭Jedis
		jedis.close();
	}
	
	
	@Test
	public void testJedisPool() throws Exception {
		// 第一步：创建一个JedisPool对象。需要指定服务端的ip及端口。
		JedisPool jedisPool = new JedisPool("123.206.30.117", 6379);
		// 第二步：从JedisPool中获得Jedis对象。
		Jedis jedis = jedisPool.getResource();
		 jedis.auth("gengzi666");  
		// 第三步：使用Jedis操作redis服务器。
		jedis.set("jedis", "test");
		String result = jedis.get("jedis");
		System.out.println(result);
		// 第四步：操作完毕后关闭jedis对象，连接池回收资源。
		jedis.close();
		// 第五步：关闭JedisPool对象。
		jedisPool.close();
	}

	
	@Test
	public void testJedisClient() throws Exception {
		//初始化Spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/spring-*.xml");
		//从容器中获得JedisClient对象
		JedisClient jedisClient = applicationContext.getBean(JedisClient.class);
		jedisClient.set("first", "100");
		String result = jedisClient.get("first");
		System.out.println(result);
		
				
	}


}
