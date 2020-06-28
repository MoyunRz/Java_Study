package com.redisTest;

import redis.clients.jedis.Jedis;

/**
 * @author RZ
 * @date 2020/6/28 17:37
 */
public class util {
   private Jedis jedis ;

    public void connects(){
        //连接本地的 Redis 服务
        jedis = new Jedis("localhost");
    }

    public void SetRedis(String keys,String rValue){
        jedis.set(keys, rValue);
    }
    public void GetRedis(String keys){
        System.out.println("获取："+jedis.get(keys));
    }
}

