package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.exception.EncoderException;
import com.sanket.model.UserResponse;
import com.sanket.service.DecoderService;

@RestController
public class DecoderController {
	
	@Autowired
	DecoderService decoderService;
	
	@PostMapping("/decode")
	public ResponseEntity<String> encodeTheString(@RequestBody UserResponse userResponse) throws EncoderException{
		
		String userString = userResponse.getResponse();
		
		String decodedString = decoderService.decodeTheString(userString);
		
		return new ResponseEntity<>(decodedString, HttpStatus.ACCEPTED);
		
	}

}
