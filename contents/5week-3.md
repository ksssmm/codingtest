# 회전 초밥

## baekjoon 2531

## 문제

<img src="./images/sum-1.png" width="70%">



### 풀이
---

연속해서 k개의 초밥을 먹고 먹은 종류의 초밥을 카운트 해주는 방식으로 풀었다.


l은 k개의 초밥을 먹을때 처음 접시
r은 마지막 접시로 두고 

l과 r을 하나씩 움직여서 벨트에 놓여진 초밥들을 연속해서 k개로 먹는 경우의 수를 모두 조사해 최대값을 구했다.


벨트에 올려진 초밥이 다음과 같고 4개의 초밥을 연속으로 먹는 경우에 `arr`은 다음과 같다.

7(l)|9|7|30(r)|2|7|9|25
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|

|7|9|30|cnt
|:-:|:-:|:-:|:-:|
2개|1개|1개|3종류|



7|9(l)|7|30|2(r)|7|9|25
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|

2|7|9|30|cnt
|:-:|:-:|:-:|:-:|:-:|
|1개|1개|1개|1개|4종류



7|9|7(l)|30|2|7(r)|9|25
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|

2|7|30|cnt
|:-:|:-:|:-:|:-:|
|1개|2개|1개|3종류


l과 r을 오른쪽으로 하나씩 이동시키면서 초밥의 개수와 가짓수를 카운트 해주었다. 

처음 경우의수를 검사해서 `ans`에 먹은 종류의 수를 저장하고
```
for(int i=0; i<k; ++i) {
			++eat[arr[r]]; //벨트위에 있는 r번째 초밥의 번호를 먹은 것으로 처리
			if(eat[arr[r]] == 1) {
				++cnt;
			}
			++r;
		}
		ans = cnt;
```


l과 r을 이동시킬때마다 eat에 저장된 해당 번호의 초밥을 먹은 개수를 검사해서 

그 값이 0이면 먹은 초밥 종류의 개수(cnt)를 증가시키고

0이 아니면 cnt를 그대로 두는 방식으로 풀었다.

만약 먹은 초밥들의 번호와 쿠폰 번호가 일치 하지 않으면 

cnt를 +1 해서 ans와 비교해 최대값을 구했다.



```
while(l != n) {
			--eat[arr[l]];
			if(eat[arr[l]] == 0) {
				--cnt;
			}
			++l;
			
			++eat[arr[r]];
			if(eat[arr[r]] == 1) {
				++cnt;
			}
			++r;
			if(r == n) {
				r = 0;
			}
			if(eat[c] == 0) {
				ans = Math.max(ans, cnt + 1);
			} else {
				ans = Math.max(ans, cnt);
			}
		}
```


### 코드
---
```
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); //초밥 개수
		int d = Integer.parseInt(st.nextToken()); //초밥 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시수
		int c = Integer.parseInt(st.nextToken()); //쿠폰 번호

		int ans = 0;
		int l = 0;
		int r = 0;
		int cnt = 0;
		int[] arr = new int[n];
		int[] eat = new int[d+1];
		
		for(int i=0; i<n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<k; ++i) {
			++eat[arr[r]];
			if(eat[arr[r]] == 1) {
				++cnt;
			}
			++r;
		}
		ans = cnt;
		
		while(l != n) {
			--eat[arr[l]];
			if(eat[arr[l]] == 0) {
				--cnt;
			}
			++l;
			
			++eat[arr[r]];
			if(eat[arr[r]] == 1) {
				++cnt;
			}
			++r;
			if(r == n) {
				r = 0;
			}
			if(eat[c] == 0) {
				ans = Math.max(ans, cnt + 1);
			} else {
				ans = Math.max(ans, cnt);
			}
		}
	    System.out.println(ans);
	
	}
}
```