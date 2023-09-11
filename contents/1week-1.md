# 잃어버린 괄호
## baekjoon 1541

문제
---
<img src="https://github.com/ksssmm/codingtest/blob/master/contents/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202023-09-11%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%206.24.43.png">

문제에서 식은 '0~9, +, -' 만으로 이루어져 있다고 했고


식의 값을 최소로 만드는 프로그램을 작성해야 하므로


'-'에 중점을 두어 생각해서 문제를 풀었다.


최소가 되어야 하므로 식이 어떻든 간에 가장 큰수를 빼는 형태가 나와야 최소가 된다고 생각했고,


입력 받은 문자열을 '-'을 기준으로 split해서 배열에 저장하였다.


split한 문자열을 한 번더 '+'를 기준으로 split 해서 '+'연산을 우선으로 수행하는 식으로 문제를 풀었다


```
    import java.util.*;

    public class Main{
        public static void main(String[] args){
            int answer = Integer.MAX_VALUE;
            Scanner sc = new Scanner(System.in);
            String[] sub = sc.nextLine().split("-"); // '-' 기준으로 문자열 split
        
        
            for(int i = 0; i < sub.length; i++){
                int temp = 0;
            
                String[] add = sub[i].split("\\+"); // '+' 기준으로 문자열 split
            
                for(int j =0; j < add.length; j++){
                    temp += Integer.parseInt(add[j]);
                }
                if(answer == Integer.MAX_VALUE){ //처음 값이면 연산없이 temp값
                    answer = temp; 
                }else{
                    answer -= temp;
                }
            }
            System.out.println(answer);
        }
    }
```

