package A_Test;

import java.util.*;
import java.io.*;

public class Solution_1949_등산로조정 {
	
	static int tc;
	static int N,K,Max_start,ans_path;
	static int [][] map;
	static boolean [][] V;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int [N][N];
			Max_start = Integer.MIN_VALUE;
			ans_path = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					Max_start = Math.max(Max_start, map[i][j]);
				}
			}
//			print(map);
//			System.out.println(Max_start);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == Max_start) {
						V = new boolean [N][N];
						dfs(i,j,1,false);
					}
				}
			}
			
//			System.out.println(ans_path);
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans_path);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int x, int y, int length, boolean coupon) {
		ans_path = Math.max(ans_path, length);
		V[x][y] = true;
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if (V[nx][ny] == true) continue;
			
			// 4방 탐색중인 부분이 더 작으면 방문처리하고 length 하나 늘리고 dfs 진행 ( 정상 진행 가능 )
			if (map[nx][ny] < map[x][y]) {
				V[nx][ny] = true;
 				dfs(nx,ny,length+1,coupon);
 				V[nx][ny] = false;
 			// 4방 탐색중인 부분이 크면 쿠폰 사용유무와 4방탐색 중인 방향에서 K공사 하였을때 더 작으면 실행 -> 아니면 불가능
			}else {
				if (!coupon && map[nx][ny] - K < map[x][y] ) {
					// temp에 임시로 값 저장
					int temp = map[nx][ny];
					// 4방 탐색한 부분에다가 -1로 최소로 줄여서 덮어쓰기
					map[nx][ny] = map[x][y] -1;
					V[nx][ny] = true;
					// length 늘리고 쿠폰 사용유무 변경 후 dfs 실행
					dfs(nx,ny,length+1,true);
					map[nx][ny] = temp;
					V[nx][ny] = false;
				}
			}
		}
		// dfs 돌린부분 false로 되돌리기
		V[x][y] = false;
	}
	
	private static void print(int[][] map) {
		for (int[] data_arr : map) {
			for (int data : data_arr) {
				System.out.printf("%d ", data);
			}
			System.out.println();
		}
	}
	
}
