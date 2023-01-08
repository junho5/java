package Backjoon;

import java.io.*;
import java.util.*;

public class Main_B_17219_비밀번호찾기 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String passwd = st.nextToken();
			map.put(site, passwd);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String site = br.readLine();
			sb.append(map.get(site) + "\n");
		}
		System.out.print(sb);
	}
}
