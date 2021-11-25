package com.cloudmt.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cloudmt.practice.model.dto.MemberDTO;
import com.cloudmt.practice.service.MemberService;

@RestController // @Controller + @ResponseBody
public class MemberRestController {

	@Autowired
	MemberService service;

	// ȸ�� ����Ʈ ��ȸ (GET) - ok
	@GetMapping("/members")
	public ResponseEntity<List<MemberDTO>> getList() throws Exception {
		// ResponseEntity: Response �޼����� ���� �� status, headers, body ������ ��Ƽ� �Ѱ� ��
		
		List<MemberDTO> memberList = service.getList();
		
		if (memberList.isEmpty()) {	// ����� ���� ���� body �κ��� ���� �ʿ� X 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // status�� ���� 
		}
		
		// ������� ���� ���� body�� ��� ����Ʈ ���� 		// status, body
		return new ResponseEntity<List<MemberDTO>>(memberList, HttpStatus.OK);
		// ��ü(memberList)�� Response �޼����� body�κп� json format���� ��ȯ�ؼ� ���ư�
	}

	// ȸ�� ������ view (GET) - ok
	@GetMapping("/members/{idx}")
	public ResponseEntity<MemberDTO> detail(@PathVariable("idx") int idx) throws Exception {
		
		MemberDTO dto = service.detail(idx);
		return new ResponseEntity<MemberDTO>(dto, HttpStatus.OK);
	}

	/*
	// ȸ�� ��� ������ �̵�
	@RequestMapping(value = "/members/form") 
	public String write() throws Exception { 
		// System.out.println("MemberController�� ����"); 
		\return "write";
	}
	*/

	// ���� �Է��� ȸ�� ���� ���� (POST) - ok
	@PostMapping("/members")
	public ResponseEntity<Void> insert(@RequestBody MemberDTO dto, 
			UriComponentsBuilder ucBuilder) throws Exception {
		service.insert(dto);
		//return "redirect:/members"; // �ٽ� �������
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/members/{idx}")
				.buildAndExpand(dto.getIdx()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ȸ�� ���� ���� (PATCH �Ϻ� ����) - ok
	@PatchMapping("/members/{idx}")
	public ResponseEntity<MemberDTO> update(@PathVariable("idx") int idx, 
			@RequestBody MemberDTO dto) throws Exception {
		
		// ��й�ȣ üũ
		// boolean result = memberDao.check_password(dto.getId(), dto.getPassword());
		
		// if (result) { 
			service.update(dto);
			// return "redirect:/members";
		return new ResponseEntity<MemberDTO>(dto, HttpStatus.OK);
		//} else { 
			//model.addAttribute("dto", dto); 
			//model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�."); 
		//return "detail"; 
		//return new ResponseEntity<MemberDTO>(dto, HttpStatus.UNAUTHORIZED);
	}

	// ȸ�� ���� ���� (DELETE) - ok
	@DeleteMapping("/members/{idx}")
	public ResponseEntity<Void> delete(@PathVariable("idx") int idx) throws Exception {
		service.delete(idx);
		
		//return "redirect:/members";
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		//model.addAttribute("dto", memberDao.detail(idx));
		//model.addAttribute("message", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		//return "detail";
		//return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}
