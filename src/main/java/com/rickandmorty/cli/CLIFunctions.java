package com.rickandmorty.cli;

import java.util.HashMap;
import java.util.Map;

public interface CLIFunctions {

    static Map<String, Object> toMap(CLIArguments cliArguments) {

        Map<String, Object> params = new HashMap<>();

        params.put("name", cliArguments.getName());
        params.put("status", cliArguments.getStatus());
        params.put("species", cliArguments.getSpecies());
        params.put("type", cliArguments.getType());
        params.put("gender", cliArguments.getGender());
        params.put("page", cliArguments.getPage());

        return params;
    }
}
