package com.rickandmorty.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class CLIKeywordValidator implements IParameterValidator {

    private static final String REGEX_VALUE_INPUT = "(^[a-zA-Z]+([\\d\\w]+[\\s]?))*[^\\s]$";

    @Override
    public void validate(String name, String value) throws ParameterException {
        if(!value.matches(REGEX_VALUE_INPUT)){
            System.err.println("keyword is no valid");
            throw new ParameterException("Accept just alphabet and numbers");
        }
    }
}