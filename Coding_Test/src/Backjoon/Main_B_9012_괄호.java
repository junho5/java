package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_9012_괄호 {
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/9012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			boolean flag = true;
			Stack<Character> s = new Stack<>();
			char [] arr = br.readLine().toCharArray();
			
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '(') {
					s.push(arr[j]);
				}else if (arr[j] == ')' && s.size() > 0) {
					s.pop();
				}else {
					flag = false; 
				}
			}
			
			int answer  = s.size();
			
			if (flag == false) {
				System.out.println("NO");
			}
			else if (flag == true && answer > 0) {
				System.out.println("NO");
			}else {
				System.out.println("YES");
			}
			
			
		}
		

			
	}

		



}


	
	



