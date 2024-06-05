package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;

    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx={1,0,-1,0};
    public static int[] dy={0,-1,0,1};
    public static List<Integer> results;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[11][11];
        visited=new boolean[11][11];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        results= new ArrayList<>();
        for (int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j]==1 && !visited[i][j]){
                    cnt=0;
                    visited[i][j]=true;
                    dfs(j,i);
                    results.add(cnt);
                }
            }
        }
        Collections.sort(results);

        if (results.isEmpty()){
            System.out.println("0");
        }
        else {
            System.out.println(results.size());
            for(int i=0;i< results.size()-1;i++){
                System.out.print(results.get(i) + " ");
            }
            System.out.print(results.get(results.size()-1));
        }
    }

    public static void dfs(int x, int y){
        cnt+=1;
        for(int k=0;k<4;k++){
            int nx=x+dx[k];
            int ny=y+dy[k];

            if(0<=nx && nx<N && 0<=ny && ny<N){
                if(graph[ny][nx]==1 && !visited[ny][nx]){
                    visited[ny][nx]=true;
                    dfs(nx,ny);
                }
            }
        }
    }
}