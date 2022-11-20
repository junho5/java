package A_Test;

import java.util.*;
import java.io.*;

public class Solution_보호필름_김태희 {

	static int tc;
	static int x,y,k;
	static int [][] film;
	static int [] a_drug,b_drug;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/2112.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			film = new int [x][y];
			a_drug = new int [y];
			b_drug = new int [y];
			Arrays.fill(a_drug, 0);
			Arrays.fill(b_drug, 1);
			
			ans = Integer.MAX_VALUE;
			
			for (int i = 0; i < x; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < y; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(process());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static int process() {
		int cnt = 0;
		while(cnt <= k) {
			if(comb(0,0,cnt)) return cnt;
			cnt++;
		}
		return -1;
	}
	
	private static boolean comb(int start,int cnt,int targetCnt) {
		if (cnt == targetCnt) {
			return check();
		}
		
		for (int i = start; i < x; i++) {
			int [] backup = film[i];
			
			film[i] = a_drug;
			if(comb(i+1,cnt+1,targetCnt)) return true;
			
			film[i] = b_drug;
			if(comb(i+1,cnt+1,targetCnt)) return true;
			
			film[i] = backup;
		}
		
		return false;
	}
	
	private static boolean check() {
		for (int i = 0; i < y; i++) {
			boolean result = false;
			int a_cnt = 0; // 0일 경우
			int b_cnt = 0; // 1일 경우
			for (int j = 0; j < x; j++) {
				if (film[j][i] == 0) {
					a_cnt++;
					if (a_cnt >= k) {
						result = true;
						continue;
					}
					b_cnt = 0;
				}else {
					b_cnt++;
					if (b_cnt >= k) {
						result = true;
						continue;
					}
					a_cnt = 0;
				}
			}
			if (!result) return false;
		}
		
		return true;
	}
	
	private static void print(int[][] film) {
		for (int [] data_arr : film) {
			for (int data : data_arr) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
	}

}








