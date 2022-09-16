package SWEA;

import java.util.*;
import java.io.*;

public class Solution_숫자만들기_success {

	static int N,MAX,MIN,tc;
	static int [] check,opt,nums;
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		tc = Integer.parseInt(br.readLine());
		for (int t_case = 1; t_case <= tc; t_case++) {
			StringBuilder sb = new StringBuilder();
			
			N = Integer.parseInt(br.readLine());
			MAX = Integer.MIN_VALUE;
			MIN = Integer.MAX_VALUE;
			
			check = new int[N-1];
			nums = new int[N];
			opt = new int[4];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				opt[i] =  Integer.parseInt(st.nextToken());
			}
			
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			perm1(0);
			sb.append("#");
			sb.append(t_case);
			sb.append(" ");
			sb.append(MAX-MIN);
			System.out.println(sb.toString());
		}
		
	}

	private static void perm1(int cnt) {
		if (cnt == N-1) {
			cal();
		}
		
		for (int i = 0; i < 4; i++) {
			if (opt[i] == 0) continue;
			
			opt[i]--;
			check[cnt] = i;
			perm1(cnt+1);
			opt[i]++;
		}
		
	}

	private static void cal() {
		int temp = nums[0];
		int index = 1;
		
		for (int i = 0; i < N-1; i++) {
			switch (check[i]) {
			case 0:
				temp += nums[index];
				index++;
				break;
			case 1:
				temp -= nums[index];
				index++;
				break;
			case 2:
				temp *= nums[index];
				index++;
				break;
			case 3:
				temp /= nums[index];
				index++;
				break;
			}
		}
		
		if (temp > MAX) MAX = temp;
		if (temp < MIN) MIN = temp;
	}
}




	
	


