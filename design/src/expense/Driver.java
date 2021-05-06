package expense;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import service.expense.entities.Group;
import service.expense.entities.Transaction;
import service.expense.entities.User;
import service.expense.entities.UserTxn;
import service.expense.service.GroupTxnService;
import service.expense.service.TransactionService;
import service.expense.service.UserService;

public class Driver {

  public static void main(String[] args) {
    User user1 = new User(12, "ABC", "abc.gmail.com", "12345678");
    User user2 = new User(13, "ABCD", "abc1.gmail.com", "123456789");
    User user3 = new User(14, "ABCDE", "abc2.gmail.com", "123456780");
    User user4 = new User(15, "ABCDEF", "abc3.gmail.com", "123456781");

    UserService userService = new UserService();
    userService.createUser(user1);
    userService.createUser(user2);
    userService.createUser(user3);
    userService.createUser(user4);

    TransactionService transactionService = new TransactionService();
    GroupTxnService groupTxnService = new GroupTxnService(transactionService);

    List<UserTxn> userTxnList = new ArrayList<>();
    userTxnList.add(new UserTxn(12, 122));
    userTxnList.add(new UserTxn(12, 122));
    userTxnList.add(new UserTxn(12, 122));
    userTxnList.add(new UserTxn(12, 122));
    Transaction transaction = new Transaction(122, 1000, 101, 12, userTxnList);

    Group group = new Group(101, "demo", Date.from(Instant.now()));
    groupTxnService.createGroup(group);
    groupTxnService.recordTxn(transaction, "equal");
    System.out.println(groupTxnService.getGroupStatus(101));



  }
}
