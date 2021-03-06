package com.cloudmt.practice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloudmt.practice.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired // 의존성 주입
	SqlSession sqlSession; // MyBatis session

	// create. 회원 등록
	@Override
	public void insert(MemberDTO dto) throws Exception {
		sqlSession.insert("member.insert", dto);
	}

	// read. 회원 리스트 조회
	@Override
	public List<MemberDTO> getList() throws Exception {
		// "member.getList": mapper.xml 파일의 "namespace.태그 id"
		return sqlSession.selectList("member.getList");	
	}

	// read. 회원 상세정보 조회
	@Override
	public MemberDTO detail(int idx) throws Exception {
		// selectOne(): 레코드 1개, selectList(): 1개 이상
		return sqlSession.selectOne("member.detail", idx);
	}

	// update. 회원 정보 수정
	@Override
	public void update(MemberDTO dto) throws Exception {
		sqlSession.update("member.update", dto);
	}

	// delete. 회원 정보 삭제
	@Override
	public void delete(int idx) throws Exception {
		sqlSession.delete("member.delete", idx);
	}

	/*
	// update, delete 시 password 체크
	@Override
	boolean check_password(String id, String password) throws Exception {
		
		boolean result = false;
		
		// MyBatis mapper로 전달할 값이 2개 이상인 경우(id와 password)
		// selectOne()의 파라미터로 한 개만 보낼 수 있기 때문에 Map(또는 dto)으로 전달
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);
		
		// mapper의 sql문에서 selcet count(*) 결과 받아와서 count에 저장
		int count = sqlSession.selectOne("member.check_password", map);
		
		// 레코드가 1개면 true, 0개면 false 리턴
		if(count == 1)
			result = true;
		
		return result;
	}
	*/
}
