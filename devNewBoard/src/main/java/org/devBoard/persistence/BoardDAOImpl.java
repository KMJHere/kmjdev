package org.devBoard.persistence;

import java.util.List;

import javax.inject.*;

import org.apache.ibatis.session.SqlSession;
import org.devBoard.domain.BoardVO;
import org.springframework.stereotype.Repository;  

@Repository
public class BoardDAOImpl implements BoardDAO{    
	@Inject
	private SqlSession session;
	
	private static final String namespace = "org.devBoard.mapper.BoardMapper";
	
	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read", bno);		
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");		
	}
	
	@Override
	public void create(BoardVO vo) throws Exception { 
		session.insert(namespace+".create", vo);    
	}
	
	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update", vo);   
	}
	
	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete", bno);    
	}
}
