package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sanket.exception.EncoderException;
import com.sanket.model.ResponseToUser;
import com.sanket.model.UserResponse;
import com.sanket.service.EncoderService;

@RestController
public class EncoderController {
	
	@Autowired
	EncoderService encoderService;
	
	@CrossOrigin
	@PostMapping("/encode")
	public ResponseEntity<ResponseToUser> encodeTheString(@RequestBody UserResponse userResponse) throws EncoderException{
		
		String userString = userResponse.getResponse();
		
		ResponseToUser responseToUser = new ResponseToUser();
		
		String encoderString = encoderService.encodeString(userString);
		
		responseToUser.setMorseCode(encoderString);
		
		return new ResponseEntity<ResponseToUser>(responseToUser, HttpStatus.OK);
		
	}

}
