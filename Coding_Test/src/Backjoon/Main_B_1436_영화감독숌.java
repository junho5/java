package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1436_영화감독숌 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<String>();
		
		int start = 666;
		int result = 0;
		
		while(result != N) {
			String temp = Integer.toString(start);
			char [] arr = temp.toCharArray();
			boolean flag = false;
			int six_check = 0;
			
			for (int i = 0; i < arr.length; i++) {
				if (six_check == 3) break;
				
				if (arr[i] == '6') {
					flag = true;
					six_check++;
				}else if (flag == true && arr[i] == '6') {
					six_check++;
				}else if (flag == true && arr[i] != '6') {
					flag = false;
					six_check = 0;
				}
			}
			
			if (six_check == 3) {
				list.add(new String(arr));
				result++;
			}
			
			start = Integer.parseInt(temp);
			start++;
			
			
		}
		
		System.out.println(list.get(list.size()-1));
		
		
		
	}
}

