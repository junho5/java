package SWEA;

import java.util.*;
import java.io.*;

public class Solution_5656_벽돌깨기 {
	
	static int tc;
	static int N, W, H, ans;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	static class Stone {
		int x, y, size;

		public Stone(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/5656.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= tc; test_case++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;

			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			System.out.println("초기 맵");
//			print(map);
			go(map, 0);
//			System.out.println(ans);

			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void go(int[][] map, int cnt) {
		// 중복 순열 부분
		if (cnt == N) {
			int result = getblock(map);
			if (result < ans) ans = result;
			return;
		}
		
		// 복사할 map 설정
		int [][] newmap = new int [H][W];
		for (int i = 0; i < W; i++) {
			int index = 0;
			// 시작 블록부분 찾기
			while (index < H && map[index][i] == 0) index++;
			
			// 시작 블록부분 없으면 cnt만 더한후 go함수 실행
			if (index == H) {
				go(map,cnt+1);
			// 시작 블록 찾았으면 실행
			}else {
				copy(map,newmap);
				// 터트리는 함수에 x,y좌표 전달
				boom(newmap,index,i);
				// 새로운 맵 down 함수 적용하고 업데이트
				newmap = down(newmap);
				// 다음 구슬 떨어트리기
				go(newmap,cnt+1);
			}
		}
	}

	private static int getblock(int[][] map) {
		int result = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] != 0) result ++;
			}
		}
		return result;
	}

	private static int[][] down(int[][] newmap) {
		int[][] map2 = new int[H][W];

		for (int i = 0; i < W; i++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j = H - 1; j >= 0; j--) {
				if (newmap[j][i] != 0) {
					list.add(newmap[j][i]);
				}
			}
			for (int j = 1; j <= list.size(); j++) {
				map2[H - j][i] = list.get(j - 1);
			}
		}
		return map2;
	}

	private static void boom(int[][] newmap, int index, int i) {
		Queue<Stone> q = new LinkedList<Stone>();
		// 1보다 작으면 굳이 큐에 넣을 필요없음 그냥 방문처리만 하면됨
		if(newmap[index][i] > 1) {
			q.add(new Stone(index, i, newmap[index][i]));
		}
		// 방문 처리
		newmap[index][i] = 0;
		
		while(!q.isEmpty()) {
			Stone temp = q.poll();
			int range = temp.size;
			
			// 4방 탐색할때 range만큼 더 돌린다. 
			for (int j = 0; j < 4; j++) {
				int nx = temp.x;
				int ny = temp.y;
				
				for (int k = 0; k < range-1; k++) {
					nx += dx[j];
					ny += dy[j];
					
					if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
					if (newmap[nx][ny] == 0) continue;
					
					q.add(new Stone(nx, ny, newmap[nx][ny]));
					newmap[nx][ny] = 0;
				}
			}
		}
	}

	private static void copy(int[][] map, int[][] newmap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newmap[i][j] = map[i][j];
			}
		}
	}
}
