package Backjoon;

import java.util.*;
import java.io.*;

public class Main {
	
	static int num;
	static char [] arr;
	static boolean [] v;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = br.readLine().toCharArray();
		v = new boolean [arr.length];
		num = arr.length;
		subset(0);
		System.out.println(set);
		
		
	}

	private static void subset(int index) {
		if (index == num) {
			String temp = "";
			
			for (int i = 0; i < arr.length; i++) {
				if (v[i] == true) {
					temp += arr[i]; 
				}
			}
			System.out.println(temp);
			set.add(temp);
			return;
		}
		
		v[index] = true;
		subset(index+1);
		v[index] = false;
		subset(index+1);
		
	}


}
