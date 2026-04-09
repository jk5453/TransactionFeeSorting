import java.util.*;

public class RiskThresholdLookup {

    static boolean linearSearch(int[] arr, int target) {
        int comparisons = 0;
        for (int x : arr) {
            comparisons++;
            if (x == target) {
                System.out.println("Linear Found Comparisons: " + comparisons);
                return true;
            }
        }
        System.out.println("Linear Not Found Comparisons: " + comparisons);
        return false;
    }

    static int floor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int floor = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Comparisons: " + comparisons);
                return arr[mid];
            }
            if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Comparisons: " + comparisons);
        return floor;
    }

    static int ceiling(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ceil = -1;
        int comparisons = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            comparisons++;

            if (arr[mid] == target) {
                System.out.println("Comparisons: " + comparisons);
                return arr[mid];
            }
            if (arr[mid] > target) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Comparisons: " + comparisons);
        return ceil;
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        linearSearch(risks, 30);

        System.out.println("Floor: " + floor(risks, 30));
        System.out.println("Ceiling: " + ceiling(risks, 30));
    }
}