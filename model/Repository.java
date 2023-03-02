package Seminar_7.model;

import java.util.List;

public interface Repository {
    List<User> getAllUsers();
    String CreateUser(User user);
    void UpdateUser(User user,Fields field, String param);
    void delUser(User user);
}