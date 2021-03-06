package cn.zxl.deerlet.redis.client;

/**
 * 
 * deerlet客户端的客户端操作接口，其中定义了本组件支持的redis操作。
 *
 * @author zuoxiaolong
 * @since 2015 2015年3月6日 下午11:37:35
 *
 */
public interface DeerletRedisClient {

	/**
	 * 存储一对键值对
	 * @param key
	 * @param value
	 * @return 是否成功
	 */
	public boolean set(String key, Object value);
	
	/**
	 * 给当前key中存储的值追加value
	 * @param key
	 * @param value
	 * @return 追加以后value的总长度
	 */
	public int append(String key,String value);

	/**
	 * 根据键获取值
	 * @param key
	 * @return 对应的value
	 */
	public String get(String key);

	/**
	 * 刷新所有db，将清空所有db中的键值对
	 * @return 是否成功
	 */
	public boolean flushAll();
	
	/**
	 * 刷新当前db，将清空所有db中的键值对
	 * @return 是否成功
	 */
	public boolean flushDb();

	/**
	 * 返回当前db的大小
	 * @return 大小
	 */
	public int dbSize();
	
	/**
	 * 开启一个线程进行持久化操作
	 * @return 是否成功
	 */
	public boolean bgSave();
	
	/**
	 * 把当前key中存储的值减去1
	 * @param key
	 * @return 当前存储的值
	 */
	public int decr(String key);
	
	/**
	 * 把当前key中存储的值减去decrement
	 * @param key
	 * @param decrement
	 * @return 当前存储的值
	 */
	public int decrBy(String key, int decrement);

	/**
	 * 根据键删除一个键值对
	 * @param key
	 * @return 删除的个数
	 */
	public int del(String key);
	
	/**
	 * 把当前key中存储的值加上1
	 * @param key
	 * @return 当前存储的值
	 */
	public int incr(String key);
	
	/**
	 * 把当前key中存储的值加上increment
	 * @param key
	 * @param increment
	 * @return 当前存储的值
	 */
	public int incrBy(String key, int increment);
	
	/**
	 * 把当前key中存储的值加上一个浮点数increment
	 * @param key
	 * @param increment
	 * @return 当前存储的值
	 */
	public float incrByFloat(String key, float increment);
	
}
