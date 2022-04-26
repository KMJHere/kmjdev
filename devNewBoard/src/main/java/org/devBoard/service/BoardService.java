package org.devBoard.service;

import java.util.List;

import org.devBoard.domain.BoardVO;
import org.devBoard.domain.Criteria;

public interface BoardService {
	public void regist(BoardVO board)throws Exception;
	
	public BoardVO read(Integer bno)throws Exception;
	
	public void modify(BoardVO board)throws Exception;
	
	public void remove(Integer bno)throws Exception;
	
	public List<BoardVO> listAll()throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri)throws Exception;
}
