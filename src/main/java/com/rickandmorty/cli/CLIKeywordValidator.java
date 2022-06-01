package com.rickandmorty.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIKeywordValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches("(^[a-zA-Z]+([\\d\\w]+[\\s]?))*[^\\s]$")){
            System.err.println("keyword is no valid");
            throw new ParameterException("Accept just alphabet and numbers");
        }
    }
}
