package com.javarush.prokhorov;

import com.javarush.prokhorov.controller.MainController;
import com.javarush.prokhorov.entity.Result;
import com.javarush.prokhorov.toplevel.Application;

public class Runner {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        Application application = new Application(mainController);
        Result result = application.run(args);
        System.out.println(result);
    }
}
