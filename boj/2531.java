import java.io.*;
import java.util.*;

public class 2531 {
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