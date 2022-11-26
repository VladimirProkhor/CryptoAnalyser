package com.javarush.prokhorov.toplevel;

import com.javarush.prokhorov.controller.MainController;
import com.javarush.prokhorov.entity.Result;

import java.util.Arrays;

public class Application {
    private final MainController mainController;

    public Application(MainController mainController) {
        this.mainController = mainController;
    }


    public Result run(String[] args) {
        // encode text.txt encode.txt 26
        String command = args[0];
        String[] parameters = Arrays.copyOfRange(args, 1, args.length);

        return mainController.execute(command, parameters);
    }
}
