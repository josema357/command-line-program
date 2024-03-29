package com.pokesearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIKeywordValidator implements IParameterValidator{

    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches("^[a-zA-Z]+(-[a-zA-Z]+)*$")){
            System.err.println("Invalid keyword");
            throw new ParameterException("Only letters and numbers");
        }
    }
    
}
