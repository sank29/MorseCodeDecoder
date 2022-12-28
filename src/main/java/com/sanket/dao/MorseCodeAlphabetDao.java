package com.sanket.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.model.MorseCodeAlphabet;

public interface MorseCodeAlphabetDao extends JpaRepository<MorseCodeAlphabet, Integer>{
	
	
	public MorseCodeAlphabet findByWord(String string);

}
