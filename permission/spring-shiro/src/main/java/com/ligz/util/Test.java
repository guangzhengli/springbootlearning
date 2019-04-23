package com.ligz.util;

import redis.clients.jedis.Jedis;

/**
 * author:ligz
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new Jedis("172.16.2.163",6379).ping()); //注意将ip和端口号写对
    }
}
