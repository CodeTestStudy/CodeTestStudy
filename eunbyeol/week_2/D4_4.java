import java.util.LinkedList;
import java.util.List;

class D4_4 {
    public double[] solution(int k, int[][] ranges) {
        List<List<Integer>> seq = getCollatzSeq(k);
        List<Double> vol = getVolOfSeq(seq);
        double[] answer = getAnswer(seq, vol, ranges);
//        System.out.println(seq);
//        System.out.println(vol);
        return answer;
    }

    public static double[] getAnswer(List<List<Integer>> seq, List<Double> vol, int[][] ranges) {
        double[] answer = new double[ranges.length];
        for (int i=0; i<ranges.length; i++) {
            int a = ranges[i][0];
            int b = seq.size()-1 + ranges[i][1];

            if (a > seq.size()-1 || b < 0 || a > b) {
                answer[i] = -1;
                continue;
            }
            double sum = 0;
            for (int k=a; k<b; k++) {
                sum += vol.get(k);
            }
            answer[i] = sum;
        }
        return answer;
    }

    public static List<Double> getVolOfSeq(List<List<Integer>> seq) {
        List<Double> vol = new LinkedList<>();
        int y1 = seq.get(0).get(1);
        for (List<Integer> s : seq) {
            if (seq.get(0).equals(s)) {
                continue;
            }
            int y2 = s.get(1);
            double v = Math.max(y1, y2) - Math.abs(y1-y2) / 2.0;
            vol.add(v);
            y1 = y2;
        }
        return vol;
    }

    public static List<List<Integer>> getCollatzSeq(int k) {
        List<List<Integer>> seq = new LinkedList<>();
        int x = 0;
        int y = k;
        while (true) {
            seq.add(List.of(x++, y));
            if (y == 1) break;
            if (y % 2 == 0) {
                y /= 2;
            }
            else {
                y = k*3 + 1;
            }
        }
        return seq;
    }
}

/*
1. 우박수열 구하기
    - 조건1. k % 2 == 0 ? k/2
    - 조건2. k % 2 != 0 ? k*3+1
    - 1이 돨때까지 반복
    - 단계별 x, y 좌표 저장

2. 구간별 면적 구하기
    - 배열-1 개의 면적 생성 ; 0-4
    - a(x1,y1)-b(x2,y2) 구간 : y1,y2중 큰수 - ( |y1-y2| / 2)

3. 범위 별 총 면적 구하기
    1. 구간변환: [a = 0+x1, b = (우박수열 x크기-1) + x2]
    2. 총 구간 계산: a~(b-1)까지 구간 계산

4. 예외사항
    1. 시작점 > 끝점 -> -1
    2. 끝점 < 시작점 -> -1
    3. 끝점 < 시작점 -> -1


  (0, 5), (1, 16), (2, 8), (3, 4), (4, 2), (5, 1)
  10.5, 12, 6, 3, 1.5

  [33.0,31.5,0.0,-1.0]
 */