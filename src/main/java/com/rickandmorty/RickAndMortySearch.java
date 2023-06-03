package com.rickandmorty;

import com.beust.jcommander.JCommander;
import com.rickandmorty.api.RickAndMortyAPI;
import com.rickandmorty.cli.CLIArguments;
import com.rickandmorty.cli.CLIFunctions;
import com.rickandmorty.objects.CharacterRickAndMorty;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.rickandmorty.CommanderFunctions.parseArguments;
import static com.rickandmorty.api.APIFunctions.buildAPI;

public class RickAndMortySearch {

    private static final String COMMAND_NAME = "api-search";
    private static final String URL_API = "https://rickandmortyapi.com";


    private static JCommander getjCommander() {
        return CommanderFunctions.buildCommanderWithName(COMMAND_NAME, CLIArguments::newInstance);
    }

    private static Stream<CLIArguments> getCliArgumentsStream(String[] args, JCommander jCommander) {
        return parseArguments(jCommander, args, JCommander::usage).orElse(Collections.emptyList()).stream().map(
                CLIArguments.class::cast);
    }

    private static Stream<CharacterRickAndMorty> executeRequest(Map<String, Object> options) {

        RickAndMortyAPI api = buildAPI(RickAndMortyAPI.class, URL_API);

        return Stream.of(options).map(api::getAllCharacters);
    }

    public static void main(String[] args) {

        JCommander jCommander = getjCommander();

        Stream<CLIArguments> streamOfCLI = getCliArgumentsStream(args, jCommander);

        Optional<CLIArguments> cliOptional = streamOfCLI
                .filter(cli -> !cli.isHelp())
                .findFirst();

        cliOptional.map(CLIFunctions::toMap)
                   .map(RickAndMortySearch::executeRequest)
                   .orElse(Stream.empty())
                   .forEach(System.out::println);
    }
}