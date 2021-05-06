package expense.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Group {

  public Group(int groupId, String name, List<Transaction> transactionList, Date createDate,
      Date lastUpdated) {
    this.groupId = groupId;
    this.name = name;
    this.transactionList = transactionList;
    this.createDate = createDate;
    this.lastUpdated = lastUpdated;
    this.transactionList = new ArrayList<>();
  }

  public Group(int groupId, String name, Date createDate) {
    this.groupId = groupId;
    this.name = name;
    this.createDate = createDate;
    this.transactionList = new ArrayList<>();
  }

  public int getGroupId() {
    return groupId;
  }

  public void setGroupId(int groupId) {
    this.groupId = groupId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Transaction> getTransactionList() {
    return transactionList;
  }

  public void setTransactionList(List<Transaction> transactionList) {
    this.transactionList = transactionList;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  private int groupId;
  private String name;
  private List<Transaction> transactionList;
  private Date createDate;
  private Date lastUpdated;


}
