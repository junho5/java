package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1620_나는야포켓몬마스터이다솜 {

	static int n,m;
	static Map<Integer, String> int_map = new HashMap<>();
	static Map<String, Integer> string_map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1620.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			int_map.put(i, name);
			string_map.put(name, i);
		}
		
		for (int i = 0; i < m; i++) {
			String find = br.readLine();
			if (Character.isAlphabetic(find.charAt(0))) {
				sb.append(string_map.get(find));
				sb.append("\n");
			}else {
				sb.append(int_map.get(Integer.parseInt(find)));
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		
		

	}


}
