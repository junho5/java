package A_Test;

import java.util.*;
import java.io.*;

public class Solution_수영대회결승전_김태희 {
	private static int N;
	private static int[][] map;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/4193.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		for(int tc=1; tc<=TC; ++tc) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
 			StringTokenizer st;
			for(int i=0; i<N;++i) {
				st = new StringTokenizer(in.readLine()," ");
				for(int j=0; j<N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==2) map[i][j] = 12; // 소용돌이 칸은 12로. 
				}
			}
			st = new StringTokenizer(in.readLine()," ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine()," ");
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			System.out.println("#"+tc+" "+bfs(sr,sc,er,ec));
		}
	}
	private static int bfs(int sr, int sc, int er, int ec) {
		
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		visited[sr][sc] = true;
		queue.offer(new int[] {sr,sc});
		
		int time = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			int nr,nc;
			// 동일 너비(시간) 처리
			for (int i = 0; i < size; i++) {
				int[] cur = queue.poll();
				if(cur[0] == er && cur[1] == ec) return time;
				
				for(int d=0; d<4; ++d) {
					nr = cur[0] +dr[d];
					nc = cur[1] +dc[d];
					
					if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]==1 || visited[nr][nc] ) continue;
					
					// 빈칸(바다)이거나 소용돌이가 잠잠해진 곳이라면 가기
					if(map[nr][nc]==0 || map[nr][nc]== 10) {
						visited[nr][nc] = true;
						queue.offer(new int[] {nr,nc});
					}else { // 소용돌이가 유지되는 곳이라면 현재위치를 다시 큐에 넣어 대기하는 상황 연출하기 
						queue.offer(new int[] {cur[0],cur[1]});
					}
				}// end for dir
				
			}// end while
			
			// 시간이 1만큼 흐름
			time++;
			processStorm();
		}
		
		return -1;
	}
	
	private static void processStorm() {
		for(int i=0; i<N;++i) {
			for(int j=0; j<N; ++j) {
				if(map[i][j] > 10) map[i][j]--;
				else if(map[i][j]==10) map[i][j] += 2;
			}
		}
	}
}










