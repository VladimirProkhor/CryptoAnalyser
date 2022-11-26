package com.javarush.prokhorov.controller;

import com.javarush.prokhorov.commands.Action;
import com.javarush.prokhorov.commands.BruteForce;
import com.javarush.prokhorov.commands.Decoder;
import com.javarush.prokhorov.commands.Encoder;

@SuppressWarnings("unused")
public enum Actions {
    ENCODE(new Encoder()),DECODE(new Decoder()), BRUTE_FORCE(new BruteForce());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String command) {

        return Actions.valueOf(command.toUpperCase()).action;
    }
}
