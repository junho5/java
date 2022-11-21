package A_Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_미생물격리_김태희 {

	static class Micro implements Comparable<Micro>{
		int r,c,cnt,dir;

		public Micro(int r, int c, int cnt, int dir) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

		@Override
		public int compareTo(Micro o) {
			return o.cnt - this.cnt;
		}
	}
	
	static int N,M,K;
	static Micro[][] map;
	static PriorityQueue<Micro> pQueue ;
	static int[] dr = {0,-1,1,0,0}; // 0:안씀   상: 1, 하: 2, 좌: 3, 우: 4
	static int[] dc = {0,0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/2382.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		
		for (int tc = 1; tc <=TC ; ++tc) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 맵 크기
			M = Integer.parseInt(st.nextToken()); // 시간
			K = Integer.parseInt(st.nextToken()); // 초기 군집의 수
			
			map = new Micro[N][N]; // 해당 시간에 이동한 미생물 군집 map
			pQueue = new PriorityQueue<>(); // 살아있는 미생물 군집 리스트( 군집의 크기가 큰 순서대로 나옴 )
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				pQueue.add(new Micro(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			System.out.println("#"+tc+" "+move());
		}
	}

	private static int move() {
		
		int time = M;
		int remainCnt=0;
		while(--time>=0) {
			// 살아있는 미생물 군집리스트 각각에 대해 이동 처리
			while(!pQueue.isEmpty()) {
				Micro cur = pQueue.poll();
				
				int nr = cur.r += dr[cur.dir];
				int nc = cur.c += dc[cur.dir];
				
				// 이동 위치가 약품셀 위치인지 확인
				if(nr==0 || nr==N-1 || nc==0 || nc==N-1) {
					// 미생물군집의 크기 절반으로
					cur.cnt /= 2;
					if(cur.cnt==0) {
						// 군집 소멸 
						continue;
					}
					
					// 방향 턴 : 상(1) -> 하(2), 좌(3) -> 우(4), 하(2)-> 상(1), 우(4)-> 좌(3)
					if(cur.dir==1 || cur.dir==3) cur.dir++;
					else cur.dir--;
				}
				
				if(map[nr][nc] == null) { // 이동한 위치에 처음 온 미생물군집이면 현재 위치에 올수 있는 가장 큰 군집
					map[nr][nc] = cur;
				}else {
					map[nr][nc].cnt += cur.cnt;
				}
			}// end for pQueue
			
			remainCnt = reset();
		}
		
		return remainCnt;
	}
	
	private static int reset() { // 미생물 군집이 모두 이동된 map을 활용하여 살아있는 군집리스트에 넣고 map 초기화
		int total = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(map[r][c] == null) continue;
				
				total += map[r][c].cnt;
				pQueue.offer(map[r][c]);
				map[r][c] = null;
			}			
		}
		return total;
		
	}
}
