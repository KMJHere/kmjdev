package org.devBoard.persistence;

import java.util.*;

import org.devBoard.domain.BoardVO;
import org.devBoard.domain.Criteria;
import org.devBoard.domain.SearchCriteria;

public interface BoardDAO {	
	public void create(BoardVO vo)throws Exception; 
	
	public BoardVO read(Integer bno)throws Exception;

	public void update(BoardVO vo)throws Exception;
	
	public void delete(Integer bno)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
	
	public List<BoardVO> listPage(int page)throws Exception; 
	
	public List<BoardVO> listCriteria(Criteria cri)throws Exception; 
	
	public int countPaging(Criteria cri)throws Exception;
	
	public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
	
	public int listSearchCount(SearchCriteria cri)throws Exception;
}
