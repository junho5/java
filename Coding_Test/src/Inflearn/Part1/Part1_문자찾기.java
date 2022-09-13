package Inflearn.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Part1_문자찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String word = br.readLine().toLowerCase();
		char find = br.readLine().toLowerCase().charAt(0);
		int cnt = 0;
		
		for (int i = 0 ; i< word.length();i++) {
			if (find == word.charAt(i)) {
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}

}
