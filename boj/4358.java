import java.io.*;
import java.util.*;

public class Main {
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