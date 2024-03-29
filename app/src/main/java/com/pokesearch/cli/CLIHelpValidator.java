package com.pokesearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;;

public class CLIHelpValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        boolean currentValue = Boolean.parseBoolean(value);
        if(currentValue){
            throw new ParameterException("Help requested");
        }
    }
    
}
