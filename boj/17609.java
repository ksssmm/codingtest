import java.util.*;

public class 17609{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i =0; i < t; i++){
            String str = sc.next();
            isPalind(str);
        }
        
        
    }
    
    static void isPalind(String str){
    int l = 0;
    int r = str.length() - 1;
    
    while(l < r){
        if(str.charAt(l) != str.charAt(r)){
            if(isPalindrome(str, l+1, r)) {
                System.out.println(1);
                return;
            }
            if(isPalindrome(str, l, r-1)) {
                System.out.println(1);
                return;
            }
            
            System.out.println(2);
            return;
        }
        l++;
        r--;
    }
    System.out.println(0);
}

static boolean isPalindrome(String str, int l, int r) {
    while(l < r) {
        if(str.charAt(l) != str.charAt(r)) {
            return false;
        }
        l++;
        r--;
    }
    return true;
}
}