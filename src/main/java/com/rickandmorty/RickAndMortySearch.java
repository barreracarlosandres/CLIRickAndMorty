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

    public static void main(String[] args) {

        JCommander jCommander = CommanderFunctions.buildCommanderWithName("api-search", CLIArguments::newInstance);

        Stream<CLIArguments> streamOfCLI = parseArguments(jCommander, args, JCommander::usage)
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        Optional<CLIArguments> cliOptional = streamOfCLI
                .filter(cli -> !cli.isHelp())
                .findFirst();

        cliOptional.map(CLIFunctions::toMap)
                .map(RickAndMortySearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<CharacterRickAndMorty> executeRequest(Map<String, Object> options) {

        RickAndMortyAPI api = buildAPI(RickAndMortyAPI.class, "https://rickandmortyapi.com");

        return Stream.of(options).map(api::getAllCharacters);
    }
}
