package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.exception.EncoderException;
import com.sanket.model.ResponseToUser;
import com.sanket.model.UserResponse;
import com.sanket.service.DecoderService;

@RestController
public class DecoderController {
	
	@Autowired
	DecoderService decoderService;
	
	@CrossOrigin
	@PostMapping("/decode")
	public ResponseEntity<ResponseToUser> encodeTheString(@RequestBody UserResponse userResponse) throws EncoderException{
		
		String userString = userResponse.getResponse();
		
		System.out.println("****");
		System.out.println(userString);
		System.out.println("*****");
		
		ResponseToUser responseToUser = new ResponseToUser();
		
		String decodedString = decoderService.decodeTheString(userString);
		
		
		
		responseToUser.setMorseCode(decodedString);
		
		System.out.println("****");
		System.out.println(decodedString);
		System.out.println("*****");
		
		return new ResponseEntity<>(responseToUser, HttpStatus.OK);
		
	}

}

