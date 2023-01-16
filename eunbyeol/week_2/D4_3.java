import java.util.*;

class D4_3 {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Integer[] arrA = removeDuplication(arrayA);
        Integer[] arrB = removeDuplication(arrayB);

        int gcdA = findGcdOfArray(arrA);
        int gcdB = findGcdOfArray(arrB);

        if (gcdA > gcdB) {
            if (!isMultipleNumberOfArr(gcdA, arrB)){
                answer = gcdA;
            }
            else if (!isMultipleNumberOfArr(gcdB, arrA)){
                answer = gcdB;
            }
        }
        else {
            if (!isMultipleNumberOfArr(gcdB, arrA)){
                answer = gcdB;
            }
            else if (!isMultipleNumberOfArr(gcdA, arrB)){
                answer = gcdA;
            }
        }
        return answer;
    }

    public boolean isMultipleNumberOfArr(int n, Integer[] arr) {
        for (Integer a : arr) {
            if (a % n == 0) {
                return true;
            }
        }
        return false;
    }

    public Integer[] removeDuplication(int[] arr) {
        Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        LinkedHashSet<Integer> setA = new LinkedHashSet<>(Arrays.asList(integerArray));
        return setA.toArray(new Integer[]{});
    }

    public int findGcdOfArray(Integer[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int gcd = GCD(arr[0], arr[1]);
        for (int i=2; i<arr.length; i++) {
            gcd = GCD(gcd, arr[i]);
        }
        return gcd;
    }

    public int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        else {
            return GCD(b, a%b);
        }
    }
}
/*
0. 문자열 중복제거
1. arrayA GCD
2. arrayB GCD
3. 1) if (arrayB % aGCD != 0)
    2) if (arrayA % bGCD != 0)
    else -> 0
 */