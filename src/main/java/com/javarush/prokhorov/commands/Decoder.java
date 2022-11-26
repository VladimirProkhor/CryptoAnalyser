package com.javarush.prokhorov.commands;

import com.javarush.prokhorov.entity.Result;
import com.javarush.prokhorov.entity.ResultCode;
import com.javarush.prokhorov.exception.ApplicationException;
import com.javarush.prokhorov.util.PathFinder;

import java.io.*;

public class Decoder implements Action {
    PathFinder pathFinder = new PathFinder();
    @Override
    public Result execute(String[] parameters) {
        String encryptedFile = parameters[0];
        String xtxFile = parameters[1];
        int key = Integer.parseInt(parameters[2]);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathFinder.getRoot() + encryptedFile));
            {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFinder.getRoot() + xtxFile))) {
                    while (reader.ready()) {
                        String line = reader.readLine()+"\n";
                        for (int i = 0; i < line.length(); i++) {
                            writer.write(Caesar.symbol_left_shift(line.charAt(i), key));
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new ApplicationException("Something went wrong" + e);
        }
        return new Result(ResultCode.OK,"Everything worked out" + encryptedFile);
    }
}
