package Backjoon;

import java.util.*;


import java.io.*;

public class Solution_숫자만들기_fail {

	static int N,MAX,MIN,tc;
	static char [] sign = {'+','-','*','/'};
	static char [] number;
	static int [] nums;
	static boolean [] V;
	static List<Character> list;
	static HashSet<String> set;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		tc = Integer.parseInt(br.readLine());
		for (int t_case = 1; t_case <= tc; t_case++) {
			StringBuilder sb = new StringBuilder();
			
			N = Integer.parseInt(br.readLine());
			MAX = Integer.MIN_VALUE;
			MIN = Integer.MAX_VALUE;
			
			list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				int range = Integer.parseInt(st.nextToken());
				for (int j = 0; j < range; j++) {
					list.add(sign[i]);
				}
			}
			
			number = new char[N];
			V = new boolean[N+1];
			nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			set = new HashSet<>();
			perm1(0);
			sb = new StringBuilder();
			sb.append("#");
			sb.append(t_case);
			sb.append(" ");
			sb.append(MAX-MIN);
			System.out.println(sb.toString());
		}
		

	}

	private static void perm1(int cnt) {
		int temp = nums[0];
		int index = 1;
		if (cnt == list.size()) {
			sb = new StringBuilder();
			for (char data : number) {
				sb.append(data);
			}
			
			String a = sb.toString();
			
			if (!set.contains(a)) {
				set.add(a);
					for (int i = 0; i < N-1; i++) {
						switch(a.charAt(i)){
						case '+':
							temp += nums[index];
							index++;
							break;
						case '-':
							temp -= nums[index];
							index++;
							break;
						case '*':
							temp *= nums[index];
							index++;
							break;
						case '/':
							temp /= nums[index];
							index++;
							break;
						}
					}
					if (temp > MAX) MAX = temp;
					if (temp < MIN) MIN = temp;
				}
				
			return;
	}
		for (int i = 0; i < list.size(); i++) {
			if (V[i]) continue;
			
			number[cnt] = list.get(i);
			V[i] = true;
			perm1(cnt+1);
			V[i] = false;
		}
	}



	
	
}


