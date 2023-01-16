import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int[][] square = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = buffer.readLine().split("");
            for (int j = 0; j < N; j++) {
                square[i][j] = Integer.parseInt(input[j]);
            }
        }

        List<Integer> result = findBarNumber(N, square);
        result.sort(Comparator.naturalOrder());
        System.out.println(result.size());
        for (Integer cnt : result) {
            System.out.println(cnt);
        }
    }

    public static List<Integer> findBarNumber(int N, int[][] square) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (square[i][j] == 1) {
                    result.add(countBar(N, i, j, square));
                }
            }
        }
        return result;
    }

    public static int countBar(int N, int k, int l, int[][] square) {
        int cnt = 0;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(List.of(k, l));
        square[k][l] = 2; //visited
        cnt++;

        while (!q.isEmpty()) {
            List<Integer> v = q.poll();
            int i = v.get(0);
            int j = v.get(1);

            if (i-1 >= 0 && square[i-1][j] == 1) {//북
                q.add(List.of(i-1, j));
                square[i-1][j] = 2;
                cnt++;
            }
            if (j+1 < N && square[i][j+1] == 1) { //동
                q.add(List.of(i, j+1));
                square[i][j+1] = 2;
                cnt++;
            }
            if (i+1 < N && square[i+1][j] == 1) {//남
                q.add(List.of(i+1, j));
                square[i+1][j] = 2;
                cnt++;
            }
            if (j-1 >= 0 && square[i][j-1] == 1) { //서
                q.add(List.of(i, j-1));
                square[i][j-1] = 2;
                cnt++;
            }
        }
        return cnt;
    }
}
/*
1. N*N 순회하여 1을 찾음
    - 1. 그 지점부터 DFS, 방문한 곳을 2로 표시, cnt++
    - cnt 리스트 크기 = 총 블럭 개수
2. cnt result 오름차순 정렬
*/