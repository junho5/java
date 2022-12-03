package A_Test;

import java.util.*;
import java.io.*;
 
public class Solution_1767_프로세서연결하기 {
     
    static int tc,N,maxCore,minLength;
    static int [][] map;
    static List<int []> coreList;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
 
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("input/1767.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        tc = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= tc; test_case++) {
            N = Integer.parseInt(br.readLine());
            maxCore = Integer.MIN_VALUE;
            minLength = Integer.MAX_VALUE;
            coreList = new ArrayList<int[]>();
            map = new int [N][N];
             
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && j != 0 && i != N-1 && j != N-1) {
                        coreList.add(new int [] {i,j});
                    }
                }
            }
             
            dfs(0,0);
             
            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(minLength);
            sb.append("\n");
        }
        System.out.println(sb.toString());
         
    }
 
    private static void dfs(int index, int cnt) {
        if (maxCore > coreList.size() - index + cnt) return;
         
        if (index == coreList.size()) {
            int len = cal();
            if (maxCore < cnt) {
                maxCore = cnt;
                minLength = len;
            }else if (maxCore == cnt) {
                minLength = Math.min(minLength, len);
            }
            return;
        }
         
        // 연결
        int [] temp = coreList.get(index);
        int x = temp[0];
        int y = temp[1];
        for (int i = 0; i < 4; i++) {
            if(isOk(x,y,i)) {
                setLine(x,y,i,2);
                dfs(index+1,cnt+1);
                setLine(x,y,i,0);
            }
        }
         
        // 연결 안함
        dfs(index + 1, cnt);
         
         
    }
 
    private static void setLine(int x, int y, int dir, int type) {
        int mx = x;
        int my = y;
        while(true) {
            mx += dx[dir];
            my += dy[dir];
             
            if (mx < 0 || my < 0 || mx >= N || my >= N) break;
            map[mx][my] = type;
        }
    }
 
    private static boolean isOk(int x, int y, int dir) {
        int mx = x;
        int my = y;
        while(true) {
            mx += dx[dir];
            my += dy[dir];
             
            if (mx < 0 || my < 0 || mx >= N || my >= N) break;
            if (map[mx][my] >= 1) return false;
        }
        return true;
    }
 
    private static int cal() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) cnt++;
            }
        }
        return cnt;
    }
 
}