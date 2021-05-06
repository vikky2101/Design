package expense.entities;

import java.util.List;

public class Transaction {

  private int id;
  private long amount;
  private int groupId;
  List<UserTxn> userTxnList;

  public int getPayeeUserId() {
    return payeeUserId;
  }

  public void setPayeeUserId(int payeeUserId) {
    this.payeeUserId = payeeUserId;
  }

  private int payeeUserId;

  public Transaction(int id, long amount, int groupId,
      List<UserTxn> userTxnList) {
    this.id = id;
    this.amount = amount;
    this.groupId = groupId;
    this.userTxnList = userTxnList;
  }

  public Transaction(int id, long amount, int groupId,
      int payeeUserId, List<UserTxn> userTxnList) {
    this.id = id;
    this.amount = amount;
    this.groupId = groupId;
    this.payeeUserId = payeeUserId;
    this.userTxnList = userTxnList;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

  public int getGroupId() {
    return groupId;
  }

  public void setGroupId(int groupId) {
    this.groupId = groupId;
  }

  public List<UserTxn> getUserTxnList() {
    return userTxnList;
  }

  public void setUserTxnList(List<UserTxn> userTxnList) {
    this.userTxnList = userTxnList;
  }
}
