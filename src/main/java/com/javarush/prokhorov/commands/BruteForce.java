package com.javarush.prokhorov.commands;

import com.javarush.prokhorov.constants.Strings;
import com.javarush.prokhorov.entity.Result;
import com.javarush.prokhorov.entity.ResultCode;
import com.javarush.prokhorov.exception.ApplicationException;
import com.javarush.prokhorov.util.PathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BruteForce implements Action {
    PathFinder pathFinder = new PathFinder();


    private static void extracted(StringBuilder decode, String strings, int key) {
        for (int i = 0; i < strings.length(); i++) {
            int id = Strings.ALPHABET.indexOf(strings.charAt(Integer.parseInt(String.valueOf(i))));
            int newId = (Strings.ALPHABET.length() + id - key) % Strings.ALPHABET.length();
            if (newId < 0) {
                newId = Strings.ALPHABET.length() + newId;
            }
            char newChar = Strings.ALPHABET.charAt(newId);
            decode.append(newChar);

        }
    }
    @Override
    public Result execute(String[] parameters) {
        String encode = parameters[0];
        String bruteForce = parameters[1];
        StringBuilder decode = new StringBuilder();
        Path path = Path.of(pathFinder.getRoot() + encode);
        String strings;
        try {
            strings = String.valueOf(Files.readAllLines(path));
            for (int key = 1; key <= Strings.ALPHABET.length(); key++) {
                extracted(decode, strings, key);
                if (decode.toString().contains("...") && !decode.toString().contains("*"))
                {
                    Path path3 = Path.of(pathFinder.getRoot() + bruteForce);
                    Files.write(Paths.get(String.valueOf(path3)), decode.toString().getBytes());
                    System.out.println("key = " + key);
                    break;
                }else decode = new StringBuilder();
            }
        } catch (IOException e) {
            throw new ApplicationException("Something went wrong" + e);
        }

        return new Result(ResultCode.OK, "Everything worked out" + path);
    }
}
