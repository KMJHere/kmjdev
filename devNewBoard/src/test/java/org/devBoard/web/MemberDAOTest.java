package org.devBoard.web;

import javax.inject.Inject;

import org.devBoard.domain.MemberVO;
import org.devBoard.persistence.MemberDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {
	
	@Inject 
	private MemberDAO dao;
	
	@Test
	public void testTime()throws Exception {
		System.out.print(dao.getTime());
	}
	
	@Test
	public void testInserMember()throws Exception {
		
		MemberVO vo = new MemberVO();
		vo.setUserid("kmjp");
		vo.setUserpw("1234");
		vo.setUsername("±ËπŒ¡§");
		vo.setEmail("znr119@naver.com");
		
		dao.insertMember(vo);
	}

}
