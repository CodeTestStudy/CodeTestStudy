import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Map<Integer, Integer> scoreMap = new LinkedHashMap<>();
        Map<Integer, Integer> totalMap = new LinkedHashMap<>();
        int[] ranks;

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());

        for (int i=0; i<3; i++) {
            String[] input = buffer.readLine().split(" ");

            for (int j=0; j<input.length; j++) {
                scoreMap.put(j, Integer.parseInt(input[j]));
                totalMap.put(j, totalMap.getOrDefault(j, 0) + Integer.parseInt(input[j]));
            }

            ranks = setRank(N, scoreMap);
            printRank(ranks);
        }

        ranks = setRank(N, totalMap);
        printRank(ranks);
    }

    public static int[] setRank(int N, Map<Integer, Integer> map) {
        int[] ranks = new int[N];
        int rank = 1;
        int preKey = -1;
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        System.out.println(keySet);

        for (Integer key : keySet) {
            if (preKey != -1 && map.get(preKey).equals(map.get(key))) {
                ranks[key] = ranks[preKey];
            }
            else {
                ranks[key] = rank;
            }
            preKey = key;
            rank++;
        }
        return ranks;
    }

    public static void printRank(int[] ranks) {
        String[] rankStr = Arrays.stream(ranks)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        String printStr = String.join(" ", rankStr);
        System.out.println(printStr);
    }
}
/*
방법1: 대회 정보를 배열에 저장하여 인데스마다 돌면서 자신보다 점수가 큰 사람 개수를 찾는다
방법2: map에 내림차순 정렬. 인덱스+1이 원소. 단, 앞 원소와 같으면 해당 Rank의 순위를 복붙.
*/