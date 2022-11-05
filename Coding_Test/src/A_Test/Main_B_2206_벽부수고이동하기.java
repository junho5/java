package A_Test;


import java.util.*;
import java.io.*;

public class Main_B_2206_벽부수고이동하기 {
	
	static int n,m,ans;
	static int [][] map;
	static boolean [][][] v;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	static class Node{
		int x,y;
		int cnt;
		int use;
		public Node(int x, int y, int cnt, int use) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.use = use;
		}
		
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/2206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		
		map = new int [n][m];
		v = new boolean [n][m][2];
		ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = row.charAt(j)-'0';
			}
		}
		
		print(map);
		
		bfs(0,0,1,0);
		System.out.println(ans);
		
	}


	private static void bfs(int x, int y, int cnt, int use) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y, cnt, use));
		v[x][y][0] = true; // 폭탄 안쓴 경우
		v[x][y][1] = true; // 폭탄 쓴 경우
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			if (temp.x == n-1 && temp.y == m - 1) {
				ans = Math.min(ans, temp.cnt);
				break;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int m_x = temp.x + dx[i];
				int m_y = temp.y + dy[i];
				
				if (m_x < 0 || m_y < 0 || m_x >= n || m_y >= m) continue;
				
				if (map[m_x][m_y]==0) { // 벽 아닐 경우
					if (v[m_x][m_y][temp.use] == false) {
						q.add(new Node(m_x, m_y, temp.cnt+1, temp.use));
						v[m_x][m_y][0] = true;
					}
				}else if (map[m_x][m_y] == 1){ // 벽인 경우
					if (temp.use == 0 && v[m_x][m_y][1] == false) {
						q.add(new Node(m_x, m_y, temp.cnt+1, 1));
						v[m_x][m_y][1] = true;
					}
				}
				
			}
			
		}
		
		
	}


	private static void print2(boolean[][][] v) {
		for (boolean [][] data_arrs : v) {
			for (boolean [] data_arr : data_arrs) {
				for (boolean data : data_arr) {
					System.out.print(data + " ");
				}
			}
			System.out.println();
		}
		
	}


	private static void print(int[][] map) {
		for (int [] data_arr : map) {
			for (int data : data_arr) {
				System.out.printf("%d ",data);
			}
			System.out.println();
		}
	}

}
