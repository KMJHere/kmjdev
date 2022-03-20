package org.devBoard.persistence;

import javax.inject.*;

import org.apache.ibatis.session.SqlSession;
import org.devBoard.domain.MemberVO;
import org.springframework.stereotype.Repository;  

@Repository
public class MemberDAOImpl implements MemberDAO{ 
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.devBoard.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");		
	}
	
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert(namespace+".insertMember", vo);
	}	
}
