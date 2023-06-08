import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopSpenderDP {
    public static void main(String[] args) {
        List<Transactionn> dataset = new ArrayList<>();

        //dataset
        dataset.add(new Transactionn(1, 100));
        dataset.add(new Transactionn(2, 150));
        dataset.add(new Transactionn(3, 200));
        dataset.add(new Transactionn(4, 450));
        dataset.add(new Transactionn(5, 280));
        dataset.add(new Transactionn(6, 370));
        dataset.add(new Transactionn(7, 440));
        dataset.add(new Transactionn(8, 70));
        dataset.add(new Transactionn(9, 100));
        dataset.add(new Transactionn(10, 90));
        dataset.add(new Transactionn(11, 91));
        dataset.add(new Transactionn(12, 60));
        dataset.add(new Transactionn(13 , 700));
        dataset.add(new Transactionn(14, 300));
        dataset.add(new Transactionn(15, 900));
        dataset.add(new Transactionn(16, 168));
        dataset.add(new Transactionn(17, 546));
        dataset.add(new Transactionn(18, 65));
        dataset.add(new Transactionn(19, 20));
        dataset.add(new Transactionn(20, 17));
        dataset.add(new Transactionn(21, 80));
        dataset.add(new Transactionn(22, 120));
        dataset.add(new Transactionn(23 , 100));
        dataset.add(new Transactionn(24, 450));
        dataset.add(new Transactionn(25, 330));
        dataset.add(new Transactionn(26, 78));
        dataset.add(new Transactionn(27, 320));
        dataset.add(new Transactionn(28,125));
        dataset.add(new Transactionn(29, 100));
        dataset.add(new Transactionn(30, 430));

        List<CustomerSpendingg> topSpenders = findTopSpenders(dataset);
        System.out.println("Top 10 Spenders:");
        for (CustomerSpendingg spender : topSpenders) {
            System.out.println("Customer ID: " + spender.getCustomerId() + ", Total Spending: " + spender.getTotalSpending());
        }
        
        System.out.println("\nTime taken : " + TimeToFind());
    }

    static List<CustomerSpendingg> findTopSpenders(List<Transactionn> dataset) {
        // Create a map to store the total spending for each customer
        Map<Integer, Integer> totalSpendingMap = new HashMap<>();

        // Iterate over the dataset and update the total spending for each customer
        for (Transactionn transaction : dataset) {
            int customerId = transaction.getCustomerId();
            int amount = transaction.getAmount();

            // Update the total spending for the current customer
            int currentTotalSpending = totalSpendingMap.getOrDefault(customerId, 0);
            totalSpendingMap.put(customerId, currentTotalSpending + amount);
        }

        // Convert the total spending map to a list of CustomerSpending objects
        List<CustomerSpendingg> customerSpendings = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : totalSpendingMap.entrySet()) {
            int customerId = entry.getKey();
            int totalSpending = entry.getValue();
            customerSpendings.add(new CustomerSpendingg(customerId, totalSpending));
        }

        // Sort the customer spendings in descending order of total spending
        Collections.sort(customerSpendings, Comparator.comparingInt(CustomerSpendingg::getTotalSpending).reversed());

        // Return the top spenders
        return customerSpendings.subList(0, Math.min(10, customerSpendings.size()));  // Return the top 10 spenders
    }
    
    //Method to find the speed of algorithm
    public static long TimeToFind(){
		long start = System.nanoTime();
        long end = System.nanoTime();
        long duration =  end - start;
        return duration;
    }
}

class Transactionn {
    private int customerId;
    private int amount;

    public Transactionn(int customerId, int amount) {
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

class CustomerSpendingg {
    private int customerId;
    private int totalSpending;

    public CustomerSpendingg(int customerId, int totalSpending) {
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
