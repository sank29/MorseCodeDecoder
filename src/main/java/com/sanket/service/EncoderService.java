package com.sanket.service;

import com.sanket.exception.EncoderException;

public interface EncoderService {
	
	public String encodeString(String string) throws EncoderException;

}
