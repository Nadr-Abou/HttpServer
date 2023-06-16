package org.example;

import java.util.UUID;

public class Command {
     String cmd;
     String param1;
     String param2;
     String mode;
     UUID token;

    public Command(String cmd, String param1, String param2, String mode) {
        this.cmd = cmd;
        this.param1 = param1;
        this.param2 = param2;
        this.mode = mode;
    }
    /*
    es: list
    {"cmd": "list"}

    es: login
    {"cmd": "login", "param1": "nadr", "param2": "password"}
     */

}
