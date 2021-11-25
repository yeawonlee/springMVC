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
	MemberDAO memberDao;	// 인터페이스 객체
	
	// 회원 리스트 조회 (GET)
	@GetMapping("/members")
	public String list(Model model) throws Exception {
		
		System.out.println("MemberController @GetMapping");
		
		/* 인터페이스를 구현한 클래스(MemberDAOImpl)의 list() 호출 → mapper의 sql문 실행
		   → 레코드들이 ArrayList로 만들어져서 넘어옴   * /
		List<MemberDTO> list = memberDao.list();
		
		// model에 items이라는 이름으로 담아서 전달
		model.addAttribute("items", list);	// "변수명", value
		
		return "list";
	}
	
	// 회원 등록 폼으로 이동
	@RequestMapping(value = "/members/form")
	public String write() throws Exception {
		//System.out.println("MemberController로 왔음");
		return "write";
	}
	
	// 폼에 입력한 회원 정보 삽입 (POST)
	@PostMapping("/members")
	public String insert(@ModelAttribute MemberDTO dto) throws Exception {
		System.out.println("MemberController @PostMapping");
		
		memberDao.insert(dto);
		return "redirect:/members";	// 다시 목록으로
	}
	
	// 회원 상세정보 view (GET)
	//@RequestMapping(value = "/members/{idx}", method = {RequestMethod.GET, RequestMethod.POST} )
	@GetMapping("/members/{idx}")
	public String view(@PathVariable("idx") int idx, Model model) throws Exception {
		
		System.out.println("MemberController @GetMapping 상세정보 페이지");
		
		// model에 회원 정보 담아서 전달
		model.addAttribute("dto", memberDao.detail(idx));
		
		return "detail";	// detail.jsp로 forwarding
	}
	
	/*------------------------------- ok ------------------------------- * /
	
	//회원 정보 수정 (PATCH)
	@PatchMapping("/members/{idx}")
	//@RequestMapping(value = "/members/{idx}", method = RequestMethod.PATCH)
	public String update(@PathVariable("idx") int idx, @ModelAttribute MemberDTO dto, Model model) throws Exception {
		
		System.out.println("MemberController @PatchMapping");
		
		// 비밀번호 체크
		boolean result = memberDao.check_password(dto.getId(), dto.getPassword());
		
		if(result) {
			memberDao.update(dto);
			return "redirect:/members";
		} else {
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "detail";
		}
	}
	
	// 회원 정보 삭제 (DELETE)
	@DeleteMapping("/members/{idx}")
	//@RequestMapping(value = "/members/{idx}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("idx") int idx, @RequestParam String id, @RequestParam String password,
			Model model) throws Exception {
		
		System.out.println("MemberController @DeleteMapping");
		
		// 비밀번호 체크
		boolean result = memberDao.check_password(id, password);
		
		if(result) {
			memberDao.delete(idx);
			return "redirect:/members";
		} else {
			model.addAttribute("dto", memberDao.detail(idx));
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "detail";
		}
	}
}
*/