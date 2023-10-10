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
