package Backjoon;

import java.util.*;
import java.io.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N,W,H,answer;
	static int[][] map, map_copy;
	static boolean[][] V;
	static boolean[] selected;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			map = new int[H][W];
			map_copy = new int[H][W];
			V = new boolean[H][W];
			selected = new boolean[W];
			numbers = new int[N];
			answer = Integer.MAX_VALUE;
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					map[i][j] = sc.nextInt();
					map_copy[i][j] = map[i][j];
				}
			}
			
			perm(0);
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			//공 쏠 위치 찾기
//			System.out.println(Arrays.toString(numbers));
			for(int b=0; b<N; b++) {
				destroy(numbers[b]);
				
				//세로로 돌면서 블럭 옮겨주기
				for(int j=0; j<W; j++) { 
					int[] temp = new int[H];
					int idx = 0;
					//세로 줄 중 0이 아닌 숫자들 temp에 넣어주기
					for(int i=H-1; i>=0; i--) {
						if(map[i][j] != 0) {
							temp[idx++] = map[i][j];
						}
					}
					
					//뒤부터 0이 아닌 숫자 넣어주기
					idx = 0;
					for(int i=0; i<H; i++) {
						map[i][j] = temp[H-1-i];
					}
				}
			}
			
			int block = 0; //이번 블럭 갯수
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(map[i][j] != 0)
						block++;
				}
			}
			
			//다음꺼 계산 위해 원상복구
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
		
		//공 쏠 곳 N개 뽑기
		for(int i=0; i<W; i++) {
			numbers[cnt] = i;
			selected[i] = true;
			perm(cnt+1);
			selected[i] = false;
		}
	}
	
	//공 쏠 위치 기준으로 삭제
	static void destroy(int index) {
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
			
			//위
			for(int i=0; i<p.range; i++) {
				if(x-i>=0 && map[x-i][y] != 0) {
					q.add(new stone(x-i, y, map[x-i][y]));
					map[x-i][y] = 0;
				}
			}
			//아래
			for(int i=0; i<p.range; i++) {
				if(x+i<H && map[x+i][y] != 0) {
					q.add(new stone(x+i, y, map[x+i][y]));
					map[x+i][y] = 0;
				}
			}
			//왼쪽
			for(int i=0; i<p.range; i++) {
				if(y-i>=0 && map[x][y-i] != 0) {
					q.add(new stone(x, y-i, map[x][y-i]));
					map[x][y-i] = 0;
				}
			}
			//오른쪽
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
			this.y = x;
			this.range = range;
		}
	}
}