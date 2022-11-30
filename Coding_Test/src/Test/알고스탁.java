package Test;

import java.util.*;
import java.io.*;

public class 알고스탁 {

	// money = 잔고 | maxBenefit = 월별 최대 이익 <= 월별로 어떤 종목을 몇개 사는 가에 따라 이익이 달라지는데
	// 이 경우의 수중 최대 이익 발생하면 이곳에 계속 갱신
	static int tc,Ms,Ma,N,L,money,maxBenefit;
	static int [][] val;
	static List<Stock> stockList;
	
	// diff : nextVal - nowVal; | 상승하는 종목만 고려 -> 음수 고려 X
	static class Stock{
		int nowVal; // 현재 가격
		int nextVal; // 다음달 가격
		int diff; // 1주당 이익
		public Stock(int nowVal, int nextVal, int diff) {
			super();
			this.nowVal = nowVal;
			this.nextVal = nextVal;
			this.diff = diff;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/5.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			// 변수 초기화, 입력 처리
			st = new StringTokenizer(br.readLine());
			Ms = Integer.parseInt(st.nextToken()); // 초기 예치금
			Ma = Integer.parseInt(st.nextToken()); // 월별 불입금
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 종목 수
			L = Integer.parseInt(st.nextToken()); // 기간
			
			val = new int [N][L+1]; // 0개월 포함한 과거 데이터
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < L + 1; j++) {
					val[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 잔고 초기세팅
			money = Ms;
			
			// 월별로 최대 이익을 계산
			for (int i = 0; i < L; i++) {
				
				// stockList 초기화
				// stockList 에 해당 월 기준으로 상승 종목을 담는다.
				stockList = new ArrayList<Stock>();
				for (int j = 0; j < N; j++) { // N 개의 주식 종목 중에 상승분
					// 상승하는 종목일 경우
					if(val[j][i+1] > val[j][i]) {
						stockList.add(new Stock(val[j][i], val[j][i+1], val[j][i+1]- val[j][i]));
					}
				}
				
				// stockList 에 담겨진 종목들에 대해 어떤 종목을 몇 주 사면 최대 이익이 발생하는지 dfs로 따진다
				// 상승 종목이 없으면 안 사도된다
				// maxBenefit 에 최대 이익을 최종 저장
				maxBenefit = 0;
				
				if (stockList.size() == 1) { // 상승 종목이 한 개일경우 경우의 수 따질 필요 X
					// maxBenefit 바로계산
					// 수익 : 주식수 * 차익 (담달 가격 - 현재가격)
					// 주식 수 : money / stockList.get(0).nowVal
					// 차익 : stockList.get(0).diff
					maxBenefit = money / stockList.get(0).nowVal * stockList.get(0).diff;
					
				}else if (stockList.size() > 1) { // 상승 종목이 두 개 이상일 경우 어떤 종목을 몇 개 사는게 유리한지 완탐 -> dfs
					// dfs
					dfs(0,money,0); // 맨 앞, 현재 잔고, 수익 0
					
				}
				
				// 상승 종목이 존재하지 않을경우 -> 안산다 (아무것도 안하면 OK)
				
				// 매도
				money += maxBenefit;
				// 월별 불입금
				money += Ma;
				
			}
			
			int ans = money - ( Ms + Ma * L );
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// 대상 : stockList 에 담긴 Stock 각각
	// index : 상승 종목 중 특정 종목의 index | money : 현재 시점의 잔고 | benefit : 현재 시점까지의 이익
	private static void dfs(int index, int money, int benefit) {
		// 기저 조건
		if (index == stockList.size()) {
			// 최대 이익 갱신
			maxBenefit = Math.max(maxBenefit, benefit);
			return;
		}
		
		Stock stock = stockList.get(index);
		
		// 현재 종목을 선택하지 않고 다음 종목으로 가기
		// index 는 1증가, money, benefit는 그대로
		dfs(index + 1, money, benefit);
		
		// 현재 종목을 1개 구매하고 그 종목을 다시 고려하기
		// index 그대로 money는 종목 가격빼고, benefit은 종목의 이익 더하고 해서 dfs 진행
		// 살 수 있을 때 산다.
		if (money - stock.nowVal >= 0) {
			dfs(index, money - stock.nowVal, benefit + stock.diff);
		}
		
		
	}
	
	
	

}
