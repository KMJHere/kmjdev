package org.devBoard.persistence;

import java.util.List;

import javax.inject.*;

import org.apache.ibatis.session.SqlSession;
import org.devBoard.domain.BoardVO;
import org.devBoard.domain.Criteria;
import org.devBoard.domain.SearchCriteria;
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
	public List<BoardVO> listPage(int page) throws Exception {
		if(page <= 0) {
			page = 1;
		}
		
		page = (page -1) * 10;
		
		return session.selectList(namespace + ".listPage", page);
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}
	
	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception { 
		return session.selectList(namespace + ".listSearch", cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
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
