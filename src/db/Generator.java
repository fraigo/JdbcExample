package db;

import java.util.Random;

public class Generator {
	
	private static Random rnd;
	
	static {
		rnd=new Random();
	}
	
	public static void setSeed(long seed){
		rnd.setSeed(seed);
	}
	
	public static int getNumber(int min,int max){
		int number=rnd.nextInt(1+max-min)+min;
		return number;
	}
	
	public static int getDigit(){
		return getNumber(0,9);
	}
		
	public static char getChar(String letters){
		return letters.charAt(getNumber(0, letters.length()-1));
	}
	
	public static char getVowel(){
		return getChar("aeiou");
	}
	
	public static char getUpperVowel(){
		return getChar("AEIOU");
	}
	
	public static char getConsonant(){
		return getChar("bcdfghjklmnpqrstvwxyz");
	}
	
	public static char getUpperConsonant(){
		return getChar("BCDFGHJKLMNPQRSTVWXYZ");
	}
	
	public static String getWord(int letters, boolean upperCaseFirst){
		return getWord(letters, letters, upperCaseFirst);
	}
	
	public static String getWord(int minLetters, int maxLetters, boolean upperCaseFirst){
		int letters=getNumber(minLetters, maxLetters);
		StringBuffer buffer=new StringBuffer();
		if (upperCaseFirst){
			buffer.append(getUpperConsonant());
		}else{
			buffer.append(getConsonant());
		}
		for (int i=1; i<letters; i++){
			buffer.append(getVowel());
			i++;
			if (i>=letters){
				break;
			}
			buffer.append(getConsonant());			
		}
		return buffer.toString();
	}
	
	public static String getSentence(int words){
		StringBuffer buffer=new StringBuffer();
		buffer.append(getWord(getNumber(5, 7),true));
		for (int i = 0; i < words; i++) {
			buffer.append(" ");
			buffer.append(getWord(getNumber(2, 7),false));
		}
		return buffer.toString();
	}
		
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			System.out.println(getSentence(5));			
		}
	}
	
	
}
