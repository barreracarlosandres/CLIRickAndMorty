package com.rickandmorty.objects;


import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class Info {

    private String count;
    private String pages;
    private String next;
    private String prev;

    @Override
    public String toString() {
        return "Info{" + "count='" + count + '\'' + ", pages='" + pages + '\'' + ", next='" + next + '\'' + ", prev='" + prev + '\'' + '}' + "\n";
    }
}