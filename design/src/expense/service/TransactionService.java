package expense.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import service.expense.entities.Transaction;

public class TransactionService {

  Map<Integer, Transaction> txnMap;

  public TransactionService() {
    txnMap = new ConcurrentHashMap<>();
  }

  public String createTxn(Transaction txn) {
    txnMap.put(txn.getId(), txn);
    return "Txn created";
  }

  public String editTxn(Transaction txn) {
    txnMap.put(txn.getId(), txn);
    return "Txn edited";
  }

}

