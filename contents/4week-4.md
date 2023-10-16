# DFS와 BFS

## baekjoon 1260

## 문제

<img src="./images/dfsbfs-1.png" width="70%">


이 문제는 그래프가 주어지면 시작 노드를 입력 받고 dfs와 bfs를 수행한 결과를 출력하는 문제이다.

단순히 dfs와 bfs를 구현하면 되는 문제라서 복습을 목적으로 풀 수 있었다.


### 코드

---




```
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 1260 {

    static  int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();

        graph = new int[N+1][N+1];
        for(int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        visited = new boolean[N+1];
        dfs(start);

        System.out.println();

        visited = new boolean[N+1];
        bfs(start);
    }
    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");

        if(start == graph.length ) return;

        for(int j = 1; j < graph.length; j++){
            if(graph[start][j] == 1 && !visited[j]){
                dfs(j);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        visited[start]=true;
        System.out.print(start+ " ");


        while (!que.isEmpty()){
            int temp = que.poll();
            for(int i = 1; i < graph.length; i++){
                if(graph[temp][i] == 1 && !visited[i]){
                    que.add(i);
                    visited[i]=true;
                    System.out.print(i+ " ");
                }
            }
        }
    }
}
```