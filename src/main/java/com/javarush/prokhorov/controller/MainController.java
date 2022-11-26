package com.javarush.prokhorov.controller;

import com.javarush.prokhorov.commands.Action;
import com.javarush.prokhorov.entity.Result;

public class MainController {
    public Result execute(String command, String[] parameters) {
        Action action = Actions.find(command);
        return action.execute(parameters);
    }
}
