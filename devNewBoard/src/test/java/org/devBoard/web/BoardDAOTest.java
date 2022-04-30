package org.devBoard.web;

import java.util.List;

import javax.inject.Inject;

import org.devBoard.domain.BoardVO;
import org.devBoard.domain.Criteria;
import org.devBoard.persistence.BoardDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
		vo.settitle("������");
		vo.setcontent("�����Դϴ� ����");
		vo.setwriter("�����");
		
		dao.create(vo);  
	}
	
	@Test
	public void testUpdateBoard()throws Exception {
		BoardVO vo = new BoardVO();
		
		vo.setbno(1);
		vo.settitle("����� ����");
		vo.setcontent("���뵵 ����");
		
		dao.update(vo);
	}
	
	@Test
	public void testDeleteBoard()throws Exception {		
		dao.delete(1);
	}
	
	@Test
	public void testRead()throws Exception {
		logger.info(dao.read(1).toString()); 
	}
	
	@Test
	public void testListPage()throws Exception {
		int page = 3;
		
		List<BoardVO> list = dao.listPage(page);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getbno() + ":" + boardVO.gettitle());
		}
	}
	
	@Test
	public void testListCriteria()throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getbno() + ":" + boardVO.gettitle());
		}
	}
	
	@Test
	public void testURI()throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/board/read")
																		.queryParam("bno", 12).queryParam("perPageNum", 20).build();
		
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}
	
	@Test
	public void testURI2()throws Exception{
		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/{module}/{page}")
																		.queryParam("bno", 12)
																		.queryParam("perPageNum", 20)
																		.build()
																		.expand("board", "read")
																		.encode();
		logger.info("/board/read?bno=12&perPageNum=20");
		logger.info(uriComponents.toString());
	}

}
