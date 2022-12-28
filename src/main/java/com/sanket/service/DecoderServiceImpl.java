package com.sanket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.dao.MorseCodeAlphabetDao;

@Service
public class DecoderServiceImpl implements DecoderService {
	
	@Autowired
	MorseCodeAlphabetDao morseCodeAlphabetDao;

	@Override
	public String decodeTheString(String string) {
		
		String[] stringInArr = string.split(" / ");
		
		String finalString = "";
		
		for(String eachString: stringInArr) {
				
				String[] eachCharString = eachString.split(" ");
				
				for(int j = 0; j<=eachCharString.length-1; j++) {
					
					String morseToString = morseCodeAlphabetDao.findByMorseCode(eachCharString[j]).getWord();
					
					finalString += morseToString;
					
				}	

			finalString += " ";

		}
		
		return finalString;
		
	}
	

}
