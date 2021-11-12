package com.cloudmt.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cloudmt.practice.model.dao.MemberDAO;
import com.cloudmt.practice.model.dto.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	MemberDAO memberDao;	// �������̽� ��ü
	
	// ȸ�� ����Ʈ ��ȸ
	@RequestMapping("member/list")
	public String list(Model model) {
		
		/* �������̽��� ������ Ŭ����(MemberDAOImpl)�� list() ȣ�� �� mapper�� sql�� ����
		   �� ���ڵ���� ArrayList�� ��������� �Ѿ��   */
		List<MemberDTO> list = memberDao.list();
		
		// model�� items�̶�� �̸����� ��Ƽ� ����
		model.addAttribute("items", list);	// "������", value
		
		return "member/list";
	}
	
	// ȸ�� ��� ������ �̵�
	@RequestMapping("member/write")
	public String write() {
		//System.out.println("MemberController�� ����");
		return "member/write";
	}
	
	// ���� �Է��� ȸ�� ���� ����
	@RequestMapping("member/insert")
	public String insert(@ModelAttribute MemberDTO dto) {
		memberDao.insert(dto);
		return "redirect:/member/list";	// �ٽ� �������
	}
	
	// ȸ�� ������ view
	@RequestMapping("member/view")		// �Ķ���ͷ� list.jsp���� ȸ�� id�� ����
	public String view(@RequestParam String id, Model model) {
		
		// model�� ȸ�� ���� ��Ƽ� ����
		model.addAttribute("dto", memberDao.detail(id));
		
		return "member/detail";	// detail.jsp�� forwarding
	}
	
	//ȸ�� ���� ����
	@RequestMapping("member/update")
	public String update(@ModelAttribute MemberDTO dto, Model model) {
		
		// ��й�ȣ üũ
		boolean result = memberDao.check_password(dto.getId(), dto.getPassword());
		
		if(result) {
			memberDao.update(dto);
			return "redirect:/member/list";
		} else {
			model.addAttribute("dto", dto);
			model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return "member/detail";
		}
	}
	
	// ȸ�� ���� ����
	@RequestMapping("member/delete")
	public String delete(@RequestParam String id, @RequestParam String password,
			Model model) {
		
		// ��й�ȣ üũ
		boolean result = memberDao.check_password(id, password);
		
		if(result) {
			memberDao.delete(id);
			return "redirect:/member/list";
		} else {
			model.addAttribute("dto", memberDao.detail(id));
			model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return "member/detail";
		}
	}
}
