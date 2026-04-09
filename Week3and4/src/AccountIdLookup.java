import java.util.*;

public class AccountIdLookup {

    static int linearFirst(String[] arr, String target) {
        int comparisons = 0;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Index: " + i + " Comparisons: " + comparisons);
                return i;
            }
        }
        return -1;
    }

    static int linearLast(String[] arr, String target) {
        int comparisons = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                index = i;
            }
        }
        System.out.println("Linear Last Index: " + index + " Comparisons: " + comparisons);
        return index;
    }

    static int binarySearch(String[] arr, String target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid].equals(target)) {
                System.out.println("Binary Found Index: " + mid + " Comparisons: " + comparisons);
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr)
            if (s.equals(target)) count++;
        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        Arrays.sort(logs);

        System.out.println("Sorted: " + Arrays.toString(logs));

        binarySearch(logs, "accB");
        System.out.println("Count: " + countOccurrences(logs, "accB"));
    }
}