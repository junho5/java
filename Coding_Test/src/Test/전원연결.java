package Test;

import java.util.*;
import java.io.*;

public class 전원연결 {
	
	static int tc, N, maxCore, minLength;
	static int [][] map;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static List<int []> corelist;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int [N][N];
			corelist = new ArrayList<int[]>();
			maxCore = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
					// core가 경계선에 위치할 경우
					if (n == 1 && i != 0 && j != 0 && i != N-1 && j != N-1) {
						corelist.add(new int [] {i,j});
					}
				}
			}
			
			dfs(0,0);
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(minLength);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	// idx = 현재 고려하는 core의 corelist 상의 index
	// cnt = 현재까지 전선이 연결된 core 수
	private static void dfs(int idx, int cnt) {
		// 기저 조건
		// idx 가 coreList에 있는 전체를 다 따진 경우
		if (idx == corelist.size()) {
			// maxCore 와 cnt 비교 , 전선의 길이를 고려해서 minLength 계산
			int len = calc(); // 현재 시점에 놓여진 전선의 길이 계산
			// 최대 최소를 따진다.
			if (maxCore < cnt) {
				maxCore = cnt;
				minLength = len;
			}else if (maxCore == cnt) {
				minLength = Math.min(minLength, len);
			}
			return;
		}
		// 현재 core를 연결
		// 현재 idx 의 core 좌표 구해서 (x,y)
		// 현재 좌표에서 놓을 수 있는 전선을 연결해본다.
		// 4방으로 진행
			// 각각의 방향으로 가능한지 확인하고 가능하면
				// 전선을 놓고
				// 다음 core로 다시 dfs 연결을 계속해간다.
				// 놓은 전선을 다시 회수
		int [] cur = corelist.get(idx);
		int x = cur[0];
		int y = cur[1];
		
		for (int i = 0; i < 4; i++) {
			// 전선을 깔 수 있는 지 확인
			if (isOk(x,y,i)) {
				setLine(x,y,i,2); // 전선을 놓는다. 2 
				dfs(idx + 1, cnt + 1);
				setLine(x,y,i,0); // 전선을 지운다. 0
				
			}
		}
		
		// 현재 코어를 연결하지 않고 계속 진행
		dfs(idx + 1, cnt);
	}
	
	// 전선을 놓고, 회수하는 메소드
	private static void setLine(int x, int y, int dir, int type) {
		int nx = x;
		int ny = y;
		while(true) {
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) break; // 경계선 밖의 영역 (성공)
			map[nx][ny] = type;
		}
	}
	
	// 전선을 끝까지 놓을 수 있는지 확인하는 메소드
	private static boolean isOk(int x, int y, int dir) {
		int nx = x;
		int ny = y;
		while(true) {
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) break; // 경계선 밖의 영역 (성공)
			if (map[nx][ny] >= 1) return false; // 실패
		}
		return true;
	}

	// 전선의 길이를 계산하는 메소드
	// 전선을 map에 놓을경우 2로 처리
	private static int calc() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) cnt++;
			}
		}
		return cnt;
	}

}
