package Inflearn.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Part1_대소문자변환 {

	public static void main(String[] args) throws Exception {
		
//		System.out.println((char)65); A
//		System.out.println((char)90); Z
//		System.out.println((char)97); a
//		System.out.println((char)122); z
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		char [] arr = new char[word.length()];
		
		for (int i = 0 ; i<word.length();i++) {
			int data = word.charAt(i);
			if (data >=65 && data <=90) {
				data += 32;
				arr[i] = (char) data;
			}else {
				data -= 32;
				arr[i] = (char) data;
			}
		}
		
		String answer = new String(arr);
		System.out.println(answer);

	}

}
