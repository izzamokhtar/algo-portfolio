A. Divide and Conquer ALgorithm
Pseudocode:

This algorithm takes a given problem, here being a dataset and the need to find a top spender, the dataset is then divided into smaller subproblems.The subproblems are then evaluated independently and seen as a single individual problem. Finally, the final results are combined together to obtain the final solution, in this case being the top spender. This algorithm uses recursion implementation  to solve the problem.

The main function initialises the dataset of transactions and calls the ‘findTopSpenders’ function to find the top spenders.
The ‘findTopSpenders’ function takes a list of transactions as input and returns a list of ‘CustomerSpending’ objects representing the top spenders. It follows a divide-and-conquer approach:

- If the dataset contains only one transaction, it creates a ‘CustomerSpending’ object for that transaction and returns it as the result. 
- Otherwise, it splits the dataset into two equal halves, ‘leftHalf’ and ‘rightHalf’.
- It recursively calls ‘findTopSpenders’ on both halves to find the top spenders in each half.
- It then calls the ‘mergeTopSpenders’ function to merge the top spenders from both halves
- Finally, it returns the merged top spenders 

The ‘mergeTopSpenders’ function takes two lists of ‘CustomerSpending’ objects representing the top spenders from left and right halves and merges them:

1) It creates a ‘Map’ called ‘mergedSpendera’ to store the merged spending information for each customer 
2) It iterates over the top spenders from the left half and adds their spending amounts to the corresponding customer’s total spending in the ‘mergedSpenders’ map.
3) It does the same for the top spenders from the right half. 
4) After merging the spending information, it creates a new list called ‘sortedSpenders’ to store the merged spenders in descending order of their total spending.
5) It sorts the merged spenders based on their total spending using the ‘sort’ method and a custom comparator
6) Finally, it returns the top 10 spenders from the sorted spenders list (or fewer if there are less than 10 spenders)

Manual Calculation of Divide and Conquer 

Divide: Divide the dataset into two halves.

Conquer : Then, continue to divide the dataset into smaller subproblems to ease in the conquer process of 
finding the top spender.

Combine: Compare Left and Right Side

Final top spender is : Transaction(15, 900) 

B. Dynamic Programming Algorithm
Pseudocode:

Dynamic programming algorithm solves the same problem, to find the top spender by categorising the problem into smaller and similar subproblems. Then, it continues to solve each subproblem once, the solution is then stored in a retrievable table, if there is a similar subproblem the solution from the table is retrieved instead of solving the subproblem again. It is also concluded that the optimal solution of a subproblem  is used to obtain an optimal solution of smaller subproblems, to construct the final solution.

The provided code solves the problem of finding the top spenders in a dataset using the dynamic programming paradigm. Here's an explanation of how the code works:

1. The  main function initialises the 'Transactionn’ dataset and calls the  ‘findTopSpenders’ function to obtain the top spenders, and then prints the results.

2. The 'findTopSpenders' method takes a list of 'Transactionn' objects as input and returns a list of 'CustomerSpendingg' objects. These objects are representing the top spenders. It follows the Dynamic Programming algorithm : 
- Where a ‘HashMap’ called 'totalSpendingMap' is created, where it is used to store the cumulative spending for each dataset or in this instance each customer.
- A for-each loop then iterates the code throughout the dataset, and retrieves the customer ID and amount they spent.
- The ‘totalSpendingMap' will be updated with a new entry of the customer ID and the amount spent, if the customer ID is not already in the HashMap.

3. After all the transactions are iterated, conversion of the HashMap 'totalSpendingMap' into a list of 'CustomerSpendingg'. Each object contains the customer ID and their total spending, the same information in the 'totalSpendingMap'.
- Using the 'Collections.sort' method and a custom comparator the list 'CustomerSpendingg’ is sorted in descending order, being the top spenders to appear on the top of the list.
- The code will then return the top 10 spenders from the sorted list.
