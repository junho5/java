package SWEA;

import java.util.*;
import java.io.*;

 
public class Solution {
    static int tc, n, m, r, c, l, count;
    static int[][] map, visited, copy;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] search = { { 1, 2, 5, 6 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 }, { 1, 3, 6, 7 } }; 
 
 
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        tc = Integer.parseInt(br.readLine());
        
        for (int tn = 1; tn <= tc; tn++) {
        	st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
 
            map = new int[n][m];
            copy = new int[n][m];
            visited = new int[n][m];
 
            for (int i = 0; i < n; i++) {
            	st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            bfs(r, c);
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy[i][j] > 0 && copy[i][j] <= l) {
                        count++;
                    }
                }
            }
            System.out.println("#" + tn + " " + count);
 
        }
    }
 
    private static void bfs(int x, int y) {
        Queue<Pipe> q = new LinkedList<>();
        q.offer(new Pipe(x, y));
        visited[x][y] = 1;
        copy[x][y] = 1;
 
        while (!q.isEmpty()) {
            Pipe pipe = q.poll();
            int nx, ny;
            switch (map[pipe.x][pipe.y]) {
            case 1: 
                for (int i = 0; i < 4; i++) {
                    nx = pipe.x + dx[i];
                    ny = pipe.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && map[nx][ny] > 0) {
                        for (int j = 0; j < 4; j++) {
                            if (map[nx][ny] == search[i][j]) {
                                q.offer(new Pipe(nx, ny));
                                visited[nx][ny] = 1;
                                copy[nx][ny] = copy[pipe.x][pipe.y] + 1;
                            }
                        }
                    }
                }
                break;
            case 2: 
                for (int i = 0; i < 2; i++) {
                    nx = pipe.x + dx[i];
                    ny = pipe.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && map[nx][ny] > 0) {
                        for (int j = 0; j < 4; j++) {
                            if (map[nx][ny] == search[i][j]) {
                                q.offer(new Pipe(nx, ny));
                                visited[nx][ny] = 1;
                                copy[nx][ny] = copy[pipe.x][pipe.y] + 1;
                            }
                        }
                    }
                }
                break;
            case 3: 
                for (int i = 2; i < 4; i++) {
                    nx = pipe.x + dx[i];
                    ny = pipe.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && map[nx][ny] > 0) {
                        for (int j = 0; j < 4; j++) {
                            if (map[nx][ny] == search[i][j]) {
                                q.offer(new Pipe(nx, ny));
                                visited[nx][ny] = 1;
                                copy[nx][ny] = copy[pipe.x][pipe.y] + 1;
                            }
                        }
                    }
                }
                break;
            case 4: 
                for (int i = 0; i < 4; i += 3) {
                    nx = pipe.x + dx[i];
                    ny = pipe.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && map[nx][ny] > 0) {
                        for (int j = 0; j < 4; j++) {
                            if (map[nx][ny] == search[i][j]) {
                                q.offer(new Pipe(nx, ny));
                                visited[nx][ny] = 1;
                                copy[nx][ny] = copy[pipe.x][pipe.y] + 1;
                            }
                        }
                    }
                }
                break;
            case 5: 
                for (int i = 1; i < 4; i += 2) {
                    nx = pipe.x + dx[i];
                    ny = pipe.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && map[nx][ny] > 0) {
                        for (int j = 0; j < 4; j++) {
                            if (map[nx][ny] == search[i][j]) {
                                q.offer(new Pipe(nx, ny));
                                visited[nx][ny] = 1;
                                copy[nx][ny] = copy[pipe.x][pipe.y] + 1;
                            }
                        }
                    }
                }
                break;
            case 6: 
                for (int i = 1; i < 3; i++) {
                    nx = pipe.x + dx[i];
                    ny = pipe.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && map[nx][ny] > 0) {
                        for (int j = 0; j < 4; j++) {
                            if (map[nx][ny] == search[i][j]) {
                                q.offer(new Pipe(nx, ny));
                                visited[nx][ny] = 1;
                                copy[nx][ny] = copy[pipe.x][pipe.y] + 1;
                            }
                        }
                    }
                }
                break;
            case 7: 
                for (int i = 0; i < 3; i += 2) {
                    nx = pipe.x + dx[i];
                    ny = pipe.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && map[nx][ny] > 0) {
                        for (int j = 0; j < 4; j++) {
                            if (map[nx][ny] == search[i][j]) {
                                q.offer(new Pipe(nx, ny));
                                visited[nx][ny] = 1;
                                copy[nx][ny] = copy[pipe.x][pipe.y] + 1;
                            }
                        }
                    }
                }
                break;
            }
        }
    }
    private static class Pipe {
    	private int x, y;
    	
    	public Pipe(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
}
