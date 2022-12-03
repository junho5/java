package A_Test;

import java.util.*;
import java.io.*;

public class 지역구나누기 {

	static int tc,N,ans;
	static int [][] graph;
	static boolean [] s_v;
	static boolean [] d_v;
	static int [] pop;
	static List<Integer> a_list,b_list;
	static Set<Integer> con;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/1_1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			N = Integer.parseInt(br.readLine()); // 정점 수
			graph = new int [N+1][N+1]; // 인접행렬
			s_v = new boolean [N+1]; // 부분집합 방문배열
			pop = new int [N+1]; // 인구수 배열
			ans = Integer.MAX_VALUE; // 답
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				pop[i] = Integer.parseInt(st.nextToken());
			}
			
			subset(1);
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

	private static void subset(int index) {
		if (index == N + 1) {
			a_list = new ArrayList<Integer>();
			b_list = new ArrayList<Integer>();
			
			// 지역구 나누는 부분
			for (int i = 1; i <= N; i++) {
				if(s_v[i]) a_list.add(i); 
				if(!s_v[i]) b_list.add(i); 
			}
			
			// 지역구가 한곳에 몰려있을 경우 종료
			if (a_list.size() == N || a_list.size() == 0) return;
			
			// 연결 상태 확인 함수
			check();
			
			return;
		}
		
		s_v[index] = true;
		subset(index+1);
		s_v[index] = false;
		subset(index+1);
		
	}

	private static void check() {
		// 연결 상태 확인할 set 자료구조
		con = new HashSet<>();
		
		// true에 해당하는 지역구 dfs 실행
		d_v = new boolean[N+1];
		dfs(a_list.get(0));
		
		// false에 해당하는 지역구 dfs 실행
		d_v = new boolean[N+1];
		dfs(b_list.get(0));
		
		// 만약 연결이 정상이 아닐경우 종료
		if (con.size() != N) return;
		
		// 인구수 계산
		int a_sum = 0;
		int b_sum = 0;
		int total = 0;
		for (int i = 1; i <= N; i++) {
			if (s_v[i]) a_sum += pop[i];
			if (!s_v[i]) b_sum += pop[i];
		}
		
		total = Math.abs(a_sum - b_sum);
		ans = Math.min(ans, total);
		
	}

	private static void dfs(int index) {
		// dfs 방문 처리
		d_v[index] = true;
		// 연결 표시
		con.add(index);
		
		// true 지역구일 경우
		if (s_v[index]) {
			for (int i = 1; i <= N; i++) {
				// true 지역구이며 dfs중 방문하지않았으며 인접행렬일 경우
				if (s_v[i] == true && d_v[i] == false && graph[index][i] == 1) {
					dfs(i);
				}
			}
		// false 지역구일 경우
		}else {
			for (int i = 1; i <= N; i++) {
				// false 지역구이며 dfs중 방문하지않았으며 인접행렬일 경우
				if (s_v[i] == false && d_v[i] == false && graph[index][i] == 1) {
					dfs(i);
				}
			}
			
		}
	}

}