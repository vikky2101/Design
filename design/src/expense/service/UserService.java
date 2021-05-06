package expense.service;

import java.util.HashMap;
import java.util.Map;
import service.expense.entities.User;

public class UserService {

  Map<String, User> userMap;

  public UserService() {
    userMap = new HashMap<>();
  }

  public String createUser(User user) {
    if (!userMap.containsKey(user.getMobile())) {
      userMap.put(user.getMobile(), user);
      return "USer Created ";
    } else {
      return "User Aready exists ";
    }
  }


}
