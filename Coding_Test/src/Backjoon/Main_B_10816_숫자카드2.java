package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_10816_숫자카드2 {

	static int N,M;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/10816.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp)+1);
			}else {
				map.put(temp, 1);
			}
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (map.containsKey(temp)) {
				list.add(map.get(temp));
			}else {
				list.add(0);
			}
		}
		
		for (int data : list) {
			sb.append(data);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

	
	
}
