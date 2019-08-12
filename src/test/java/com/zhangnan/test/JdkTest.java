package com.zhangnan.test;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhangnan.domain.User;
import com.zhangnan.utils.RandomUitl;
import com.zhangnan.utils.StringUtil;

/** 
 * @ClassName: JdkTest 
 * @Description: TODO
 * @author:zn
 * @date: 2019年8月12日 上午9:19:18  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class JdkTest {

	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;
	@Test
	public void test() {
		ArrayList<User> users = new ArrayList<User>();
		for (int i = 0; i < 100000; i++) {
			users.add(new User(i, StringUtil.generateChineseName()+StringUtil.randomChineseString(2), StringUtil.randomChineseString(), "13"+RandomUitl.randomString(9), RandomUitl.randomString(20)+"@qq.com", new Date(i)));
		}
		long startTimes = System.currentTimeMillis();
		for (User user : users) {
			redisTemplate.opsForValue().set("u_"+user.getId(), user);
		}
		long endTimes = System.currentTimeMillis();
		System.out.println("采用JDK系列化的方式所用时间为"+(endTimes-startTimes));
	}

}
