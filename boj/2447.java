import java.util.*;

public class 2447{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                isCenter(i,j,n);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void isCenter(int i, int j, int n){
        if((i/n) % 3 == 1 && (j/n) % 3 ==1){
            sb.append(' ');
        } else {
            if(n == 1) sb.append('*');
            else isCenter(i, j, n/3);
        }
    }
}