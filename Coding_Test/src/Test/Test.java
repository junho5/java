package Test;

import java.util.*;
import java.io.*;

public class Test {

	static int tc, N, Corenum, minLength, ans;
	static int [][] map;
	static List<int[]> coreList;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			Corenum = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;
			coreList = new ArrayList<int[]>();
			

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j != N-1)
						coreList.add(new int[] { i, j });
				}
			}

			dfs(0, 0);
			System.out.println(minLength);

		}
	}

	private static void dfs(int index, int cnt) {
		if (index == coreList.size()) {
			
			int len = cal();
			if (Corenum < cnt) {
				Corenum = cnt;
				minLength = len;
			}else if (Corenum == cnt) {
				minLength = Math.min(minLength, len);
			}
			return;
		}
		
		// 선택 했을 경우
		int [] temp = coreList.get(index);
		int x = temp[0];
		int y = temp[1];
		for (int i = 0; i < 4; i++) {
			if(isOk(x,y,i)) {
				setLine(x,y,i,2);
				dfs(index + 1, cnt + 1);
				setLine(x,y,i,0);
				
			}
		}
		
		// 선택 안했을 경우
		dfs(index + 1, cnt);
		
	}


	private static void setLine(int x, int y, int dir, int type) {
		int m_x = x;
		int m_y = y;
		while(true) {
			m_x += dx[dir];
			m_y += dy[dir];
			
			if (m_x < 0 || m_y < 0 || m_x >= N || m_y >= N) break;
			map[m_x][m_y] = type;
		}
	}

	private static boolean isOk(int x, int y, int dir) {
		int m_x = x;
		int m_y = y;
		while(true) {
			m_x += dx[dir];
			m_y += dy[dir];
			
			if (m_x < 0 || m_y < 0 || m_x >= N || m_y >= N) break;
			if (map[m_x][m_y] >= 1) return false;
		}
		
		
		return true;
	}

	private static int cal() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2) cnt++;
			}
		}
		return cnt;
	}

}
