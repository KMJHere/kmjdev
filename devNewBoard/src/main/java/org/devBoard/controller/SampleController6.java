package org.devBoard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.devBoard.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController6 {
	// 문자 -> text/html
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	// 객체 -> json
	@RequestMapping("/sendVO")
	public SampleVO sendVO() {
		SampleVO vo = new SampleVO();
		vo.setFirstName("민정"); 
		vo.setLastName("김");
		vo.setMno(123); 
		
		return vo;
		
	}
	
	// 컬렉션 타입 객체 반환 > List
	@RequestMapping("/sendList")
	public List<SampleVO> sendList() {
		List<SampleVO> list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("민정"); 
			vo.setLastName("김");
			vo.setMno(i);
			
			list.add(vo);
		}
		
		return list;
	}
	
	// 컬렉션 타입 객체 반환 > Map
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer, SampleVO> map = new HashMap<>();
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("민정"); 
			vo.setLastName("김");
			vo.setMno(i);
			
			map.put(i, vo);			
		}
		
		return map;
	}
	
	// HTTP 상태 코드 제어 => 400번 전송
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	// 결과데이터 + HTTP 상태코드
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot() {
		List<SampleVO> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("민정"); 
			vo.setLastName("김");
			vo.setMno(i);
			
			list.add(vo);
		}
		
		return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
	
}
