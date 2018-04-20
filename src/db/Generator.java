package db;

import java.util.Random;

/**
 * Data generator class
 * @author franciscoigor@gmail.com
 *
 */
public class Generator {
	
	/**
	 * Random generator
	 */
	private static Random rnd;
	
	static {
		rnd=new Random();
	}
	
	/**
	 * To fix or set a random seed
	 * @param seed
	 */
	public static void setSeed(long seed){
		rnd.setSeed(seed);
	}
	
	/**
	 * Get a random number between range
	 * @param min Minimum number
	 * @param max Maximum number (inclusive)
	 * @return Random number
	 */
	public static int getNumber(int min,int max){
		int number=rnd.nextInt(1+max-min)+min;
		return number;
	}
	
	/**
	 * Returns a random digit (0-9) 
	 * @return Random digit
	 */
	public static int getDigit(){
		return getNumber(0,9);
	}
		
	/**
	 * Return a letter from a list of letters
	 * @param letters Letters to pick a random letter
	 * @return A single character from the source string
	 */
	public static char getChar(String letters){
		return letters.charAt(getNumber(0, letters.length()-1));
	}
	
	/**
	 * Returns a vowel letter (lowercase)
	 * @return Vowel letter
	 */
	public static char getVowel(){
		return getChar("aeiou");
	}
	
	/**
	 * Returns a vowel letter (uppercase)
	 * @return Vowel letter
	 */
	public static char getUpperVowel(){
		return getChar("AEIOU");
	}
	
	/**
	 * Returns a consonant letter (lowercase)
	 * @return Consonant letter
	 */
	public static char getConsonant(){
		return getChar("bcdfghjklmnpqrstvwxyz");
	}
	
	/**
	 * Returns a consonant letter (uppercase)
	 * @return Consonant letter
	 */
	public static char getUpperConsonant(){
		return getChar("BCDFGHJKLMNPQRSTVWXYZ");
	}
	
	/**
	 * Get a random word with a fixed number of letters
	 * @param letters Number of letters
	 * @param upperCaseFirst True to enable upper-case the first letter 
	 * @return A random word
	 */
	public static String getWord(int letters, boolean upperCaseFirst){
		return getWord(letters, letters, upperCaseFirst);
	}
	
	/**
	 * Get a random word with a variable number of letters (range)
	 * @param minLetters Minimum number of letters
	 * @param maxLetters Maximum number of letters
	 * @param upperCaseFirst True to enable upper-case the first letter 
	 * @return A random word
	 */
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

	/**
	 * Returns a sentence with a number of random words
	 * @param words Number of words
	 * @return A sentence with random words
	 */
	public static String getSentence(int words){
		StringBuffer buffer=new StringBuffer();
		buffer.append(getWord(getNumber(5, 7),true));
		for (int i = 0; i < words; i++) {
			buffer.append(" ");
			buffer.append(getWord(getNumber(2, 7),false));
		}
		return buffer.toString();
	}

}
