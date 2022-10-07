package A_Test;

import java.util.*;
import java.io.*;
 
public class Solution {
	
    static int n,m,k;
    static int[][] arr;
    static List<ArrayList<cell>> list;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int tc = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=1;i<=tc;i++) {
            list.clear();
            for(int j=0;j<10;j++)
                list.add(new ArrayList<>());
             
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n+k][m+k];
            for(int j=(k/2);j<(k/2)+n;j++) {
                st = new StringTokenizer(br.readLine());
                for(int z=(k/2);z<(k/2)+m;z++) {
                    arr[j][z] = Integer.parseInt(st.nextToken());
                    if(arr[j][z]!=0)
                        list.get(arr[j][z]-1).add(new cell(j, z, arr[j][z], arr[j][z],k,0));
                }
            }
            solve();
            int result = 0;
            for(int j=0;j<arr.length;j++) {
                for(int z=0;z<arr[0].length;z++) {
                    if(arr[j][z]!=0&&arr[j][z]!=-1)
                        result++;
                }
            }
            sb.append("#"+i+" "+result+"\n");
        }
        System.out.print(sb);
    }
     
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private static void solve() {
        Queue<cell> queue = new LinkedList<>();
        for(int i=9;i>=0;i--) {
            if(list.get(i).size()!=0) {
                for(int j=0;j<list.get(i).size();j++) {
                    int x = list.get(i).get(j).x;
                    int y = list.get(i).get(j).y;
                    int k = list.get(i).get(j).k;
                    int time = list.get(i).get(j).time;
                    queue.add(new cell(x, y, k, k,time,0));
                }
            }
        }
        while(!queue.isEmpty()) {
            cell t = queue.poll();
            if(t.state==0&&t.flag==1) {
                arr[t.x][t.y] = -1;
                continue;
            }
            if(t.time==0) continue;
            if(t.state==0) {
                queue.add(new cell(t.x,t.y,t.k,t.k,t.time,1));
            } else {
                queue.add(new cell(t.x, t.y, t.k,t.state-1,t.time-1,t.flag));
                continue;
            }
            for(int i=0;i<4;i++) {
                int tx = t.x+dir[i][0];
                int ty = t.y+dir[i][1];
                if(tx<0 || ty<0 || tx>=n+k || ty>=m+k) continue;
                if(arr[tx][ty]!=0) continue;
                arr[tx][ty] = t.k;
                queue.add(new cell(tx, ty, t.k, t.k,t.time-1,0));
            }
        }
    }
     
    static class cell{
        private int x,y,k,state,time,flag;
        public cell(int x,int y,int k,int state,int time,int flag) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.state = state;
            this.time = time;
            this.flag = flag;
        }
    }
}
