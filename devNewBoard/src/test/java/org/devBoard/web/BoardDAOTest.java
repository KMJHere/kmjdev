package org.devBoard.web;

import javax.inject.Inject;

import org.devBoard.domain.BoardVO;
import org.devBoard.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {	
	@Inject 
	private BoardDAO dao;
	
	private Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);    
	
	@Test
	public void testInsertBoard()throws Exception {		
		BoardVO vo = new BoardVO();
		
		vo.setbno(2);
		vo.settitle("제목입력");
		vo.setcontent("내용입니다 내용");
		vo.setwriter("김민정");
		
		dao.create(vo);  
	}
	
	@Test
	public void testUpdateBoard()throws Exception {
		BoardVO vo = new BoardVO();
		
		vo.setbno(1);
		vo.settitle("변경된 제목");
		vo.setcontent("내용도 변경");
		
		dao.update(vo);
	}
	
	@Test
	public void testRead()throws Exception {
		//logger.info(dao.read(1).toString()); 
	}

}
