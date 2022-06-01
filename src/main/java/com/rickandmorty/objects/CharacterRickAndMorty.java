package com.rickandmorty.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import java.util.List;

@Getter
@EqualsAndHashCode
public class CharacterRickAndMorty {

    private Info info;
    private List<Result> results;

    @Override
    public String toString() {
        return "RickAndMorty {" + info + results + "\n}";
    }
}
