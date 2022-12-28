package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.exception.EncoderException;
import com.sanket.model.UserResponse;
import com.sanket.service.EncoderService;

@RestController
public class EncoderController {
	
	@Autowired
	EncoderService encoderService;
	
	
	@PostMapping("/encode")
	public ResponseEntity<String> encodeTheString(@RequestBody UserResponse userResponse) throws EncoderException{
		
		String userString = userResponse.getResponse();
		
		String encoderString = encoderService.encodeString(userString);
		
		return new ResponseEntity<>(encoderString, HttpStatus.ACCEPTED);
		
	}
	
	

}
