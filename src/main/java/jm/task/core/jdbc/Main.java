package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.dropUsersTable();

        userService.createUsersTable();

        userService.saveUser("Nikita", "Alekseenko", (byte) 30);
        userService.saveUser("Oleg", "Nujda", (byte) 38);
        userService.saveUser("Ekaterina", "Alekseenko", (byte) 33);
        userService.saveUser("Andrei", "Dobochuk", (byte) 31);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
