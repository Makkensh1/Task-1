package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        User user1 = new User( "Vasya", "Ivanov", (byte) 18);
        User user2 = new User( "Petya", "Leskov", (byte) 20);
        User user3 = new User( "Tom", "Cat", (byte) 25);
        User user4 = new User( "Jerry", "Mouse", (byte) 15);
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("User с именем - " + user1.getName() + " добавлен в базу данных");
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("User с именем - " + user2.getName() + " добавлен в базу данных");
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println("User с именем - " + user3.getName() + " добавлен в базу данных");
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println("User с именем - " + user4.getName() + " добавлен в базу данных");
        userService.getAllUsers().stream().forEach(user -> System.out.println(user));
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
