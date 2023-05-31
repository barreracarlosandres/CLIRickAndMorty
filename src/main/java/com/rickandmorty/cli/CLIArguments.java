package com.rickandmorty.cli;

import com.beust.jcommander.Parameter;

public final class CLIArguments {
    /**
     * Constructor default para permitir que solo clases en el paquete, puedan crear objetos
     * de esta clase.
     * De esta manera obligamos a que la construcción se haga mediante funciones públicas o
     * builders.
     * <p>
     * Las instancias deberán crearse mediante: CLIArguments#newInstance
     */

    CLIArguments(){
    }

    @Parameter(
            names = {"--name", "-n"},
            description = "Search by contain name of character. Example ./gradlew run --args='--name Summer'",
            validateWith = CLIKeywordValidator.class
    )
    private String name;

    @Parameter(
            names = {"--status", "-st"},
            description = "Search by status of character ('Alive', 'Dead' or 'unknown') "
    )
    private String status;

    @Parameter(
            names = {"--species", "-sp"},
            description = "Search by species of character"
    )
    private String species;

    @Parameter(
            names = {"--type", "-t"},
            description = "Search by type or subspecies of the character",
            validateWith = CLIKeywordValidator.class
    )
    private String type;

    @Parameter(
            names = {"--gender", "-g"},
            description = "Search by gender of the character ('Female', 'Male', 'Genderless' or 'unknown')."
    )
    private String gender;

    @Parameter(
            names = {"--help", "-h"},
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "To show help"
    )
    private boolean isHelp;

    @Parameter(
            names = {"--page", "-p"},
            description = "Number of page to search. By default is page 1"
    )
    private int page = 1;

    public static CLIArguments newInstance() {
        return new CLIArguments();
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public int getPage() {
        return page;
    }

    public boolean isHelp() {
        return isHelp;
    }
}