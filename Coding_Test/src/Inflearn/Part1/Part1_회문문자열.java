package Inflearn.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Part1_회문문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String word = br.readLine().toLowerCase();
		String word2 = new StringBuilder(word).reverse().toString();
		if (word.equals(word2)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}

	}
}
