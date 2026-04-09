import java.util.*;

class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }
}

public class TransactionFeeSorting {

    static void bubbleSort(List<Transaction> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void insertionSort(List<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && (list.get(j).fee > key.fee ||
                    (list.get(j).fee == key.fee &&
                            list.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction("id1", 10.5, "10:00"));
        transactions.add(new Transaction("id2", 25.0, "09:30"));
        transactions.add(new Transaction("id3", 5.0, "10:15"));

        System.out.println("Bubble Sort (by fee):");
        bubbleSort(transactions);
        for (Transaction t : transactions)
            System.out.println(t.id + ":" + t.fee);

        System.out.println("\nInsertion Sort (fee + timestamp):");
        insertionSort(transactions);
        for (Transaction t : transactions)
            System.out.println(t.id + ":" + t.fee + "@" + t.timestamp);

        System.out.println("\nHigh-fee outliers (>50):");
        boolean found = false;
        for (Transaction t : transactions) {
            if (t.fee > 50) {
                System.out.println(t.id);
                found = true;
            }
        }
        if (!found) System.out.println("None");
    }
}



