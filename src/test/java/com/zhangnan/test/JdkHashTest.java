package com.zhangnan.test;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashMap;

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
 * @ClassName: JdkHashTest 
 * @Description: TODO
 * @author:zn
 * @date: 2019年8月12日 上午9:19:12  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class JdkHashTest {

	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;
	@Test
	public void test() {
		HashMap<Object,Object> map = new HashMap<>();
		for (int i = 0; i < 100000; i++) {
			map.put("u_"+i, new User(i, StringUtil.generateChineseName()+StringUtil.randomChineseString(2), StringUtil.randomChineseString(), "13"+RandomUitl.randomString(9), RandomUitl.randomString(20)+"@qq.com", new Date(i)));
		}
		long startTimes = System.currentTimeMillis();
		redisTemplate.opsForHash().putAll("u_", map);
		long endTimes = System.currentTimeMillis();
		System.out.println("采用Redis的Hash类型的jdk方式所用时间为"+(endTimes-startTimes));
	}

}
