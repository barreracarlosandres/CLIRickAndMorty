package com.rickandmorty.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class URL {

    private String name;
    private String url;

    @Override
    public String toString() {
        return "{" + "\n\t\t\tname='" + name + '\'' + ", \n\t\t\turl='" + url + '\'' + '}';
    }
}