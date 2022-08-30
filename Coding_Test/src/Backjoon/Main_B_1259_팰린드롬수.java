package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1259_팰린드롬수 {
	

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1259.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String word = br.readLine();
			if (word.equals("0")) break;
			String compare = new StringBuilder(word).reverse().toString();
			if (word.equals(compare)) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
		}

		
	}


	
	
}
	

