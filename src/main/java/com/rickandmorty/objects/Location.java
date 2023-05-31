package com.rickandmorty.objects;

import lombok.Getter;

import java.util.Objects;

@Getter
public final class Location {

    private String name;
    private String url;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && Objects.equals(url, location.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }
}