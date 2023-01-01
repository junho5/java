package Backjoon;

import java.util.*;
import java.io.*;
 
//public class Main_B_1003_피보나치함수 {
//	
//	static int n, zero, one;
// 
//    public static void main(String args[]) throws Exception{
//    	System.setIn(new FileInputStream("input/1003.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();
//    	
//		n = Integer.parseInt(br.readLine());
//		
//		// 0 1 3
//		for (int i = 0; i < n; i++) {
//			int num = Integer.parseInt(br.readLine());
//			zero = 0;
//			one = 0;
//			fivo(num);
//			System.out.println(zero+" "+one);
////			System.out.println("-------------------");
//		}
//		
//    	
//    }
//
//	private static int fivo(int n) {
//		if (n == 0) {
//			zero++;
//			return 0;
//		}
//		else if (n == 1) {
//			one++;
//			return 1;
//		}
//		
//		return fivo(n-1) + fivo(n-2);
//	}
//}

public class Main_B_1003_피보나치함수 {
	 
	static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dp[0][0] = 1;	// N=0 일 때의 0 호출 횟수
		dp[0][1] = 0;	// N=0 일 때의 1 호출 횟수
		dp[1][0] = 0;	// N=1 일 때의 0 호출 횟수
		dp[1][1] = 1;	// N=1 일 때의 1 호출 횟수
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T --> 0){
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
		}
		System.out.println(sb);
	}
	
	static Integer[] fibonacci(int N) {
		// N에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
		if(dp[N][0] == null || dp[N][1] == null) {
			// 각 N에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
			dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
			dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
		}
		// N에 대한 0과 1, 즉 [N][0]과 [N][1] 을 담고있는 [N]을 반환한다.
		return dp[N];
 
	}
 
}



