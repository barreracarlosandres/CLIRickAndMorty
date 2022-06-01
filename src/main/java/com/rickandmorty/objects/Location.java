package com.rickandmorty.objects;

import java.util.Objects;

public class Location {

    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

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
