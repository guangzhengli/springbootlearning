package com.ligz.jdbctemplate;

import com.ligz.jdbctemplate.jpa.Teather;
import com.ligz.jdbctemplate.jpa.TeatherRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * author:ligz
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {
	@Autowired
	TeatherRepository teatherRepository;

	@Before
	public void delete(){
		teatherRepository.deleteAllInBatch();
	}

	@Test
	public void test() throws Exception {
		// 创建10条记录
		teatherRepository.save(new Teather("AAA", 10));
		teatherRepository.save(new Teather("BBB", 20));
		teatherRepository.save(new Teather("CCC", 30));
		teatherRepository.save(new Teather("DDD", 40));
		teatherRepository.save(new Teather("EEE", 50));
		teatherRepository.save(new Teather("FFF", 60));
		teatherRepository.save(new Teather("GGG", 70));
		teatherRepository.save(new Teather("HHH", 80));
		teatherRepository.save(new Teather("III", 90));
		teatherRepository.save(new Teather("JJJ", 100));

		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, teatherRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的Teather
		Assert.assertEquals(60, teatherRepository.findByName("FFF").getAge().longValue());

		// 测试findTeather, 查询姓名为FFF的Teather
		Assert.assertEquals(60, teatherRepository.findTeather("FFF").getAge().longValue());

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的Teather
		Assert.assertEquals("FFF", teatherRepository.findByNameAndAge("FFF", 60).getName());

		// 测试删除姓名为AAA的Teather
		teatherRepository.delete(teatherRepository.findByName("AAA"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, teatherRepository.findAll().size());

	}
}
