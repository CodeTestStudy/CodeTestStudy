import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = buffer.readLine().split(" ");
        List<Integer> list = new LinkedList<>();
        for (String str: inputs) {
            list.add(Integer.parseInt(str));
        }
        System.out.println(findResult(list));
    }

    public static String findResult (List<Integer> list) {
        String result;
        if (list.get(0) == 1) {
            result = "ascending";
        }
        else if (list.get(0) == 8) {
            result = "descending";
        }
        else {
            return "mixed";
        }

        for (int i=1; i<8; i++) {
            if (result.equals("ascending")) {
                if (list.get(i) != i+1) {
                    return "mixed";
                }
            }
            else if (result.equals("descending")) {
                if (list.get(i) != 8-i) {
                    return "mixed";
                }
            }
            else {
                return "mixed";
            }
        }
        return result;
    }
}

/*
1. 숫자 입력 받기
2. 순차적으로 돌면서
    - 1. 첫번째 원소가 1인 경우
        1씩 증가하지 않으면 mixed
        이외, ascending
    - 2. 첫번째 원소가 8인 경우
        1씩 감소하지 않으면 mixed
        이외, descending
    - 3. 둘다 아닌 경우 - mixed
*/
