package A_Test;

import java.util.*;
import java.io.*;

public class Main_B_20055_컨베이어벨트위의로봇 {

	static int N, K, time;
	static int start, end;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/20055.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 벨트 길이
		K = Integer.parseInt(st.nextToken()); // 제한 수
		time = 0; // 답

		belt = new int[2 * N]; // 내구도 (벨트)
		robot = new boolean[2 * N]; // 로봇 위치
		start = 0; // 올리는 위치
		end = N - 1; // 내리는 위치
		
		// 내구도 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < belt.length; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			time++;
			move_belt(belt, robot); // 벨트랑 로봇 이동
			drop(robot); // 로봇 drop 위치에 있으면 제거
			move_robot(robot); // 로봇 움직이기
			drop(robot); // 로봇 drop 위치에 있으면 제거
			insert(); // 로봇 올리기
			
			// K개수 이상이면 중지
			if (zero_check(belt))
				break;
		}
		System.out.println(time);

	}
	
	// 0 개수 체크해서 K개 이상이면 true 아니면 false 반환 함수
	private static boolean zero_check(int[] belt) {
		int cnt = 0;
		for (int i = 0; i < belt.length; i++) {
			if (belt[i] == 0) {
				cnt++;
			}
		}
		if (cnt >= K) {
			return true;
		} else {
			return false;
		}
	}
	
	// 로봇 내리는 위치에 있으면 boolean값 변경 함수
	private static void drop(boolean[] robot) {
		if (robot[end] == true) {
			robot[end] = false;
		}
	}
	
	// 로봇 벨트위에 올리고 내구도 감소 함수
	private static void insert() {
		if (robot[start] == false && belt[start] > 0) {
			robot[start] = true;
			belt[start]--;
		}
	}
	
	// 로봇 움직이는 함수
	private static void move_robot(boolean[] robot) {
		for (int i = robot.length - 1; i >= 0; i--) {
			if (robot[i] == true) {
				if (i == robot.length - 1) { // 마지막에 로봇이 위치하면
					if (robot[0] == false && belt[0] > 0) {
						belt[0]--;
						robot[i] = false;
						robot[0] = true;
					}
				} else { // 그 외
					if (robot[i + 1] == false && belt[i + 1] > 0) {
						belt[i + 1]--;
						robot[i] = false;
						robot[i + 1] = true;
					}
				}
			}
		}
	}
	
	// 벨트 움직이는 함수 ( 벨트 , 로봇 동시에 움직임 )
	private static void move_belt(int[] belt, boolean[] robot) {
		int temp_blet = belt[belt.length - 1];
		boolean temp_robot = robot[robot.length - 1];
		for (int i = belt.length - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
			robot[i] = robot[i - 1];
		}
		belt[0] = temp_blet;
		robot[0] = temp_robot;
	}

}
