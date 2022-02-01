package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class intersectionOfArrays {
    public static void main(String[] args) {
        int[] array1 = new int[]{1,2,5,4,7,9,3};
        int[] array2 = new int[]{1,9,3,10,15};
        System.out.println(getIntersection(array1,array2));
    }

    public static ArrayList<Integer> getIntersection(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int element : array1) {
            map.put(element, false);
        }
        for (int element : array2) {
            if (map.containsKey(element))
                map.put(element, true);
        }

        Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Boolean> entry : entries) {
            if (entry.getValue())
                result.add(entry.getKey());
        }
        return result;
    }
}
