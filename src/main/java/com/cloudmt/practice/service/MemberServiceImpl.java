package com.cloudmt.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudmt.practice.model.dao.MemberDAO;
import com.cloudmt.practice.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public void insert(MemberDTO dto) throws Exception {
		dao.insert(dto);
	}

	@Override
	public List<MemberDTO> getList() throws Exception {
		return dao.getList();
	}

	@Override
	public MemberDTO detail(int idx) throws Exception {
		return dao.detail(idx);
	}

	@Override
	public void update(MemberDTO dto) throws Exception {
		dao.update(dto);
	}

	@Override
	public void delete(int idx) throws Exception {
		dao.delete(idx);
	}

	/*
	@Override
	public boolean check_password(String id, String password) throws Exception {
		return false;
	}
	*/
}
