package com.cloudmt.practice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cloudmt.practice.model.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired // ������ ����
	SqlSession sqlSession; // MyBatis session

	// create. ȸ�� ���
	@Override
	public void insert(MemberDTO dto) throws Exception {
		sqlSession.insert("member.insert", dto);
	}

	// read. ȸ�� ����Ʈ ��ȸ
	@Override
	public List<MemberDTO> getList() throws Exception {
		// "member.getList": mapper.xml ������ "namespace.�±� id"
		return sqlSession.selectList("member.getList");	
	}

	// read. ȸ�� ������ ��ȸ
	@Override
	public MemberDTO detail(int idx) throws Exception {
		// selectOne(): ���ڵ� 1��, selectList(): 1�� �̻�
		return sqlSession.selectOne("member.detail", idx);
	}

	// update. ȸ�� ���� ����
	@Override
	public void update(MemberDTO dto) throws Exception {
		sqlSession.update("member.update", dto);
	}

	// delete. ȸ�� ���� ����
	@Override
	public void delete(int idx) throws Exception {
		sqlSession.delete("member.delete", idx);
	}

	/*
	// update, delete �� password üũ
	@Override
	boolean check_password(String id, String password) throws Exception {
		
		boolean result = false;
		
		// MyBatis mapper�� ������ ���� 2�� �̻��� ���(id�� password)
		// selectOne()�� �Ķ���ͷ� �� ���� ���� �� �ֱ� ������ Map(�Ǵ� dto)���� ����
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", password);
		
		// mapper�� sql������ selcet count(*) ��� �޾ƿͼ� count�� ����
		int count = sqlSession.selectOne("member.check_password", map);
		
		// ���ڵ尡 1���� true, 0���� false ����
		if(count == 1)
			result = true;
		
		return result;
	}
	*/
}
