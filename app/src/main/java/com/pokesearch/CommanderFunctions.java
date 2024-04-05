package com.pokesearch;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import io.reactivex.rxjava3.functions.Consumer;



public class CommanderFunctions {
    /**
     * Constructs a JCommander object with a specified name and argument provider.
     * @param <T> the type of object supplied as an argument to JCommander
     * @param cliName command line program name
     * @param argumentSupplier the argument provider that provides arguments to JCommander
     * @return a JCommander object configured with the program name and the provided arguments
     */
    static <T> JCommander buildCommanderWithName(String cliName, Supplier<T> argumentSupplier){
        JCommander jc = JCommander.newBuilder()
            .addObject(argumentSupplier.get())
            .build();
        jc.setProgramName(cliName);
        return jc;
    }

    /**
     * Parse the command line arguments using JCommander
     * @param jc the JCommander instance configured with the desired options
     * @param arguments the array of command line arguments to parse
     * @param onError a consumer to handle errors during parsing
     * @return an Optional containing a List of parsed objects if parsing is successful, otherwise empty
     * @throws Throwable any exception that might occur during parsing
     */
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
