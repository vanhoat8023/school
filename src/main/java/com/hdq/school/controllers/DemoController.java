package com.hdq.school.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdq.school.common.enums.MessageType;
import com.hdq.school.common.utils.ContextUtils;
import com.hdq.school.dtos.requests.DemoRequest;
import com.hdq.school.dtos.responses.DemoResponse;
import com.hdq.school.dtos.responses.common.MessageRes;
import com.hdq.school.services.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	private DemoService demoService;

	@GetMapping("/demo/{id}")
	public DemoResponse getDemo(@PathVariable Long id) {
		return demoService.getDemo(id);
	}

	@PostMapping("/demo")
	public ResponseEntity<MessageRes<String>> createDemo(@RequestBody DemoRequest request) {
		return ResponseEntity.ok(new MessageRes<String>(MessageType.INFO, ContextUtils.getMessage("a")));
	}
}
