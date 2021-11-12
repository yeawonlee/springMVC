package com.cloudmt.practice.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void insert(MemberDTO dto) {
		sqlSession.insert("member.insert", dto);
	}

	// read. ȸ�� ����Ʈ ��ȸ
	@Override
	public List<MemberDTO> list() {
		// "member.list": mapper.xml ������ "namespace.�±� id"
		return sqlSession.selectList("member.list");	
	}

	// read. ȸ�� ������ ��ȸ
	@Override
	public MemberDTO detail(String id) {
		// selectOne(): ���ڵ� 1��, selectList(): 1�� �̻�
		return sqlSession.selectOne("member.detail", id);
	}

	// update. ȸ�� ���� ����
	@Override
	public void update(MemberDTO dto) {
		sqlSession.update("member.update", dto);
	}

	// delete. ȸ�� ���� ����
	@Override
	public void delete(String id) {
		sqlSession.delete("member.delete", id);
	}

	// update, delete �� password üũ
	@Override
	public boolean check_password(String id, String password) {
		
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

}
