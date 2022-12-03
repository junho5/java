package A_Test;

import java.util.*;
import java.io.*;

public class Solution_14510_나무높이 {
	
	static int tc, N, max_height, ans, sum, evenCnt;
	static int [] tree;
	static int [] mod;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input/14510.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		tc = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= tc; test_case++) {
			N = Integer.parseInt(br.readLine());
			tree = new int [N];
			mod = new int [N];
			max_height = 0;
			sum = 0;
			evenCnt = 0;
			ans = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, tree[i]);
			}
			
			for (int i = 0; i < N; i++) {
				mod[i] = max_height - tree[i];
				sum += mod[i];
				evenCnt += mod[i] / 2;
			}
			
			// 짝수개수 * 3 보다 나머지가 많을 경우 -> 짝수 있는걸 다 사용해도 남는다 -> 1로 남는 친구들 발생
			if (sum > evenCnt * 3) {
				// 짝수 개 사용한 만큼 ans에 합
				ans = evenCnt * 2;
				// 1로 남는 친구들 몇개인지 계산
				int temp = sum - evenCnt * 3;
				// ans에 1로 남은 친구들 더해주기 -> 이때 마지막 -1은 temp가 3일경우    1 -PASS- 1 -PASS- 1 이므로 -1
				ans += temp * 2 - 1;
				
			// 짝수개수 사용하였을때 같거나 클 경우
			}else{
				// 짝수개 사용한만큼 ans에 합
				ans = ( sum / 3 ) * 2;
				// 1이나 2가 남을 경우 +1, +2
				if (sum % 3 == 1) {
					ans += 1;
				}else if (sum % 3 == 2){
					ans += 2;
				}
			}
			
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");
			sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}


}