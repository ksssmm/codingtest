# 회문

## baekjoon 17609

## 문제

<img src="./images/palindrome-1.png" width="70%">

이 문제는 문자열이 회문인지를 판별하는 문제이다.


'abba' 'kayak' 'reviver' 와 같이 앞 뒤 방향으로 볼 때 같은 순서의 문자로 구성되어 있으면 그 문자열은 회문이다.

만약 회문은 아니지만 문자열중 문자 하나를 제거해서 회문을 만들 수 있으면 이를 유사 회문이라 부른다.

'summuus'는 5,6 번째의 'u'를 제거하면 회문으로 만들 수 있으므로 유사회문이다.

회문이면 0 유사회문이면 1 둘 다 아니면 2를 출력하는것이 문제이다.

### 풀이
---
문자열 `str`의 양 끝에서 시작하기 위해서 투 포인터 방식으로 문제를 풀었다.

```
int l = 0;
int r = str.length() - 1;
```

`while`문을 돌면서 각 포인터의 위치한 문자를 비교하여 같으면 포인터를 이동시켜서 다음 비교를 진행하고,

문자가 다르면 l과 r중에 하나만 움직인 뒤에 비교해서 회문인지를 검사했다.

문제에서는 유사회문은 하나의 문자를 제거했을때 회문을 만들 수 있으면 유사회문이라고 했기 때문에

회문검사는 최대 2번까지 진행했다.

```
static void isPalind(String str){
    int l = 0;
    int r = str.length() - 1;
    
    while(l < r){ 
        if(str.charAt(l) != str.charAt(r)){ // 다르면 유사 회문인지 검사
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
```


### 코드
---

```
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
```