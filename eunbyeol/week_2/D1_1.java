import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException {
        Comparator<Integer> comparator = Comparator.reverseOrder();
        Map<Integer, Integer> sortedMap = new TreeMap<>(comparator);

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int W = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        for (int i=0; i<N; i++) {
            String[] inputs = buffer.readLine().split(" ");
            int Mi = Integer.parseInt(inputs[0]);
            int Pi = Integer.parseInt(inputs[1]);
            sortedMap.put(Pi, sortedMap.getOrDefault(Pi, 0) + Mi);
        }

        long totalPrice = 0;

        for (Integer key : sortedMap.keySet()) {
            if (W < sortedMap.get(key)) {
                totalPrice += key*W;
                break;
            }
            W -= sortedMap.get(key);
            totalPrice += key*sortedMap.get(key);
        }
        System.out.println(totalPrice);
    }
}

/*
1. Map 매핑 - key: Pi, value: Mi
2. Map key를 기준으로 내림차순 정렬
3. w >= value까지 추가
4. price += value*key
*/