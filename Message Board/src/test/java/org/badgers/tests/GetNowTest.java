package org.badgers.tests;

import javax.inject.Inject;

import org.badgers.persistence.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class GetNowTest {

	@Setter(onMethod_ = { @Inject } )
	private UserMapper timeMapper;
	
	@Test
	public void test() {
		log.info(timeMapper.getNow());
	}
}
