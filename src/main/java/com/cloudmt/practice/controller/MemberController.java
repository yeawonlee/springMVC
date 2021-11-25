/*
package com.cloudmt.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cloudmt.practice.model.dao.MemberDAO;
import com.cloudmt.practice.model.dto.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	MemberDAO memberDao;	// �������̽� ��ü
	
	// ȸ�� ����Ʈ ��ȸ (GET)
	@GetMapping("/members")
	public String list(Model model) throws Exception {
		
		System.out.println("MemberController @GetMapping");
		
		/* �������̽��� ������ Ŭ����(MemberDAOImpl)�� list() ȣ�� �� mapper�� sql�� ����
		   �� ���ڵ���� ArrayList�� ��������� �Ѿ��   * /
		List<MemberDTO> list = memberDao.list();
		
		// model�� items�̶�� �̸����� ��Ƽ� ����
		model.addAttribute("items", list);	// "������", value
		
		return "list";
	}
	
	// ȸ�� ��� ������ �̵�
	@RequestMapping(value = "/members/form")
	public String write() throws Exception {
		//System.out.println("MemberController�� ����");
		return "write";
	}
	
	// ���� �Է��� ȸ�� ���� ���� (POST)
	@PostMapping("/members")
	public String insert(@ModelAttribute MemberDTO dto) throws Exception {
		System.out.println("MemberController @PostMapping");
		
		memberDao.insert(dto);
		return "redirect:/members";	// �ٽ� �������
	}
	
	// ȸ�� ������ view (GET)
	//@RequestMapping(value = "/members/{idx}", method = {RequestMethod.GET, RequestMethod.POST} )
	@GetMapping("/members/{idx}")
	public String view(@PathVariable("idx") int idx, Model model) throws Exception {
		
		System.out.println("MemberController @GetMapping ������ ������");
		
		// model�� ȸ�� ���� ��Ƽ� ����
		model.addAttribute("dto", memberDao.detail(idx));
		
		return "detail";	// detail.jsp�� forwarding
	}
	
	/*------------------------------- ok ------------------------------- * /
	
	//ȸ�� ���� ���� (PATCH)
	@PatchMapping("/members/{idx}")
	//@RequestMapping(value = "/members/{idx}", method = RequestMethod.PATCH)
	public String update(@PathVariable("idx") int idx, @ModelAttribute MemberDTO dto, Model model) throws Exception {
		
		System.out.println("MemberController @PatchMapping");
		
		// ��й�ȣ üũ
		boolean result = memberDao.check_password(dto.getId(), dto.getPassword());
		
		if(result) {
			memberDao.update(dto);
			return "redirect:/members";
		} else {
			model.addAttribute("dto", dto);
			model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return "detail";
		}
	}
	
	// ȸ�� ���� ���� (DELETE)
	@DeleteMapping("/members/{idx}")
	//@RequestMapping(value = "/members/{idx}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("idx") int idx, @RequestParam String id, @RequestParam String password,
			Model model) throws Exception {
		
		System.out.println("MemberController @DeleteMapping");
		
		// ��й�ȣ üũ
		boolean result = memberDao.check_password(id, password);
		
		if(result) {
			memberDao.delete(idx);
			return "redirect:/members";
		} else {
			model.addAttribute("dto", memberDao.detail(idx));
			model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return "detail";
		}
	}
}
*/