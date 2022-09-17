package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_11723_집합 {
	
	static int num;
	static boolean check;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/11723.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Set<Integer> set = new HashSet<>();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			
			String op = st.nextToken();
			
			switch(op) {
				case "add":
					num = Integer.parseInt(st.nextToken());
					set.add(num);
					break;
					
				case "check":
					num = Integer.parseInt(st.nextToken());
					check = set.contains(num);
					if (check) {
						sb.append(1);
						sb.append("\n");
					}else {
						sb.append(0);
						sb.append("\n");
					}
					break;
					
				case "remove":
					num = Integer.parseInt(st.nextToken());
					check = set.contains(num);
					if (check) {
						set.remove(num);
					}else {
						continue;
					}
					break;
					
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					check = set.contains(num);
					if (check) {
						set.remove(num);
					}else {
						set.add(num);
					}
					break;
					
				case "all":
					set.clear();
					for (int j = 1; j <= 20; j++) {
						set.add(j);
					}
					break;
					
				case "empty":
					set.clear();
					break;
			}
			
		}
		System.out.println(sb.toString());
	}

	
}
