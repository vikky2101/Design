package expense.service;

import java.util.HashMap;
import java.util.Map;
import service.expense.entities.Group;
import service.expense.entities.Transaction;
import service.expense.entities.UserTxn;

public class GroupTxnService {

  TransactionService transactionService;
  Map<Integer, Group> groupMap;
  Map<Integer, Map<Integer, UserTxn>> userTxnStatus;

  public GroupTxnService(TransactionService txnService) {
    transactionService = txnService;
    groupMap = new HashMap<>();
    userTxnStatus = new HashMap<>();
  }

  public String createGroup(Group group) {
    groupMap.put(group.getGroupId(), group);
    userTxnStatus.put(group.getGroupId(), new HashMap<>());
    return "Group Created";
  }

  public String recordTxn(Transaction transaction, String type) {
    Group group = groupMap.get(transaction.getGroupId());
    if (group == null) {
      return "Invalid group";
    }
    transaction = distributeAmount(transaction, type);
    transactionService.createTxn(transaction);
    group.getTransactionList().add(transaction);
    refreshStatus(transaction);
    return "Group Created";
  }


  private Transaction distributeAmount(Transaction transaction, String type){
    if("equal".equals(type)){
      long amount_per_head = transaction.getAmount()/transaction.getUserTxnList().size();
      for(UserTxn userTxn : transaction.getUserTxnList()){
           if(userTxn.getUserId() != transaction.getPayeeUserId()){
             userTxn.setAmount(amount_per_head*-1);
           }
      }
      return transaction;
    }
    return null;
  }
  private Map<Integer, UserTxn> refreshStatus(Transaction transaction) {
    Map<Integer, UserTxn> userTxnMap = userTxnStatus
        .getOrDefault(transaction.getGroupId(), new HashMap<>());
    for (UserTxn userTxn : transaction.getUserTxnList()) {
      UserTxn userTxn1 = userTxnMap.get(userTxn.getUserId());
      userTxn1.updateAmount(userTxn.getAmount());
      userTxnMap.put(userTxn.getUserId(),
          userTxn1);
    }
    return userTxnMap;
  }

  public Map<Integer, UserTxn> getGroupStatus(int groupId) {
    Map<Integer, UserTxn> userTxnMap = userTxnStatus.get(groupId);
    return userTxnMap;
  }


}
