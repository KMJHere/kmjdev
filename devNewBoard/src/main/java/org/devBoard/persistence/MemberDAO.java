package org.devBoard.persistence;

import org.devBoard.domain.MemberVO;

public interface MemberDAO {
	public String getTime();  
	
	public void insertMember(MemberVO vo); 

}
