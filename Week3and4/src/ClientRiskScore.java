import java.util.*;

class Client {
    String name;
    int riskScore;
    int accountBalance;

    Client(String name, int riskScore, int accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }
}

public class ClientRiskScore {

    static void bubbleSort(Client[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].riskScore > arr[j + 1].riskScore) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && (arr[j].riskScore < key.riskScore ||
                    (arr[j].riskScore == key.riskScore &&
                            arr[j].accountBalance < key.accountBalance))) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("C", 80, 1000),
                new Client("A", 20, 2000),
                new Client("B", 50, 1500)
        };

        System.out.println("Bubble Sort (Ascending Risk):");
        bubbleSort(clients);
        for (Client c : clients)
            System.out.println(c.name + ":" + c.riskScore);

        System.out.println("\nInsertion Sort (Descending Risk):");
        insertionSort(clients);
        for (Client c : clients)
            System.out.println(c.name + ":" + c.riskScore);

        System.out.println("\nTop Risk Clients:");
        for (int i = 0; i < Math.min(10, clients.length); i++)
            System.out.println(clients[i].name + "(" + clients[i].riskScore + ")");
    }
}


