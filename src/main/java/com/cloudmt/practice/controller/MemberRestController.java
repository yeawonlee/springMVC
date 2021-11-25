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

	// 회원 리스트 조회 (GET) - ok
	@GetMapping("/members")
	public ResponseEntity<List<MemberDTO>> getList() throws Exception {
		// ResponseEntity: Response 메세지를 보낼 때 status, headers, body 정보를 담아서 넘겨 줌
		
		List<MemberDTO> memberList = service.getList();
		
		if (memberList.isEmpty()) {	// 멤버가 없을 때는 body 부분을 넣을 필요 X 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // status만 지정 
		}
		
		// 멤버들이 있을 때는 body에 멤버 리스트 전달 		// status, body
		return new ResponseEntity<List<MemberDTO>>(memberList, HttpStatus.OK);
		// 객체(memberList)가 Response 메세지의 body부분에 json format으로 변환해서 날아감
	}

	// 회원 상세정보 view (GET) - ok
	@GetMapping("/members/{idx}")
	public ResponseEntity<MemberDTO> detail(@PathVariable("idx") int idx) throws Exception {
		
		MemberDTO dto = service.detail(idx);
		return new ResponseEntity<MemberDTO>(dto, HttpStatus.OK);
	}

	/*
	// 회원 등록 폼으로 이동
	@RequestMapping(value = "/members/form") 
	public String write() throws Exception { 
		// System.out.println("MemberController로 왔음"); 
		\return "write";
	}
	*/

	// 폼에 입력한 회원 정보 삽입 (POST) - ok
	@PostMapping("/members")
	public ResponseEntity<Void> insert(@RequestBody MemberDTO dto, 
			UriComponentsBuilder ucBuilder) throws Exception {
		service.insert(dto);
		//return "redirect:/members"; // 다시 목록으로
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/members/{idx}")
				.buildAndExpand(dto.getIdx()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// 회원 정보 수정 (PATCH 일부 수정) - ok
	@PatchMapping("/members/{idx}")
	public ResponseEntity<MemberDTO> update(@PathVariable("idx") int idx, 
			@RequestBody MemberDTO dto) throws Exception {
		
		// 비밀번호 체크
		// boolean result = memberDao.check_password(dto.getId(), dto.getPassword());
		
		// if (result) { 
			service.update(dto);
			// return "redirect:/members";
		return new ResponseEntity<MemberDTO>(dto, HttpStatus.OK);
		//} else { 
			//model.addAttribute("dto", dto); 
			//model.addAttribute("message", "비밀번호가 일치하지 않습니다."); 
		//return "detail"; 
		//return new ResponseEntity<MemberDTO>(dto, HttpStatus.UNAUTHORIZED);
	}

	// 회원 정보 삭제 (DELETE) - ok
	@DeleteMapping("/members/{idx}")
	public ResponseEntity<Void> delete(@PathVariable("idx") int idx) throws Exception {
		service.delete(idx);
		
		//return "redirect:/members";
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		//model.addAttribute("dto", memberDao.detail(idx));
		//model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
		//return "detail";
		//return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}
