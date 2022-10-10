package A_Test;

import java.util.*;
import java.io.*;

 
public class Solution_2117_홈방범서비스 {
 
    static int T;
    static int N, M, answer; // N : 도시 갯수, M : 하나의 집 지불비용
    static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
 
    static class Point {
        int y;
        int x;
 
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
 
    }
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]); // N : 도시 갯수
            M = Integer.parseInt(str[1]); // M : 하나의 집이 지불할 수 있는 비용
            map = new int[N][N];
 
            // map 입력
            for (int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }
 
            answer = 0;
            // bfs 돌기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    bfs(new Point(i, j), new boolean[N][N]);
                }
            }
 
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb.toString());
 
    }
 
    private static void bfs(Point point, boolean[][] isVisited) {
        int K = 0;
        int house = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        isVisited[point.y][point.x] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            K++;
            for (int i = 1; i <= size; i++) {
                Point from = queue.poll();
                if (map[from.y][from.x] == 1) {
                    // 집 갯수 증가
                    house++;
                }
                for (int d = 0; d < 4; d++) {
                    int ny = from.y + dy[d];
                    int nx = from.x + dx[d];
                    if (isRange(ny, nx) && !isVisited[ny][nx]) {
                        queue.add(new Point(ny, nx));
                        isVisited[ny][nx] = true;
                    }
                }
            }
            int pay = house * M;
            int service = K * K + (K - 1) * (K - 1);
            if (service <= pay && answer < house) {
                answer = house;
            }
        }
 
    }
 
    private static boolean isRange(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < N && nx < N;
    }
 
}