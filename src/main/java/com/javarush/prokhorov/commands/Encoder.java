package com.javarush.prokhorov.commands;

import com.javarush.prokhorov.entity.Result;
import com.javarush.prokhorov.entity.ResultCode;
import com.javarush.prokhorov.exception.ApplicationException;
import com.javarush.prokhorov.util.PathFinder;

import java.io.*;

public class Encoder implements Action{

    PathFinder pathFinder = new PathFinder();
    @Override
    public Result execute(String[] parameters) {
        String xtxFile = parameters[0];
        String encryptedFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathFinder.getRoot() + xtxFile));
            {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFinder.getRoot() + encryptedFile))) {
                    while (reader.ready()) {
                        String line = reader.readLine() + "\n";
                        for (int i = 0; i < line.length(); i++) {
                            writer.write(Caesar.symbol_right_shift(line.charAt(i), key));
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new ApplicationException("Something went wrong" + e);
        }
        return new Result(ResultCode.OK,"Everything worked out");
    }
}
