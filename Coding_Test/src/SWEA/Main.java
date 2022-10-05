package SWEA;

import java.io.*;
import java.util.*;
 
public class Main {
    public static StringTokenizer stk;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = {0, -1, 0};
    public static int[] dy = {-1, 0, 1};
    public static int n, m, d, ans = 0;
    public static boolean[] used;   
    public static int[][] map;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        d = Integer.parseInt(stk.nextToken());
        map = new int[n + 1][m];
        used = new boolean[m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        nCr(0, 0);
        System.out.println(ans);
    }
 
    //궁수 자리 선택
    public static void nCr(int idx, int cnt) {
        if (cnt == 3) {
            int[][] nmap = new int[n + 1][m];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < m; j++) {
                    nmap[i][j] = map[i][j];
                }
            }
            bfs(nmap);
            return;
        }
        for (int i = idx; i < m; i++) {
            if (!used[i]) {
                used[i] = true;
                nCr(i, cnt + 1);
                used[i] = false;
            }
        }
    }
 
    public static void bfs(int[][] nmap) {
        int cnt = 0;
      //궁수 한칸씩 앞으로 
        for (int i = n; i > 0; i--) {   
            int archerIdx = 0;
            Queue<Pair> q = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                //nmap에서 궁수 위치는 2
                if (used[j]) {
                    nmap[i][j] = 2;
                    q.add(new Pair(i - 1, j, 1, archerIdx++));
                } else {    
                	//궁수 위치가 아니면 0
                    nmap[i][j] = 0;
                }
            }
 
            boolean[] isEnemyFind = new boolean[3];     //각 궁수가 몬스터를 찾았는지
            boolean[][][] visited = new boolean[n][m][3];   //각 궁수가 해당 좌표를 방문했는지
            boolean[][] isAlreadyFindLocation = new boolean[n][m];  //이미 다른 궁수가 찾은 목표물인지
            ArrayList<Pair> alist = new ArrayList<>();
 
            while (!q.isEmpty()) {
                Pair p = q.poll();
                if (isEnemyFind[p.idx]) continue;
                if (nmap[p.x][p.y] == 1) {
                    isEnemyFind[p.idx] = true;
                    if (!isAlreadyFindLocation[p.x][p.y]) {
                        isAlreadyFindLocation[p.x][p.y] = true;
                        alist.add(p);
                        cnt++;
                    }
                    continue;
                }
                if (!isEnemyFind[p.idx]) {
                    visited[p.x][p.y][p.idx] = true;
                    for (int j = 0; j < 3; j++) {
                        int nx = p.x + dx[j];
                        int ny = p.y + dy[j];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny][p.idx] && p.depth < d) {
                            q.add(new Pair(nx, ny, p.depth + 1, p.idx));
                        }
                    }
                }
            }
            for (int j = 0; j < alist.size(); j++) {
                Pair p = alist.get(j);
                nmap[p.x][p.y] = 0;
            }
        }
        ans = Math.max(ans, cnt);
    }
 
    public static class Pair {
        int x, y, depth, idx;
 
        public Pair(int x, int y, int depth, int idx) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.idx = idx;
        }
    }
}
