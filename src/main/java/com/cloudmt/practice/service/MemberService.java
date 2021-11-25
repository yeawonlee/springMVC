package com.cloudmt.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cloudmt.practice.model.dto.MemberDTO;

@Service
public interface MemberService {

	public void insert(MemberDTO dto) throws Exception;	// create. ȸ�� ���
	public List<MemberDTO> getList() throws Exception;	// read. ȸ�� ����Ʈ ��ȸ
	public MemberDTO detail(int idx) throws Exception;	// read. ȸ�� ������ ��ȸ
	public void update(MemberDTO dto) throws Exception;	// update. ȸ�� ���� ����
	public void delete(int idx) throws Exception;		// delete. ȸ�� ���� ����
	
	// update, delete �� password üũ
	//public boolean check_password(String id, String password) throws Exception;
}
