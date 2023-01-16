import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class D5_2 {
    public int solution(int[] topping) {
        int answer = numberOfCuttingCake(topping);
        return answer;
    }

    public static int numberOfCuttingCake(int[] topping) {
        int result = 0;
        if (topping.length == 1) {
            return 0;
        }
        for (int i=1; i <topping.length; i++) {
            Integer[] arr1 = Arrays.stream(Arrays.copyOfRange(topping, 0, i)).boxed().toArray(Integer[]::new);
            Integer[] arr2 = Arrays.stream(Arrays.copyOfRange(topping, i, topping.length)).boxed().toArray(Integer[]::new);
            Set<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
            Set<Integer> set2 = new HashSet<>(Arrays.asList(arr2));
            if (set1.size() == set2.size()) {
                result++;
            }
        }
        return result;
    }
}