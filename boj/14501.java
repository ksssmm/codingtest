import java.io.*;
import java.util.*;

public class 14501{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] T = new int[n+1];
        int[] P = new int[n+1];
        int[] dp = new int[n+2];
        
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        for(int j = n; j >0; j--){
            int next = j + T[j];
            
            if(next > n + 1){
                dp[j] = dp[j+1];
            } else {
                dp[j] = Math.max(dp[j + 1], P[j] + dp[next]);
            }
        }
        System.out.println(dp[1]);
    }
}