package A_Test;

import java.util.*;
import java.io.*;

public class Main_B_17471_게리맨더링 {
	
	static int N,ans;
	static int t_sum,f_sum;
	static int [] population;
	static int [][] map;
	static boolean [] V;
	static boolean [] S_V;
	static List<Integer> t_list;
	static List<Integer> f_list;
	static Set<Integer> con;
	static boolean flag,check_f;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/17471.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 정점 개수
		population = new int [N]; // 인구수 배열
		map = new int [N+1][N+1]; // 인접행렬
		S_V = new boolean [N]; // 부분집합 방문 배열
		ans = Integer.MAX_VALUE; // 답 담을 변수
		st = new StringTokenizer(br.readLine()); 
		
		for (int i = 0; i < N; i++) { // 인구수 배열에 입력 0 ~~~~ N
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()); // 인접행렬 생성
			int adj = Integer.parseInt(st.nextToken());
			for (int j = 0; j < adj; j++) {
				int gu = Integer.parseInt(st.nextToken());
				map[i][gu] = 1;
			}
		}
		subset(0); 
		if (check_f) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}

	private static void subset(int index) {
		if (index == N) {
			t_sum = 0; // true의 인구수 합
			f_sum = 0; // false의 인구수 합
			t_list = new ArrayList<Integer>(); // true에 속한 지역들
			f_list = new ArrayList<Integer>(); // false에 속한 지역들
			con = new HashSet<>(); // 정상연결인지 아닌지 판단하기 위해 만든 set
			
			// true에 해당하는 지역과 false에 해당하는 지역 add
			for (int i = 0; i < S_V.length; i++) {
				if (S_V[i] == true) t_list.add(i+1);
				if (S_V[i] == false) f_list.add(i+1);
			}
			
			// 한곳에 몰빵일때 종료
			if (t_list.size() == N || f_list.size() == N) return; 
			
			// true와 false의 인구수 계산
			for (int i = 0; i < S_V.length; i++) {
				if(S_V[i] == true) t_sum += population[i];
				if(S_V[i] == false) f_sum += population[i];
			}
			
			// true에 속한 지역들 dfs 실행 
			for (int i = 0; i < t_list.size(); i++) {
				V = new boolean[N+1]; // 정점 방문 배열
				dfs(t_list.get(i),i);
			}
			
			// false에 속한 지역들 dfs 실행 
			for (int i = 0; i < f_list.size(); i++) {
				V = new boolean[N+1]; // 정점 방문 배열
				dfs(f_list.get(i),i);
			}
			
			// 만약 con의크기가 정점의 개수와 동일하면 정상적으로 연결되있는 상태, 아니면 비정상
			if (con.size()==N) {
				flag = true; // 현재 진행중인 부분집합이 정상일때
				check_f = true; // flag가 한번이라도 정상이면 정상이기때문에 필요한 변수
			}else {
				flag = false; // 현재 진행중인 부분집합이 비정상일때
			}
			
			// 부분집합이 정상이면 ans 값 변화줌
//			if (flag==true && t_list.size() == 0 && f_list.size() == 0) { 
			if (flag==true) { 
				ans = Math.min(ans, Math.abs(t_sum - f_sum));
			}
			return;
		}
		
		S_V[index] = true;
		subset(index+1);
		S_V[index] = false;
		subset(index+1);
	}

	private static void dfs(int index,int cnt) {
		V[index] = true;
		// dfs 첫번째 실행일때 -> dfs는 완탐이므로 지역구 하나당 한번씩 돌린결과 con 리스트에 저장
		if (cnt == 0) {
			con.add(index);
		}
//		t_list.remove(Integer.valueOf(index));
//		f_list.remove(Integer.valueOf(index));
		
		// 지역구가 true일때
		if(S_V[index-1] == true) {
			for (int i = 1; i <= N; i++) {
				// 지역구가 true고 방문하지 않았고 인접행렬 1일때
				if (S_V[i-1] == true && V[i] == false && map[index][i] == 1) {
					dfs(i,cnt);
				}
			}
		// 지역구가 false일때
		}else if (S_V[index-1] == false) {
			for (int i = 1; i <= N; i++) {
				// 지역구가 false고 방문하지 않았고 인접행렬 1일때
				if (S_V[i-1] == false && V[i] == false && map[index][i] == 1) {
					dfs(i,cnt);
				}
			}
		}
	}
}
