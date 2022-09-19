package Backjoon;

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		Set<String> answer = new HashSet<>();
		
		for (int i = 0; i < a; i++) {
			String temp = br.readLine();
			set.add(temp);
		}
		
		for (int i = 0; i < b; i++) {
			String temp = br.readLine();
			if (set.contains(temp)) {
				answer.add(temp);
			}
		}
		
		List<String> list = new ArrayList<String>(answer);
		
		Collections.sort(list);
		
		sb.append(answer.size());
		sb.append("\n");
		for (String data : list) {
			sb.append(data);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}



}
