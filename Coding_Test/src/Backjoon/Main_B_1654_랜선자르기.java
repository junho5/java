package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1654_랜선자르기 {
	
	static int k,n;

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
		// 정답: 1073741823
//		System.out.println(list);
		int max = list.get(0);
		int answer = 0;
		for (int i = 1; i < max/2; i++) {
			int sum = 0;
			for (int j = 0; j < list.size(); j++) {
				sum += list.get(j)/i;
			}
			if (sum == n) {
				answer = i;
			}
			System.out.println(sum);
		}
		sb.append(answer);
		System.out.println(answer);
	}

	
}
