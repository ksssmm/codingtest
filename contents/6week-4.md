# 제곱수의 합

## baekjoon 1699

## 문제

<img src="./images/binomal-1.png" width="70%">


### 풀이
---

항을 최소로 해서 제곱수들의 합으로 표현해야 하므로,

어떤 수던간에 자기 보다 작고 가장 근처에 있는 제곱수가 일단 포함되야한다.

예를 들면 23을 항을 최소로하는 제곱수들의 합은 

4<sup>2</sup> < 23 < 5<sup>2</sup> 이므로

23 = 4<sup>2</sup> + 7

7 = 2<sup>2</sup> + 3

3 = 1<sup>2</sup> + 1<sup>2</sup> + 1<sup>2</sup>

이런식으로 하나의 수가 주어지면 근처의 제곱수로 한번 표현하고 

나머지 수도 근처의 제곱수로 표현 하는게 항을 최소화 하는 방법이다.

따라서 dp의 방법으로 점화식을 `dp[i] = dp[i - (j * j)] + 1;` 선언하고 

for 문을 통해서 원하는 수까지 메모이제이션했다.


```
int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        if (dp[i] > dp[i - (j * j)] + 1) {
          dp[i] = dp[i - (j * j)] + 1;
        }
      }
    }
```

`dp[i] = i;`와 같이 표현하는 이유는 제곱수의 합으로 표현할 때 최대로 항을 갖는 방법은

1<sup>2</sup>의 합으로 표현하는 것이기 때문에 `dp[i] = i;`라 했다.





```
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        if (dp[i] > dp[i - (j * j)] + 1) {
          dp[i] = dp[i - (j * j)] + 1;
        }
      }
    }
    System.out.println(dp[n]);

  }
}
```