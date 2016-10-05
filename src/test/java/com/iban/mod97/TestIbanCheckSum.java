package com.iban.mod97;


import static junit.framework.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class TestIbanCheckSum {
	@SuppressWarnings("deprecation")
	@Test
	public void testMod97(){
		String iban="AL4721210090000000235698741"; // FR1420041010050500013M02607: wrong
		String ibanModified=iban.trim().substring(4,iban.length()) +iban.trim().substring(0,4);  // 1.Move the four initial characters to the end of the string
		char [] tocharArr=ibanModified.toCharArray();
		String finalIban="";
		//2. Convert to integer
		for (char c : tocharArr) {
			if (!Character.isDigit(c)) {
				finalIban += Character.getNumericValue(c);
			} else {
				finalIban += c;
			}
		}
		BigInteger bigValue= new BigInteger(finalIban);
		//3.Compute remainder .i.e. mod 97 
		BigInteger  modValue= new BigInteger("97");
	    assertEquals("Iban is valid"+ new BigInteger("1"), bigValue.mod(modValue));
		
	}
	
}
