package service.expense.entities;

public class UserTxn {
  int userId;
  int txnId;
  long amount;

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public UserTxn(int userId, int txnId, int amount) {
    this.userId = userId;
    this.txnId = txnId;
    this.amount = amount;
  }

  public UserTxn(int userId, int txnId) {
    this.userId = userId;
    this.txnId = txnId;
  }

  public int getTxnId() {
    return txnId;
  }

  public void setTxnId(int txnId) {
    this.txnId = txnId;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

  public void updateAmount(long amount) {
    this.amount = amount;
  }
}
