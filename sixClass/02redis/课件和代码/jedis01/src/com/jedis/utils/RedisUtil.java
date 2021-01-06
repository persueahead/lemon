package com.jedis.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;

/** 
 * Redis������,���ڻ�ȡRedisPool. 
 * �ο�����˵�����£� 
 * You shouldn't use the same instance from different threads because you'll have strange errors. 
 * And sometimes creating lots of Jedis instances is not good enough because it means lots of sockets and connections, 
 * which leads to strange errors as well. A single Jedis instance is not threadsafe! 
 * To avoid these problems, you should use JedisPool, which is a threadsafe pool of network connections. 
 * This way you can overcome those strange errors and achieve great performance. 
 * To use it, init a pool: 
 *  JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost"); 
 *  You can store the pool somewhere statically, it is thread-safe. 
 *  JedisPoolConfig includes a number of helpful Redis-specific connection pooling defaults. 
 *  For example, Jedis with JedisPoolConfig will close a connection after 300 seconds if it has not been returned. 
 */  
public class RedisUtil  {  
    protected static Logger log = LoggerFactory.getLogger(RedisUtil.class);  
      
    /** 
     * ˽�й�����. 
     */  
    private RedisUtil() {  
          
    }  
    private static Map<String,JedisPool> maps  = new HashMap<String,JedisPool>();  
      
      
    /** 
     * ��ȡ���ӳ�. 
     * @return ���ӳ�ʵ�� 
     */  
    private static JedisPool getPool(String ip,int port) {  
        String key = ip+":" +port;  
        JedisPool pool = null;  
        if(!maps.containsKey(key)) {  
            JedisPoolConfig config = new JedisPoolConfig();  
            /*config.setMaxActive(RedisConfig.getMaxactive());  
            config.setMaxIdle(RedisConfig.getMaxidle());  
            config.setMaxWait(RedisConfig.getMaxwait());  */
            config.setTestOnBorrow(true);  
            config.setTestOnReturn(true);  
            try{    
                /** 
                 *��������� java.net.SocketTimeoutException: Read timed out exception���쳣��Ϣ 
                 *�볢���ڹ���JedisPool��ʱ�������Լ��ĳ�ʱֵ. JedisPoolĬ�ϵĳ�ʱʱ����2��(��λ����) 
                 */  
                pool = new JedisPool(config, ip, port,2000);  
                maps.put(key, pool);  
            } catch(Exception e) {  
                e.printStackTrace();  
            }  
        }else{  
            pool = maps.get(key);  
        }  
        return pool;  
    }  
    static JedisPool getPool() {  
    	return getPool("192.168.25.128",6379);
    }  
  
    /** 
     *�༶���ڲ��࣬Ҳ���Ǿ�̬�ĳ�Աʽ�ڲ��࣬���ڲ����ʵ�����ⲿ���ʵ�� 
     *û�а󶨹�ϵ������ֻ�б����õ�ʱ�Ż�װ�أ��Ӷ�ʵ�����ӳټ��ء� 
     */  
    private static class RedisUtilHolder{  
        /** 
         * ��̬��ʼ��������JVM����֤�̰߳�ȫ 
         */  
        private static RedisUtil instance = new RedisUtil();  
    }  
  
    /** 
     *��getInstance������һ�α����õ�ʱ������һ�ζ�ȡ 
     *RedisUtilHolder.instance������RedisUtilHolder��õ���ʼ�������������װ�ز�����ʼ����ʱ�򣬻��ʼ�����ľ� 
     *̬�򣬴Ӷ�����RedisUtil��ʵ���������Ǿ�̬�������ֻ���������װ�����ʱ���ʼ��һ�Σ��������������֤�����̰߳�ȫ�ԡ� 
     *���ģʽ���������ڣ�getInstance������û�б�ͬ��������ֻ��ִ��һ����ķ��ʣ�����ӳٳ�ʼ����û�������κη��ʳɱ��� 
     */  
    public static RedisUtil getInstance() {  
        return RedisUtilHolder.instance;  
    }  
      
    /** 
     * ��ȡRedisʵ��. 
     * @return Redis������ʵ�� 
     */  
    public static Jedis getJedis(String ip,int port) {  
        Jedis jedis  = null;  
        int count =0;  
       /* do{  */
            try{   
                jedis = getPool(ip,port).getResource();  
                //log.info("get redis master1!");  
            } catch (Exception e) {  
                log.error("get redis master1 failed!", e);  
                 // ���ٶ���    
                getPool(ip,port).returnBrokenResource(jedis);    
            }  
            count++;  
       /* }while(jedis==null&&count<20);  */
        return jedis;  
    }  
    public static Jedis getJedis() {  
    	return getJedis("192.168.25.128",6379);
    }  
  
    /** 
     * �ͷ�redisʵ�������ӳ�. 
     * @param jedis redisʵ�� 
     */  
    public void closeJedis(Jedis jedis,String ip,int port) {  
        if(jedis != null) {  
            getPool(ip,port).returnResource(jedis);  
        }  
    }  
    public static void closeJedis(Jedis jedis) {  
    	if(jedis != null) {  
    		getPool().returnResource(jedis);  
    	}  
    } 
    
    public static ShardedJedisPool getShardedJedisPool(){
    	JedisPoolConfig poolConfig = new JedisPoolConfig();
    	poolConfig.setMaxTotal(500);
    	poolConfig.setMaxIdle(1000 * 60);
    	poolConfig.setTestOnBorrow(true);
    	
    	List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
    	JedisShardInfo a = new JedisShardInfo("192.168.25.128", 6379);
    	
    	shards.add(a);

    	
    	ShardedJedisPool pool = new ShardedJedisPool(poolConfig, shards, Hashing.MURMUR_HASH);
    	return pool;

    }
}  