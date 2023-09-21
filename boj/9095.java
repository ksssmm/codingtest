import java.util.*;
public class 9095{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        
        int[] sum = new int[11];
            sum[1] = 1;
            sum[2] = 2;
            sum[3] = 4;
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            
            for(int j =4; j <= n; j++){
                sum[j] = sum[j-1]+sum[j-2]+sum[j-3];
            }
            System.out.println(sum[n]);
            
        }
    }
}