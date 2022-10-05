package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_17143_낚시왕2 {
	
	static class Shark{
		int x,y,speed,dir,size;
		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
		
	}
	
	static int R,C,M,ans;
	static int x,y,speed,dir,size;
	static Shark [][] map;
	static Shark [][] copy_map;
	static int dx [] = {-1,1,0,0};
	static int dy [] = {0,0,1,-1};
	
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("input/17143.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // x 좌표
        C = Integer.parseInt(st.nextToken()); // y 좌표
        M = Integer.parseInt(st.nextToken()); // 상어 수
        
        map = new Shark [R][C];
        ans = 0;
        
        
        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			speed = Integer.parseInt(st.nextToken()); // 속도
			dir = Integer.parseInt(st.nextToken())-1; // 위: 1 / 아래: 2 / 오른쪽: 3 / 왼쪽: 4
			size = Integer.parseInt(st.nextToken()); // 크기
			map[x-1][y-1] = new Shark(x-1, y-1, speed, dir, size);
			
		}
        
//        System.out.println("-------map -------");
//        print(map);
        
        for (int i = 0; i < C; i++) {
//        	System.out.println("-------낚시 후 -------");
        	angler(i); // 낚시꾼이 상어 잡기
//        	print(map);
//        	System.out.println("-------move-------");
			move(); // 상어 이동
//			print(copy_map);
			for (int j = 0; j < R; j++) {
				for (int j2 = 0; j2 < C; j2++) {
					map[j][j2] = copy_map[j][j2];
				}
			}
		}
        sb.append(ans);
        System.out.println(sb.toString());
        
    }
    
	private static void angler(int index) {
		for (int i = 0; i < R; i++) {
			if(map[i][index] != null) {
				ans += map[i][index].size;
				map[i][index] = null;
				return;
			}
		}
	}


	private static void move() {
		copy_map = new Shark [R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != null) {
//					System.out.println("상어발견");
//					System.out.printf("%d %d\n",map[i][j].x,map[i][j].y);
					int d_x = map[i][j].x;
					int d_y = map[i][j].y;
//					System.out.printf("%d %d\n",d_x,d_y);
					int range = map[i][j].speed;
					int move = map[i][j].dir;
					int sz = map[i][j].size;
//					System.out.println(move);
					
					for (int k = 0; k < range; k++) {
//						System.out.println(move);
						if (k==0) {
							if (d_x == 0 && move == 0) move = 1;
							if (d_x == R-1 && move == 1) move = 0;
							if (d_y == C-1 && move == 2) move = 3;
							if (d_y == 0 && move == 3) move = 2;
						}
						switch (move) {
						case 0: // 상
							d_x += dx[0];
							d_y += dy[0];
							if (d_x == 0) {
								map[i][j].dir = 1; 
								move = 1;
							}
							break;
						case 1: // 하
							d_x += dx[1];
							d_y += dy[1];
							if (d_x == R-1) {
								map[i][j].dir = 0; 
								move = 0;
							}
							break;
						case 2: // 우
							d_x += dx[2];
							d_y += dy[2];
							if (d_y == C-1) {
								map[i][j].dir = 3; 
								move = 3;
							}
							break;
						case 3: // 좌
							d_x += dx[3];
							d_y += dy[3];
							if (d_y == 0) {
								map[i][j].dir = 2; 
								move = 2;
							}
							break;
							
						}
					}
//					System.out.printf("%d %d\n",d_x,d_y);
//					print(copy_map);
					if (copy_map[d_x][d_y] != null && copy_map[d_x][d_y].size > sz) {
						continue;
					}
					copy_map[d_x][d_y] = new Shark(d_x, d_y, range , move, sz);
//					System.out.println("--------------");
//					print(copy_map);
					
				}
			}
			
		}
	}
		



	private static void print(Shark[][] map) {
		for (Shark [] data_arr : map) {
        	for (Shark s : data_arr) {
        		if (s!=null) {
        			System.out.print("shark");
        			System.out.print("        ");
        		}else {
        			System.out.print("X");
        			System.out.print("            ");
        		}
        	}
        	System.out.println();
        }
		
	}
    


	
	
}


