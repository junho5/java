package Backjoon;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int range = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < range; i++) {
			String word = br.readLine();
			System.out.print(word.charAt(0));
			System.out.print(word.charAt(word.length()-1));
			System.out.println();
		}
		
		
	}



}
