package Backjoon;

import java.util.*;
import java.io.*;

public class Main {
	static int N,W,H,answer;
	static int[][] map, map_copy;
	static int[] numbers;
	static boolean[] selected;
	static boolean[][] V;
	static int[] dx = { 1,-1, 0, 0 };
	static int[] dy = { 0, 0,-1, 1 };
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("input/5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int time = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=time; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			answer = Integer.MAX_VALUE;
			
			map = new int[H][W];
			map_copy = new int[H][W];
			V = new boolean[H][W];
			selected = new boolean[W];
			numbers = new int[N];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map_copy[i][j] = map[i][j];
				}
			}
//			System.arraycopy(map, 0, map_copy, 0, map.length);
			
			perm(0);
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			sb.append(answer);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void perm(int cnt) {
		if(cnt == N ) {
			// 중복 수열로 bfs 진행 하면서 부수기
			for(int b=0; b<N; b++) {
				bfs(numbers[b]);
				
				// 블록 옮기는 부분
				for(int j=0; j<W; j++) { 
					int[] temp = new int[H];
					int idx = 0;
					// 블럭 0아닌 값 체크
					for(int i=H-1; i>=0; i--) {
						if(map[i][j] != 0) {
							temp[idx++] = map[i][j];
						}
					}
					
					// 블럭내리기
					idx = 0;
					for(int i=0; i<H; i++) {
						map[i][j] = temp[H-1-i];
					}
				}
			}
			
			// 값 체크
			int block = 0; 
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] != 0)
						block++;
				}
			}
			
			// 초기화
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = map_copy[i][j];
				}
			}
			
			if(answer > block) {
				answer = block;
			}

			return;
		}
		
		// 중복 순열
		for(int i=0; i<W; i++) {
			numbers[cnt] = i;
			selected[i] = true;
			perm(cnt+1);
			selected[i] = false;
		}
	}
	
	// bfs
	static void bfs(int index) {
		Queue<stone> q = new LinkedList<>();
		
		for(int i=0; i<H; i++) {
			if(map[i][index] != 0) {
				q.add(new stone(i,index, map[i][index]));
				break;
			}
		}
		
		while(!q.isEmpty()) {
			stone p = q.poll();
	         int x = p.x;
	         int y = p.y;
	         
	         for(int i=0; i<p.range; i++) {
	            if(x-i>=0 && map[x-i][y] != 0) {
	               q.add(new stone(x-i, y, map[x-i][y]));
	               map[x-i][y] = 0;
	            }
	         }
	         for(int i=0; i<p.range; i++) {
	            if(x+i<H && map[x+i][y] != 0) {
	               q.add(new stone(x+i, y, map[x+i][y]));
	               map[x+i][y] = 0;
	            }
	         }
	         for(int i=0; i<p.range; i++) {
	            if(y-i>=0 && map[x][y-i] != 0) {
	               q.add(new stone(x, y-i, map[x][y-i]));
	               map[x][y-i] = 0;
	            }
	         }
	         for(int i=0; i<p.range; i++) {
	            if(y+i<W && map[x][y+i] != 0) {
	               q.add(new stone(x, y+i, map[x][y+i]));
	               map[x][y+i] = 0;
	            }
	         }
		}
	}
	
	static class stone{
		int x,y, range;
		stone(int x, int y, int range){
			this.x = x;
			this.y = y;
			this.range = range;
		}
	}
}