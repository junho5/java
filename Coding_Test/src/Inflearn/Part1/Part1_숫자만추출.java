package Inflearn.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Part1_숫자만추출 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 48 ~ 57  = 0 ~ 9
		
		String word = br.readLine();
		String ans = "";
		
		for (int i = 0; i < word.length(); i++) {
			if ((int) word.charAt(i) >= 48 && (int) word.charAt(i) <= 57) {
				ans += word.charAt(i);
			}
		}
		System.out.println(Integer.parseInt(ans));
		

	}
}
