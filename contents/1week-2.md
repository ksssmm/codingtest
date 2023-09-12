# 생태학
## baekjoon 4358

문제
---
<img src="https://github.com/ksssmm/codingtest/blob/master/contents/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202023-09-11%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%206.24.43.png">

이 문제는 나무의 종을 입력 받으면 사전순으로 정렬하여 

그 종이 차지하는 비율을 백분율로 소수점 4번째 자리까지 반올림해 

아래와 같이 출력하라고 하였다.

출력을 보자 HashMap이 바로 떠올라서 HashMap을 사용 하여 풀었다.

스터디를 통해 배운 getOrDefault 메소드를 사용하여 


HashMap에 key값인 나무 종이 있으면 get을 통해 얻은 value에 +1을,

나무 종이 없으면 Default를 통해 0으로 설정 후 +1 하는 방식을 통해 데이터를 저장 하였다


```
import java.io.*;
import java.util.*;

public class 4358 {
    static HashMap<String, Integer> trees;
    static int allCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        trees = new HashMap<String, Integer>();
        String input = br.readLine();
        while(true){
            trees.put(input,trees.getOrDefault(input,0)+1);
            allCount++;
            input = br.readLine();
            if(input == null || input.length() ==0) break;
        }
        Object[] keys = trees.keySet().toArray();
        Arrays.sort(keys);

        StringBuilder sb = new StringBuilder();
        for(Object key : keys){
            int point = trees.get(key);
            double percent = ((double)point / allCount) * 100;
            sb.append(key + " " + String.format("%.4f", percent)+ "\n");
        }
        System.out.println(sb.toString());

    }
}
```
