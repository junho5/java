package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_2493_탑 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<Integer>();
		
		int num = Integer.parseInt(br.readLine());
		Stack<int []> stack = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			int floor = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if (stack.peek()[0] < floor) {
					stack.pop();
				}
				else {
					sb.append(stack.peek()[1]+1);
					sb.append(" ");
					break;
				}
			}
			if (stack.isEmpty()) {
				sb.append(0);
				sb.append(" ");
			}
			stack.push(new int [] {floor,i});
			
		}
		System.out.println(sb.toString());
		
	}

}

// 5
// 6 9 5 7 4
