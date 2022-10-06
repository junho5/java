package A_Test;

import java.util.*;


import java.io.*;

public class Solution_1952_수영장2 {
	
	static int tc,ans;
	static int [] price_arr;
	static int [] plan;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			price_arr = new int [4];
			plan = new int [12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < price_arr.length; i++) {
				price_arr[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(price_mon));
//			System.out.println(Arrays.toString(plan));
			
			ans = price_arr[3];
			dfs(0,0);
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int month, int price) {
		if (month > 11) {
			ans = Math.min(ans, price);
			return;
		}
		if (plan[month] == 0) {
			dfs(month+1, price);
		}else {
			dfs(month+1,price + plan[month]*price_arr[0]);
			dfs(month+1,price + price_arr[1]);
			dfs(month+3,price + price_arr[2]);
		}
	}


}
