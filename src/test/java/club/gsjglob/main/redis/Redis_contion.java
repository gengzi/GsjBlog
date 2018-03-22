package club.gsjglob.main.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

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
		// 第二步：使用Jedis对象操作数据库，每个redis命令对应一个方法。
		Long result = jedis.setnx("hello", "11");
		String string = jedis.get("hello");
		
		// 第三步：打印结果。
		System.out.println(string);
		// 第四步：关闭Jedis
		jedis.close();
	}

}
