package com.cloudmt.practice.model.dao;

import java.util.List;

import com.cloudmt.practice.model.dto.MemberDTO;

public interface MemberDAO {

	public void insert(MemberDTO dto) throws Exception;	// create. 회원 등록
	public List<MemberDTO> getList() throws Exception;		// read. 회원 리스트 조회
	public MemberDTO detail(int idx) throws Exception;	// read. 회원 상세정보 조회
	public void update(MemberDTO dto) throws Exception;	// update. 회원 정보 수정
	public void delete(int idx) throws Exception;		// delete. 회원 정보 삭제
	
	// update, delete 시 password 체크
	//public boolean check_password(String id, String password) throws Exception;
}
