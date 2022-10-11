package A_Test;

import java.util.*;
import java.io.*;

public class Solution {
	
	static int tc;
	static int N,X;
	static int [][] map;
	static int [][] map2;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/4014.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int [N][N];
			map2 = new int [N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					map2[j][i] = map[i][j];
				}
			}
			
//			print(map);
//			System.out.println("=========================");
//			print(map2);
			
//			System.out.println(countRoad());
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(countRoad());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static boolean checkRoad(int[] road) {
		int size = 0, turn = 0;
		int height = road[0];
		
		while(turn < N) {
			// 동일 높이일 경우
			if (height == road[turn]) {
				size++;
				turn++;
			// 1 높은 벽을 만났을 경우
			}else if (height+1 == road[turn]) {
				if (size < X) return false;
				height++;
				size = 1;
				turn++;
			// 1 낮은 벽을 만났을 경우
			}else if (height-1 == road[turn]) {
				int cnt = 0;
				for (int i = turn; i < N; i++) {
					if (cnt == X) break;
					if (road[i] != height-1) return false;
					cnt++;
				}
				
				// 길이 부족
				if (cnt < X) return false;
				turn += X;
				height--;
				size = 0;
			// 높이가 2 이상인 경우 -> 불가능
			}else {
				return false;
			}
			
		}
		
		return true;
	}

	private static int countRoad() {
		int cnt = 0 ;
		for (int i = 0; i < N; i++) {
			if (checkRoad(map[i])) cnt++;
			if (checkRoad(map2[i])) cnt++;
		}
		
		return cnt;
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
