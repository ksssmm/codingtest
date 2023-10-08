import java.util.*;

public class 1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // 테스트 케이스 수

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();  // 문서의 수
            int m = sc.nextInt();  // 알고 싶은 문서의 현재 위치
            Queue<int[]> documents = new LinkedList<>();  // [문서의 위치, 중요도]
            Queue<Integer> importance = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                int imp = sc.nextInt();
                documents.offer(new int[]{j, imp});
                importance.offer(imp);
            }

            int printCount = 0; //몇 번째로 인쇄
            while (!documents.isEmpty()) {
                int[] current = documents.poll();
                if (current[1] == Collections.max(importance)) {  // 가장 중요도가 높은 문서가 현재 문서라면
                    printCount++;
                    importance.poll();
                    if (current[0] == m) {  // 알고 싶은 문서가 출력되었다면
                        System.out.println(printCount);
                        break;
                    }
                } else {
                    documents.offer(current);
                    importance.offer(importance.poll());
                }
            }
        }
    }
}