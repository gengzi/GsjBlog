package club.gsjglob.tools;

/**
 * jedis 常用操作接口
 * 
 * @author gengzi
 * @time 2018年3月23日10:42:32
 *
 */
public interface JedisClient {

	/**
	 *  String set key 和 value
	 * @param key
	 * @param value
	 * @return
	 */
	String set(String key, String value);

	/**
	 *  根据key 获取value
	 * @param key
	 * @return
	 */
	String get(String key);

	/**
	 * 判断是否存在
	 * @param key  key
	 * @return boolean
	 */
	Boolean exists(String key);

	Long expire(String key, int seconds);

	Long ttl(String key);

	Long incr(String key);

	Long hset(String key, String field, String value);

	String hget(String key, String field);

	Long hdel(String key, String... field);
	
	Long del(String key);

}
