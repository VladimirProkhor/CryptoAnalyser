package com.javarush.prokhorov.commands;

import com.javarush.prokhorov.entity.Result;

public interface Action {
    Result execute(String [] parameters);
}
