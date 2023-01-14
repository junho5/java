package Backjoon;

import java.util.*;
import java.io.*;

public class Main_B_11399_atm {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		// 사람의 수 
		int n = in.nextInt();
		
		// 인출하는데 걸리는 시간 배열
		int a[] = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = in.nextInt();
		}
		
		// 처리시간이 빠른 사람 순서대로 정렬.
		Arrays.sort(a);
		
		// 가장 빠른 손님의 처리시간으로 초기화.
		int sum = a[0];
		
		// 1번 인덱스부터 이전 손님의 처리시간으로 생기는 대기시간과 자신의 처리시간을 더해 해당 손님이 소요하는 총 시간을 저장한다.
		for(int i=1;i<n;i++) {
			a[i] += a[i-1];
			// 한 손님의 저장된 총 소요시간을 모두 더한다.
			sum+=a[i];
		}
		
		System.out.println(sum);
		in.close();
	}

}


