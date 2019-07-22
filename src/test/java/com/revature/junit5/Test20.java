package com.revature.junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;
import com.revature.questions.Q20;
import com.revature.utils.FicCharacter;

class Test20 {

	@Test
	void testQ20() {
		//load file
		Q20 q20 = new Q20();
		
		//iteract with the first element on the list
		Iterator<FicCharacter> itr = q20.characterList.iterator();
		FicCharacter character = itr.next();
		String expected = character.toString();
		
		String answer = "Name:  Mickey Mouse\nAge: 35 years\nState: Arizona State";
		
		assertEquals(answer,expected);		
	}

}
