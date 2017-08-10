package com.indra.problems.ds.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Indra Dutt
 */
public class StockBuySell {

    public class Transaction {
        int buy, sell;
    }

    public List<Transaction> listTransactions(int[] price) {
        int i = 0;
        int n = price.length;
        ArrayList<Transaction> transactions = new ArrayList<>();
        while (i < n - 1) {
            while ( i < n - 1 && price[i + 1] <= price[i])
                i++;

            if (i == n - 1) break;

            Transaction t = new Transaction();
            t.buy = i++;

            while (i < n && price[i] > price[i - 1])
                i++;

            t.sell = i - 1;
            transactions.add(t);
        }

        return transactions;
    }
}
