package A_Test;

import java.util.*;


import java.io.*;

public class Solution_5658_보물상자비밀번호2 {
	
	static int tc,N,K;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 개수
			K = Integer.parseInt(st.nextToken()); // k만큼 큰 값
			
			int num = N/4; // 비밀번호 자릿 수
			String data = br.readLine();
			
			Deque<Character> q = new ArrayDeque<Character>();
			Set<String> set = new HashSet<>();
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < data.length(); i++) {
				q.add(data.charAt(i));
			}
//			System.out.println(q);
			
			String check = "";
			
			for (int i = 0; i < num; i++) {
				char temp = q.pollLast();
				q.addFirst(temp);;
//				System.out.println(q);
				for (int j = 0; j < N; j++) {
					if (check.length() != num) {
						char temp2 = q.pollFirst();
						check += temp2;
						q.addLast(temp2);
						if (check.length() == num) {
							set.add(check);
							check = "";
						}
					}
				}
			}
			
			for (String number : set) {
				list.add(Integer.parseInt(number,16));
			}
			Collections.sort(list, Collections.reverseOrder());
//			System.out.println(list.get(K-1));
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(list.get(K-1));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}


}
