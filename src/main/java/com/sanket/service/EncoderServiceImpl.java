package com.sanket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.dao.MorseCodeAlphabetDao;
import com.sanket.exception.EncoderException;

@Service
public class EncoderServiceImpl implements EncoderService{
	
	@Autowired
	MorseCodeAlphabetDao morseCodeAlphabetDao;

	@Override
	public String encodeString(String string) throws EncoderException {
		
		String[] stringInArray = string.split(" ");
		
		String encoderString = "";
		
		for(String str: stringInArray) {
			
			for(int i=0; i<=str.length()-1; i++) {
				
				Character smallString = str.charAt(i);
				
				String capitalString = smallString.toString().toUpperCase();
				
				System.out.println(capitalString);		
				
				String morseCode = morseCodeAlphabetDao.findByWord(capitalString).getMorseCode();
				
				encoderString += morseCode + " ";
				
			}
			
		}
		
		return encoderString;
		
	}

}























