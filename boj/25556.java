import java.util.*;

public class 25556{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        
        Stack<Integer>[] stacks = new Stack[4];
        
        for(int i = 0; i < 4; i++){
            stacks[i] = new Stack<>();
            stacks[i].push(0);
        }
        for(int i = 0 ; i < n; i++){
            boolean check = false;
                for(int j = 0; j < 4; j++){
                    if(stacks[j].peek() < num[i]){
                        stacks[j].push(num[i]);
                        check = true;
                        break;
                    }
                }
            if(!check){
                System.out.println("NO");
                return;
            }
            
        }
        System.out.println("YES");
        
        
        
    }
}