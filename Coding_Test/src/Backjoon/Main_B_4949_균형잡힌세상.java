package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_4949_균형잡힌세상 {

	static int a,b;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/4949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			Stack<Character> stack = new Stack<>();
			boolean flag = true;
			int index = 0;
			String word = br.readLine();
			if (word.equals(".") && word.length() == 1) break;
			
			word = word.replaceAll(" ", "");
//			System.out.println(word);
			a = 0;
			b = 0;
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == '(') {
					stack.push(word.charAt(i));
					index = 0;
					a++;
				}else if (word.charAt(i) == ')') {
					if (stack.size()<=0 || a <= 0 || index == -1) {
						flag =  false;
						break;
					}else {
						stack.pop();
					}
				}else if (word.charAt(i) == '[') {
					stack.push(word.charAt(i));
					index = -1;
					b++;
				}else if (word.charAt(i) == ']') {
					if (stack.size()<=0 || b <= 0 || index == 0) {
						flag =  false;
						break;
					}else {
						stack.pop();
					}
				}
			}
			
			if (flag == false) {
				System.out.println("no");
			}else if(stack.size() == 0){
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
			
			
			
		}
		

	}
}



