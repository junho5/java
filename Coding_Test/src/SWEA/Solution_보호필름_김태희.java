package SWEA;

import java.util.*;
import java.io.*;

public class Solution_보호필름_김태희 {

	static int  D,W,K,film[][];
	static final int A=0,B=1;
	static int[] drugA , drugB;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for(int tc=1; tc<=TC; ++tc) {
			st = new StringTokenizer(in.readLine().trim());
			D = Integer.parseInt(st.nextToken()); // 막 두께 
			W = Integer.parseInt(st.nextToken()); // 막 너비 
			K = Integer.parseInt(st.nextToken()); // 합격기준 연속 셀의 개수 
			film = new int[D][W];
			drugA = new int[W];
			drugB = new int[W];
			
			for(int i=0; i<D; ++i) {
				st = new StringTokenizer(in.readLine().trim());
				for(int j=0; j<W; ++j) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Arrays.fill(drugA, A);
			Arrays.fill(drugB, B);
			
			System.out.println("#"+tc+" "+process());
		}
	}
	
	private static int process() {
		
		int cnt = 0; // 약품 투여 막 개수
		while(cnt<=K) { // 0번 ~ K번 약품 투여 시도
			if(comb(0,0,cnt)) return cnt; // 해당 횟수로 약품을 투여해서 성능검사에 통과했다면 cnt 리턴
			++cnt;
		}
		return -1;
	}
	
	private static boolean comb(int start,int cnt,int targetCnt) {
		
		if(cnt == targetCnt) {
			
			return check(); // 성능검사 결과 리턴
		}
		
		for (int i = start ; i < D; i++) {
			int[] backup = film[i];
			
			// 약품 사용A
			film[i] = drugA;
			if(comb(i+1, cnt+1, targetCnt)) return true;
			
			// 약품 사용B
			film[i] = drugB;
			if(comb(i+1, cnt+1, targetCnt)) return true;
			
			film[i] = backup;
		}
		return false;
	}

	private static boolean check() {
		// 열 우선탐색(수직으로 연속된 K개를 체크)
		L:for (int j = 0; j < W; j++) {
			int count = 1;
			for (int i = 1; i < D; i++) { // 1행부터 마지막행까지 직전과 자기자신이 셀의 연속성 체크
				if(film[i-1][j] != film[i][j]) {// 인접한 2개 셀이 다르다면
					count = 1;
				}else { // 인접한 2개 셀이 같다면 
					if(++count==K) continue L; // 연속셀의 갯수가 K이면 더이상 해당 열 연속성 체크하지 않는다.
				}	
			}
			if(count<K) return false; //해당 열이 검사기준을 통과하지 못한다면 결국 실패
		}
		return true;
	}

}








