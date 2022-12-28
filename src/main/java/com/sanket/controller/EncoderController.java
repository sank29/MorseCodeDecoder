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
import com.sanket.service.EncoderService;

@RestController
public class EncoderController {
	
	@Autowired
	EncoderService encoderService;
	
	
	@GetMapping("/encode/{string}")
	public ResponseEntity<String> encodeTheString(@PathVariable String string) throws EncoderException{
		
		
		String encoderString = encoderService.encodeString(string);
		
		return new ResponseEntity<>(encoderString, HttpStatus.ACCEPTED);
		
	}

}
