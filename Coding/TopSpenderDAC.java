import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopSpenderDAC {
    public static void main(String[] args) {
        List<Transaction> dataset = new ArrayList<>();

        // dataset
        dataset.add(new Transaction(1, 100));
        dataset.add(new Transaction(2, 150));
        dataset.add(new Transaction(3, 200));
        dataset.add(new Transaction(4, 450));
        dataset.add(new Transaction(5, 280));
        dataset.add(new Transaction(6, 370));
        dataset.add(new Transaction(7, 440));
        dataset.add(new Transaction(8, 70));
        dataset.add(new Transaction(9, 100));
        dataset.add(new Transaction(10, 90));
        dataset.add(new Transaction(11, 91));
        dataset.add(new Transaction(12, 60));
        dataset.add(new Transaction(13 , 700));
        dataset.add(new Transaction(14, 300));
        dataset.add(new Transaction(15, 900));
        dataset.add(new Transaction(16, 168));
        dataset.add(new Transaction(17, 546));
        dataset.add(new Transaction(18, 65));
        dataset.add(new Transaction(19, 20));
        dataset.add(new Transaction(20, 17));
        dataset.add(new Transaction(21, 80));
        dataset.add(new Transaction(22, 120));
        dataset.add(new Transaction(23 , 100));
        dataset.add(new Transaction(24, 450));
        dataset.add(new Transaction(25, 330));
        dataset.add(new Transaction(26, 78));
        dataset.add(new Transaction(27, 320));
        dataset.add(new Transaction(28,125));
        dataset.add(new Transaction(29, 100));
        dataset.add(new Transaction(30, 430));

        List<CustomerSpending> topSpenders = findTopSpenders(dataset);
        System.out.println("Top 10 Spenders:");
        for (CustomerSpending spender : topSpenders) {
            System.out.println("Customer ID: " + spender.getCustomerId() + ", Total Spending: " + spender.getTotalSpending());
        }
        
        System.out.println("\nTime taken : " + TimeToFind());
    }

    static List<CustomerSpending> findTopSpenders(List<Transaction> dataset) {
        if (dataset.size() == 1) {
            // Base case: Only one customer in the dataset
            List<CustomerSpending> topSpender = new ArrayList<>();
            topSpender.add(new CustomerSpending(dataset.get(0).getCustomerId(), dataset.get(0).getAmount()));
            return topSpender;
        }

        // Divide: Split the dataset into two equal halves
        int mid = dataset.size() / 2;
        List<Transaction> leftHalf = dataset.subList(0, mid);
        List<Transaction> rightHalf = dataset.subList(mid, dataset.size());

        // Conquer: Recursively find the top spenders in each half
        List<CustomerSpending> topSpendersLeft = findTopSpenders(leftHalf);
        List<CustomerSpending> topSpendersRight = findTopSpenders(rightHalf);

        // Combine: Merge the top spenders from each half
        List<CustomerSpending> combinedSpenders = mergeTopSpenders(topSpendersLeft, topSpendersRight);

        return combinedSpenders;
    }

    static List<CustomerSpending> mergeTopSpenders(List<CustomerSpending> spendersLeft, List<CustomerSpending> spendersRight) {
        Map<Integer, Integer> mergedSpenders = new HashMap<>();

        // Merge the spending information for each customer from both halves
        for (CustomerSpending spender : spendersLeft) {
            mergedSpenders.put(spender.getCustomerId(), spender.getTotalSpending() + mergedSpenders.getOrDefault(spender.getCustomerId(), 0));
        }

        for (CustomerSpending spender : spendersRight) {
            mergedSpenders.put(spender.getCustomerId(), spender.getTotalSpending() + mergedSpenders.getOrDefault(spender.getCustomerId(), 0));
        }

        // Sort the merged spenders by their total spending in descending order
        List<CustomerSpending> sortedSpenders = new ArrayList<>(mergedSpenders.size());
        mergedSpenders.forEach((customerId, totalSpending) -> sortedSpenders.add(new CustomerSpending(customerId, totalSpending)));
        sortedSpenders.sort(Comparator.comparingInt(CustomerSpending::getTotalSpending).reversed());

        // Return the top spenders
        return sortedSpenders.subList(0, Math.min(10, sortedSpenders.size()));  // Return the top 10 spenders
    }
    
    //Method to find the speed of algorithm
    public static long TimeToFind(){
		long start = System.nanoTime();
        long end = System.nanoTime();
        long duration =  end - start;
        return duration;
    }
}

class Transaction {
    private int customerId;
    private int amount;

    public Transaction(int customerId, int amount) {
        this.customerId = customerId;
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getAmount() {
        return amount;
    }
}

class CustomerSpending {
    private int customerId;
    private int totalSpending;

    public CustomerSpending(int customerId, int totalSpending) {
        this.customerId = customerId;
        this.totalSpending = totalSpending;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getTotalSpending() {
        return totalSpending;
    }
}
