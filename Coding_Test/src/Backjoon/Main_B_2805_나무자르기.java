package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_2805_나무자르기 {
	
	static long N,M;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		List<Integer> tree = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(tree, Collections.reverseOrder());
//		System.out.println(tree);
		
		long max = tree.get(0);
		long min = 0;
		long result = Integer.MIN_VALUE;
		
		while(min<=max) {
			long half = (max+min)/2;
			long answer = 0;
//			System.out.println(half);
			
			for (int i = 0; i < tree.size(); i++) {
				long temp = tree.get(i)-half;
				if (temp < 0) continue;
				else {
					answer += temp;
				}
			}
//			System.out.println(answer);
//			System.out.println("-----------");
			
			if (answer < M) {
				max = half - 1;
			}else {
				min = half + 1;
			}
			
			if (answer >= M && result < half) {
				result = half;
			}
			
		}
		
		System.out.println(result);
		
		
		
		
	}

	
}
