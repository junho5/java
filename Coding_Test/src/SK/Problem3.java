package SK;

import java.util.*;

import java.io.*;

public class Problem3 {
//	[["00011", "01111", "21001", "11001", "01111"], ["00011", "00011", "11111", "12101", "11111"]] 1,1
//	[["1111", "1121", "1001", "1111"], ["0000", "0000", "0000", "0002"], ["0000", "0100", "0000", "0002"], ["0000", "0010", "0121", "0010"]] 1,1,0,0
	static int sx,sy;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int [] ans;
	static String [][] boards;
	static int [][] temp;
	
	static class flower{
		int x,y,row,col;

		public flower(int x, int y, int row, int col) {
			super();
			this.x = x;
			this.y = y;
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		boards = new String [][] {{"1111", "1121", "1001", "1111"}, {"0000", "0000", "0000", "0002"}, 
			{"0000", "0100", "0000", "0002"}, {"0000", "0010", "0121", "0010"}};
		
		ans = new int [boards.length];
		sx = 0;
		sy = 0;
		
		
		// 길이
//		System.out.println(boards.length);
		// 행 
//		System.out.println(boards[0].length);
		// 열 
//		System.out.println(boards[0][0].length());
		
		for (int i = 0; i < boards.length; i++) {
//			System.out.println(Arrays.toString(boards[i]));
			
			temp = new int [boards[i].length][boards[i][0].length()];
			
			for (int j = 0; j < boards[i].length; j++) {
				for (int k = 0; k < boards[i][j].length(); k++) {
					temp[j][k] = boards[i][j].charAt(k)-48;
				}
				
			}
//			print2(temp);
			
			for (int j = 0; j < temp.length; j++) {
				for (int j2 = 0; j2 < temp[0].length; j2++) {
					if(temp[j][j2]==2) {
						sx = j;
						sy = j2;
					}
				}
			}
//			System.out.printf("시작 좌표 => %d %d\n", sx,sy);
			bfs(sx,sy,temp.length,temp[0].length);
//			print2(temp);
			int plus = check(temp);
			if(plus == 0) {
				plus = 1;
			}
			ans[i] = plus;
		}
		System.out.println(Arrays.toString(ans));

}
	private static int check(int[][] temp) {
		int cnt = 0;
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if(temp[i][j]!=7 && temp[i][j] !=0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void print(String[][] boards) {
		for (String [] data_arr : boards) {
			for (String data : data_arr) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}
	
	private static void print2(int[][] boards) {
		for (int [] data_arr : boards) {
			for (int data : data_arr) {
				System.out.print(data + " ");
			}
			System.out.println();
		}
	}
	
	private static void bfs(int x, int y, int row, int col) {
		Queue<flower> q = new LinkedList<>();
		q.add(new flower(x, y, row, col));
		
		while(!q.isEmpty()) {
			flower flower = q.poll();
			
			// 4방 탐색
			for (int i = 0; i < 4; i++) {
				int m_x = flower.x + dx[i];
				int m_y = flower.y + dy[i];
				
				// 범위가 넘어갈 경우 넘기기
				if (m_x < 0 || m_y < 0 || m_x >=row || m_y >= col) continue;
				if (temp[m_x][m_y] == 0 || temp[m_x][m_y] == 7 ) continue;
				
				temp[m_x][m_y] = 7;
				q.add(new flower(m_x, m_y, row, col));
			}
		}
	}
}
