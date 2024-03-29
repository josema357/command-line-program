package com.pokesearch;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import io.reactivex.rxjava3.functions.Consumer;


public class CommanderFunctions {
    static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier){
        JCommander jc = JCommander.newBuilder()
            .addObject(argumentSupplier.get())
            .build();
        jc.setProgramName(cliName);
        return jc;
    }

    static Optional<List<Object>> parseArguments(JCommander jc, String[] arguments, Consumer<JCommander> onError) throws Throwable{
        try {
            jc.parse(arguments);
            return Optional.of(jc.getObjects());
        } catch (ParameterException paramEx) {
            onError.accept(jc);
        }
        return Optional.empty();
    }
}
