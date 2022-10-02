package SWEA;

import java.util.*;
import java.io.*;

public class hwalgo23_서울_12반_오준호{

    static int N;
	static int min;
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
    
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			min = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			isVisited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			
			
		} 
	}
}