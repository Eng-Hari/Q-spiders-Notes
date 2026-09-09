
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public record Grooming() {

    public static void main(String[] args) {
        reverse_words("Hello world");
        int[] arr1 = {1, 2, 2, 3, 4, 4, 4, 4, 5, 6, 6, 7};
        MAX_freq(arr1);
        mergeMap();
        MergeArray();
    }

    static void reverse_words(String str) {

        String arr[] = str.split(" ");

        String reversed = "";
        for (String s : arr) {
            reversed += rev(s) + " ";
        }
        System.out.println(reversed);
    }

    static String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // remove duplicate in string
    //max frequency of integer
    static void MAX_freq(int[] arr) {
        int large = 0;
        int largeCount = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count > largeCount) {
                largeCount = count;
                large = arr[i];
            }
        }
        System.out.println(large + " : " + largeCount);
    }

    // Merge two maps
    static void mergeMap() {

        Map<String, Integer> m1 = new HashMap<>();
        m1.put("A", 10);
        m1.put("B", 20);
        m1.put("D", 35);

        Map<String, Integer> m2 = new HashMap<>();
        m2.put("A", 5);
        m2.put("B", 15);
        m2.put("C", 25);

        // Handle null maps
        if (m1 == null && m2 == null) {
            System.out.println("Both maps are null");
            return;
        }

        if (m1 == null) {
            System.out.println(m2);
            return;
        }

        if (m2 == null) {
            System.out.println(m1);
            return;
        }

        // Merge m1 into m2
        for (String key : m1.keySet()) {

            if (m2.containsKey(key)) {

                Integer value1 = m1.get(key);
                Integer value2 = m2.get(key);

                // Handle null values
                if (value1 == null) {
                    value1 = 0;
                }

                if (value2 == null) {
                    value2 = 0;
                }

                m2.put(key, value1 + value2);

            } else {
                // Key exists only in m1
                m2.put(key, m1.get(key));
            }
        }

        System.out.println(m2);
    }

    //Merge two array
    static void MergeArray() {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {3, 4, 6, 7, 8, 9};
        int k = 0;
        int[] res = new int[Math.max(arr1.length, arr2.length)];
        int last = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    if (last != arr1[i]) {
                        res[k++] = arr1[i];
                        last = arr1[i];
                    }

                }
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        // merge_using_set
        int l = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            if (set.contains(num)) {
                res[l++] = num;
                set.remove(num);
            }
        }

        for (int i = 0; i < l; i++) {
            System.out.print(res[i] + " ");
        }

    }

}
