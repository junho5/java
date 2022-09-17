package SWEA;

import java.util.*;
import java.io.*;

public class Solution_5658_보물상자비밀번호 {

	static int tc,N,K;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int num = N/4; // 변 비밀번호 개수
			char [] arr = br.readLine().toCharArray();
			
			
//			deque로 비밀번호 입력        --------------------------
			Deque<Character> dq = new ArrayDeque<>();
			Set<String> set = new HashSet<>();
			List<Integer> list = new ArrayList<Integer>();
			
			for (int j = 0; j < arr.length; j++) {
				dq.add(arr[j]);
			}
//			System.out.println(dq);
//			-----------------------------------------------
			
			for (int j = 0; j <= num; j++) {
				if(j!=0) {
				char temp = dq.remove();
				dq.add(temp);
				}
				for (int k = 0; k < 4; k++) {
					String store = "";
					for (int k2 = 0; k2 < num; k2++) {
						char wait = dq.remove();
						store += wait;
						dq.add(wait);
					}
					set.add(store);
//					System.out.println(store);
				}
				
//				System.out.println(dq); // 1 ~ num회전
			}
			
			for (String data : set) {
				list.add(Integer.parseInt(data,16));
			}
//			System.out.println(set);
			Collections.sort(list , Collections.reverseOrder());
//			System.out.println(list);
			sb.append("#");
			sb.append(i);
			sb.append(" ");
			sb.append(list.get(K-1));
			sb.append("\n");
			
//			System.out.printf("#%d %d\n",i,list.get(K-1));
			
			
			
			
		}
		System.out.println(sb.toString());
		
		
	}

	
}




	
	


