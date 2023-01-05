package Backjoon;

import java.util.*;
import java.io.*;
 
public class Main_B_1003_피보나치함수 {
	
	static int n, zero, one;
	static int [] dp;
 
    public static void main(String args[]) throws Exception{
    	System.setIn(new FileInputStream("input/1003.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
    	
		n = Integer.parseInt(br.readLine());
		dp = new int [41];
		dp[0] = 0;
		dp[1] = 1;
		
		// 0 1 3
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			zero = 0;
			one = 0;
			fivo(num);
			System.out.println(zero+" "+one);
//			System.out.println("-------------------");
		}
		
    	
    }

	private static int fivo(int n) {
		if (n == 0) {
			zero++;
			return 0;
		}
		else if (n == 1) {
			one++;
			return 1;
		}
		else if (dp[n] != 0){
			return dp[n];
		}else {
			dp[n] = fivo(n-1) + fivo(n-2);
			return dp[n];
		}
	}
}






