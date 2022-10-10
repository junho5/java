package frame;

import java.util.*;


import java.io.*;

public class Test {
	
	static class Cell implements Comparable<Cell>{
		int x,y,time,life,end;

		public Cell(int x, int y, int time, int life, int end) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.life = life;
			this.end = end;
		}

		@Override
		public int compareTo(Cell o) {
			if (this.end == o.end) {
				return o.time - this.time;
			}else {
				return this.end - o.end;
			}
		}

		@Override
		public String toString() {
			return "Cell [x=" + x + ", y=" + y + ", time=" + time + ", life=" + life + ", end=" + end + "]";
		}

		
	}
	
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input/.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Cell> q = new PriorityQueue<>();
		
		q.add(new Cell(1, 1, 2, 0, 1));
		q.add(new Cell(2, 2, 2, 0, 2));
		q.add(new Cell(3, 3, 3, 0, 2));
		q.add(new Cell(4, 4, 4, 0, 1));
		
		for (Cell c : q) {
			System.out.println(c.toString());
		}
		
	}


}
