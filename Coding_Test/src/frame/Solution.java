package frame;

import java.util.*;
import java.io.*;

public class Solution {
	
	static int tc;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			
			
			
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}


}
