package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_1260_DFSBFS {
	
	static int N,M,V;
	static int [][] map;
	static boolean visited [];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception  {
		System.setIn(new FileInputStream("input/1260.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		V = Integer.parseInt(st.nextToken()); // 스타트
		
		map = new int [N+1][N+1];
		visited = new boolean [N+1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		
		dfs(V);
		visited = new boolean [N+1];
		System.out.println();
		bfs(V);
		System.out.println(sb.toString());
		
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = true;
		q.add(start);
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			sb.append(temp+" ");
			
			for (int i = 1; i <= N; i++) {
				if (visited[i] == false && map[temp][i] == 1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
		
	}

	private static void dfs(int start) {
		visited[start] = true;
		System.out.print(start+" ");
		
		for (int i = 1; i <= N; i++) {
			if (visited[i] == false && map[start][i] == 1) {
				dfs(i);
			}
		}
		
		
	}




}
