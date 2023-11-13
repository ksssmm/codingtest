# 별 찍기 - 10

## baekjoon 2447

## 문제

<img src="./images/printStar-1.png" width="70%">

이 문제는 N이 3의 거듭제곱으로 주어 질 때, 일정한 패턴으로 채워진 N x N 크기의 정사각형을 출력하는 문제이다.



가장 작은 패턴은 3 x 3 크기의 정사각형에 가운데 부분에 공백을 두고 나머지는 *로 채운 형태이다.

그 다음 크기의 패턴은 9 x 9 크기의 정사각형에 마찬가지로 가운데 부분에 공백을 두고 나머지는 그 전 패턴으로 채운 형태이다.

따라서 2차원 배열로 생각해보면 3 x 3 크기의 패턴에는 (1,1)에 공백이 있으며,

<img src="./images/printStar-2.png" width="10%">

9 x 9 크기의 패턴에서는 기본적으로 가운데 공백의 인덱스는 다음과 같다.



(3,3) (3,4) (3,5)

(4,3) (4,4) (4,5)

(5,3) (5,4) (5,5)




<img src="./images/printStar-3.png" width="20%">




여기서 역으로 생각해보면, 전 크기의 패턴이 8개가 모이고 가운데가 공백인 패턴이 다음 패턴이다.



따라서 해당 크기의 패턴에서 가운데 부분만 특정 하면 그 전 패턴이 모인 3 x 3 크기의 패턴에서 (1,1)만 공백이다.


```
static void printStar(int i, int j, int n){
        if((i/n) % 3 == 1 && (j/n) % 3 ==1){
            sb.append(' ');
        } else {
            if(n == 1) sb.append('*');
            else printStar(i, j, n/3);
        }
    }
```

예를 들어 n = 9 인 4행 4열에 들어오는 문자는 `printStar(4,4,9)`를 통해 결정된다.

처음 조건문에서는 결과 값이 0, 0 이므로 만족하지 않고,

n도 9이므로 만족하지 않아서 `printStar(4,4,3)`을 호출한다.

그러면 처음 조건문을 만족하므로 9 x 9 크기의 패턴 (4,4)에는 공백이 된다.






<img src="./images/printStar-4.png" width="25%">








```
import java.util.*;

public class 2447{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j< n; j++){
                printStar(i,j,n);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void printStar(int i, int j, int n){
        if((i/n) % 3 == 1 && (j/n) % 3 ==1){
            sb.append(' ');
        } else {
            if(n == 1) sb.append('*');
            else printStar(i, j, n/3);
        }
    }
}

```