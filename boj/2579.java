import java.util.*;

public class 2579 {
  public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] stair = new int[num + 1];

        for(int i = 1; i <= num; i++){
            stair[i]=sc.nextInt();
        }
        
        int[] point = new int[num + 1];
        point[1] = stair[1];
        
        for(int n = 2; n <= num; n++){
            if(n==2) point[2] = stair[2] + stair[1];
            else if(n==3) point[3] = stair[3] + Math.max(stair[1], stair[2]);
            else point[n] = stair[n] + Math.max(point[n-3] +stair[n-1], point[n-2]);
            
        }
        System.out.println(point[num]);
    }
  
}
