package com.zjc.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestRedis {

	@Autowired
	private Jedis jedis;
	@Test
	public void testRedis() throws Exception {
		
		Jedis jedis = new Jedis("192.168.40.132",6379);
//		jedis.set("pno","1000");
		Long pno = jedis.incr("pno");
		System.out.println(pno);
		jedis.close();
	}
}