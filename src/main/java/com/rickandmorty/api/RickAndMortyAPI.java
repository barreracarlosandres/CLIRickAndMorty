package com.rickandmorty.api;

import com.rickandmorty.objects.CharacterRickAndMorty;
import com.rickandmorty.objects.Result;
import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

@Headers("Accept: application/json")
public interface RickAndMortyAPI {

    @RequestLine("GET /api/character/")
    CharacterRickAndMorty getAllCharacters(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /api/character/{id}")
    Result toPage(@Param("id") String id);

}
