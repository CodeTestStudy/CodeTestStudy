import java.util.*;
import java.io.*;

public class Main10
{
    public static void main(String args[]) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String message = buffer.readLine();
        String keyStr = buffer.readLine();

        String[][] key = createKey(keyStr);

        List<String> messageList = splitMessage(message);

        String result = translateMessage(messageList, key);
        System.out.println(result);
    }

    public static String translateMessage(List<String> list, String[][] key) {
        String result = "";

        for (String str: list) {
            String[] elem = str.split("");
            int[] indexList = findIndex(key, elem[0]);
            int i = indexList[0];
            int j = indexList[1];

            indexList = findIndex(key, elem[1]);
            int k = indexList[0];
            int l = indexList[1];

            if (i == k) {
                if (j+1 == 5) j=-1;
                if (l+1 == 5) l=-1;
                result += (key[i][j+1] + key[k][l+1]);
            }
            else if (j == l) {
                if (i+1 == 5) i=-1;
                if (k+1 == 5) k=-1;
                result += (key[i+1][j] + key[k+1][l]);
            }
            else {
                result += (key[i][l] + (key[k][j]));
            }
        }
        return result;
    }

    public static int[] findIndex(String[][] key, String elem) {
        int[] indexList = new int[2];
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (elem.equals(key[i][j])) {
                    indexList[0] = i;
                    indexList[1] = j;
                    return indexList;
                }
            }
        }
        return null;
    }

    public static List<String> splitMessage(String message) {
        String[] splitMessage = message.split("");
        List<String> result = new ArrayList<>();
        for (int i=0; i<splitMessage.length; i++) {
            if (i+1 == splitMessage.length) {
                result.add(splitMessage[i] + "X");
                break;
            }
            if (splitMessage[i].equals(splitMessage[i+1])) {
                String str = splitMessage[i] + "X";
                if (splitMessage[i].equals("X")) {
                    str = splitMessage[i] + "Q";
                }
                result.add(str);
                continue;
            }
            result.add(splitMessage[i] + splitMessage[i+1]);
            i++;
        }
        return result;
    }

    public static String[][] createKey(String keyStr) {
        String[] splitStr = keyStr.split("");
        List<String> strList = new ArrayList<>(Arrays.asList(splitStr));

        Set<String> keySet = new LinkedHashSet<>(strList);
        Set<String> alphabetSet = new LinkedHashSet<>(List.of(
                "A","B","C","D","E","F","G","H","I","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        alphabetSet.removeAll(keySet);

        String[][] key = new String[5][5];
        Iterator<String> keyIt = keySet.iterator();
        Iterator<String> alphaIt = alphabetSet.iterator();

        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (keyIt.hasNext()) {
                    key[i][j] = keyIt.next();
                }
                else {
                    key[i][j] = alphaIt.next();
                }
            }
        }
        return key;
    }
}

/*
1. key 표로 변환
    - 1. 문자열 전처리: 중복 없애기 Set(순서중요)
    - 2. 차집합 구하기
    - 3. key[i][j]에 매핑 - key 먼저, 차집합 나중에
2. 메시지 나누기
    - List<String> 나누기.
    - 중복 -> X추가 or Q추가
    - 마지막 한글자는 무조건 X

3. 메시지 변환
    - 인덱스 찾기(a[i][j], b[k][l]) : 반복문으로 탐색.
    - 1.같은 행에 존재하는 경우(i==k) : a[i][j+1], b[k][l+1]. 단, 마지막 인덱스인 경우 원소 =0
    - 2.같은 열에 존재하는경우(j==l) : a[i+1][j], b[k+1][j]. 단, 마지막 인덱스인 경우 원소 =0
    - 3.서로 다른 행, 열에 존재하는 경우(else) : a[i][l], b[k][j]
*/
