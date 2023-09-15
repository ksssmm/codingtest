import java.util.*;
class Solution {
         
        int[] dx ={0, 0, 1, -1};
        int[] dy ={1, -1, 0, 0};
    
    public int solution(int[][] maps) {

        int[][] visit = new int[maps.length][maps[0].length];
        
        bfs(maps, visit);
        int answer = visit[maps.length - 1][maps[0].length - 1];
        if(answer == 0 ) return -1;
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visit){
        
        Queue<int[]> next = new LinkedList<>();
        next.add(new int[]{0,0});
        visit[0][0]=1;
        
        int count = 0;
        while(!next.isEmpty()){
            int[] temp = next.poll();
            int x = temp[0];
            int y = temp[1];
            
            for(int i = 0; i < 4; i++){
                int mx = x + dx[i];
                int my = y + dy[i];
                
                if(mx < 0 || mx > maps.length - 1 || my < 0 || my > maps[0].length - 1) continue;
                if(visit[mx][my] == 0 && maps[mx][my] == 1){
                    visit[mx][my] = visit[x][y] +1;
                    next.add(new int[] {mx,my});
                }
            }
        }
    }
}