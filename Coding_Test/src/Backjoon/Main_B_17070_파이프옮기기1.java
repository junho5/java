package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_17070_파이프옮기기1 {
    static int ans, N;
    static int[][] map;

    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("input/17070.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        // map을 0으로 둘러싸인 테두리를 만들기 위해 +2
        map = new int[N+2][N+2];
        // ---------------------------------------------------
        
        // 테두리를 제외하고 벽인지 유무에 따라 벽이면 4 아니면 0
        for(int x = 1; x<N+1; x++) {
        	st = new StringTokenizer(br.readLine());
            for(int y = 1; y<N+1; y++) {
                int block = Integer.parseInt(st.nextToken());
                if(block==0) {
                    map[x][y]=4;
                }
                else {
                    map[x][y]=block;
                }
            }
        }
        printMap(map);
        // ---------------------------------------------------
        
        // 파이프 초기 위치 (1,1) (1,2) 위치에 7로 파이프 표시
        map[1][1]=7; map[1][2]=7; 
        // ---------------------------------------------------
        
        // 초기 생성된 map 확인
//        System.out.println("-------------------------");
//        printMap(map);
//        System.out.println("-------------------------");
        // ---------------------------------------------------
        
        // 최종  정답 담을 변수 및 시작 위치 (1,2)
        ans = 0;
        int x = 1; int y = 2; 
        // ---------------------------------------------------

        dfs(x,y);
        System.out.println(ans);

        }
    public static void dfs(int x,int y) {
        if(x==N && y==N) {
            ans++;
//            System.out.println(Arrays.deepToString(map));
            return;
        }else {
        	// 파이프가 가로일 경우
        	if(map[x][y-1]==7) { 
        		// 오른쪽으로 밀기
                if(map[x][y+1]==4 ) {  
                    map[x][y-1]=4; map[x][y+1]=7;
                    dfs(x,y+1);
                    map[x][y-1]=7; map[x][y+1]=4;
                }
                // 대각선으로 밀기
                if(map[x+1][y+1]==4 && map[x][y+1]!=1 && map[x+1][y]!=1) { 
                    map[x][y-1]=4; map[x+1][y+1]=7;
                    dfs(x+1,y+1);
                    map[x][y-1]=7; map[x+1][y+1]=4;
                }
            }
        	// 파이프가 세로일 경우
            else if(map[x-1][y]==7) {
            	// 밑으로 밀기
                if(map[x+1][y]==4) { 
                    map[x-1][y]=4; map[x+1][y]=7;
                    dfs(x+1,y);
                    map[x-1][y]=7; map[x+1][y]=4;
                }
                // 대각선으로 밀기
                if(map[x+1][y+1]==4 && map[x][y+1]!=1 && map[x+1][y]!=1) { 
                    map[x-1][y]=4; map[x+1][y+1]=7;
                    dfs(x+1,y+1);
                    map[x-1][y]=7; map[x+1][y+1]=4;
                }
            }
        	// 파이프가 대각선일 경우
            else if(map[x-1][y-1]==7) {
            	// 오른쪽으로 밀기
                if(map[x][y+1]==4) { 
                    map[x-1][y-1]=4; map[x][y+1]=7;
                    dfs(x,y+1);
                    map[x-1][y-1]=7; map[x][y+1]=4;
                }
                // 밑으로 밀기
                if(map[x+1][y]==4) { 
                    map[x-1][y-1]=4; map[x+1][y]=7;
                    dfs(x+1,y);
                    map[x-1][y-1]=7; map[x+1][y]=4;
                }
                // 대각선으로 밀기
                if(map[x+1][y+1]==4 && map[x][y+1]!=1 && map[x+1][y]!=1) { 
                    map[x-1][y-1]=4; map[x+1][y+1]=7;
                    dfs(x+1,y+1);
                    map[x-1][y-1]=7; map[x+1][y+1]=4;
                }
            }
        }
    }

	private static void printMap(int[][] map) {
		for (int [] datas : map) {
        	for (int data : datas) {
        		System.out.print(data + " ");
        	}
        	System.out.println();
        }
	}

    }

