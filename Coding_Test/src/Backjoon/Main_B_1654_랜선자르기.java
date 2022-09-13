package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1654_랜선자르기 {
	
	static long k,n,answer,result;

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
//		System.out.println(list);
		
		long max = list.get(0);
		long min = 1;
		result = Integer.MIN_VALUE;
		
		while(min<=max) {
			answer = 0;
			long half = (max+min)/2;
//			System.out.println(half);
			
			if(half==0) {
				result = 0;
				break;
			}
			
			for (int i = 0; i < list.size(); i++) {
				answer += list.get(i) / half;
			}
//			System.out.println(answer);
			
			if (answer < n){
				max = half-1;
			}else{
				min = half+1;
			}
			
			if (answer >= n && half > result) {
				result = half;
			}
			
		}
		System.out.println(result);
		
		
	}

	
}
