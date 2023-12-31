# 통계학

## baekjoon 2108

## 문제

<img src="./images/statistics-1.png" width="70%">

이 문제는 N개의 수가 주어지면 평균값, 정렬한뒤에 중앙값, 최빈값, 범위 - 최댓값과 최솟값의 차이 를 구하는 문제이다.

처음 봤을때는 너무 쉽다고 생각했는데, 최빈값의 조건이 좀 까다로웠다.

최빈값이 여러 개 존재하면 두 번째로 작은 값을 출력해야 했다.

## 풀이
----

최빈값은 기본적으로 HashMap을 이용해서 풀었다.

최빈값이 여러개일 경우를 대비해서 `maxFrequency`에 최빈값의 횟수를 저장하고,

`maxFrequency`와 같은 횟수를 가진 즉 다른 최빈값을 `ArrayList`에 저장한뒤에 정렬하여 

2번째로 작은 수에 쉽게 접근하도록 문제를 풀었다.






```
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 2108 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer> numbers = new ArrayList<>();
    Map<Integer, Integer> frequency = new HashMap<>();

    int sum = 0;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      numbers.add(num);
      sum += num;
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }

    int mean = (int) Math.round((double) sum / N);

    Collections.sort(numbers);
    int median = numbers.get(N / 2);

    int maxFrequency = Collections.max(frequency.values());

    ArrayList<Integer> modes = new ArrayList<>();
    for (int key : frequency.keySet()) {
      if (frequency.get(key) == maxFrequency) {
        modes.add(key);
      }
    }
    Collections.sort(modes);
    int mode;
    if (modes.size() > 1) {
      mode = modes.get(1);
    } else {
      mode = modes.get(0);
    }

    int range = numbers.get(N - 1) - numbers.get(0);

    System.out.println(mean);
    System.out.println(median);
    System.out.println(mode);
    System.out.println(range);
  }
}


```