package SK;

import java.util.*;
import java.io.*;

public class Problem1 {
	
	static String [] bakery_schedule;
	static String current_time;
	static int k;
	static int ans;
	static int time;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ans = -1;
		
		bakery_schedule = new String []{"09:05 10","12:20 5","13:25 6","14:24 5"};
//		bakery_schedule = new String []{"12:00 10"};
		current_time = "12:05";
//		current_time = "12:00";
		k = 10;
		time = 0;
		
		int c_h = (current_time.charAt(0)-48)*10 + current_time.charAt(1)-48;
		int c_m = (current_time.charAt(3)-48)*10 + current_time.charAt(4)-48;
//		System.out.printf("%d 시 %d 분 \n",c_h,c_m);
//		System.out.println("----------------");
		
		for (int i = 0; i < bakery_schedule.length; i++) {
			String time_temp = bakery_schedule[i];
			String [] temp = time_temp.split(" ");
			int b_h = (temp[0].charAt(0)-48)*10 + temp[0].charAt(1)-48;
			int b_m = (temp[0].charAt(3)-48)*10 + temp[0].charAt(4)-48;
			int cnt = Integer.parseInt(temp[1]);
//			System.out.printf("%d 시 %d 분 %d 개 \n",b_h,b_m,cnt);
			
			
			if (c_h > b_h) continue;
			if (b_h == c_h && c_m > b_m) continue;
//			System.out.printf("%d 시 %d 분 %d 개 \n",b_h,b_m,cnt);
			k -= cnt;
			time += (b_h - c_h) * 60;
			time += b_m - c_m;
			c_h = b_h;
			c_m = b_m;
//			System.out.printf("k = %d  time = %d\n",k,time);
			if (k <= 0) break;
			
		}
		if (k>=1) {
			ans = -1;
		}else {
			ans = time;
		}
		System.out.println(ans);
		
		
		
		
	}


}

