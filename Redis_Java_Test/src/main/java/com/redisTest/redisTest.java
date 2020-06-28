package com.redisTest;

/**
 * @author RZ
 * @date 2020/6/28 17:37
 */
public class redisTest {

    public static void main(String[] args) {
        util u =new util();
        u.connects();
        u.SetRedis("keys","hello,man");
        u.GetRedis("keys");
    }
}
