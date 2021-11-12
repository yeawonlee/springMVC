package com.cloudmt.practice.model.dao;

import java.util.List;

import com.cloudmt.practice.model.dto.MemberDTO;

public interface MemberDAO {

	public void insert(MemberDTO dto);	// create. ȸ�� ���
	public List<MemberDTO> list();		// read. ȸ�� ����Ʈ ��ȸ
	public MemberDTO detail(String id);	// read. ȸ�� ������ ��ȸ
	public void update(MemberDTO dto);	// update. ȸ�� ���� ����
	public void delete(String id);		// delete. ȸ�� ���� ����
	
	// update, delete �� password üũ
	public boolean check_password(String id, String password);
}
