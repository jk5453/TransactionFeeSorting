import java.util.*;

class Asset {
    String name;
    double returnRate;
    double volatility;

    Asset(String name, double r, double v) {
        this.name = name;
        this.returnRate = r;
        this.volatility = v;
    }
}

public class Problem4 {

    static void mergeSort(List<Asset> list) {
        if (list.size() <= 1) return;

        int mid = list.size() / 2;
        List<Asset> left = new ArrayList<>(list.subList(0, mid));
        List<Asset> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left);
        mergeSort(right);

        list.clear();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).returnRate <= right.get(j).returnRate)
                list.add(left.get(i++));
            else
                list.add(right.get(j++));
        }

        while (i < left.size()) list.add(left.get(i++));
        while (j < right.size()) list.add(right.get(j++));
    }

    static void quickSort(List<Asset> list, int l, int r) {
        if (l < r) {
            int p = partition(list, l, r);
            quickSort(list, l, p - 1);
            quickSort(list, p + 1, r);
        }
    }

    static int partition(List<Asset> list, int l, int r) {
        Asset pivot = list.get(r);
        int i = l - 1;

        for (int j = l; j < r; j++) {
            if (list.get(j).returnRate > pivot.returnRate ||
                    (list.get(j).returnRate == pivot.returnRate &&
                            list.get(j).volatility < pivot.volatility)) {
                i++;
                Collections.swap(list, i, j);
            }
        }

        Collections.swap(list, i + 1, r);
        return i + 1;
    }

    public static void main(String[] args) {
        List<Asset> list = new ArrayList<>();
        list.add(new Asset("AAPL", 12, 5));
        list.add(new Asset("TSLA", 8, 7));
        list.add(new Asset("GOOG", 15, 4));

        mergeSort(list);
        for (Asset a : list)
            System.out.println(a.name + ":" + a.returnRate);

        quickSort(list, 0, list.size() - 1);
        for (Asset a : list)
            System.out.println(a.name + ":" + a.returnRate);
    }
}