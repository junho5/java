package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1654_랜선자르기 {
	
	static int k,n,answer,result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1654.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < k; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list , Collections.reverseOrder());
		System.out.println(list);
		
		int max = list.get(0);
		int min = 0;
		int cnt = 0;
		
		while(true) {
			answer = 0;
			int half = (max+min)/2;
			
			for (int i = 0; i < list.size(); i++) {
				answer += list.get(i) / half;
			}
			if(cnt==10) {
				System.out.println(half);
				System.out.println(answer);
				break;
			}
			
			if (answer == n) {
				answer = half;
				break;
				
			}else if (answer < n){
				max = half-1;
			}else if (answer > n) {
				min = half+1;
			}
			cnt++;
		}
		
//		while(true) {
//			for (int i = 0; i < list.size(); i++) {
//				result += list.get(i) / answer;
//			}
//			
//			if (result > n) {
//				answer --;
//				break;
//			}
//			else answer++;
//		}
		
//		System.out.println(answer);
		
		
	}

	
}
