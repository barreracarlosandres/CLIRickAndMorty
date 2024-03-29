package com.rickandmorty.objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public final class Result {

    private String id;
    private String name;

    private String status;

    private String species;

    private String type;

    private String gender;

    private URL origin;

    private URL location;

    private String image;

    private String[] episode;

    private String url;

    private String created;

    @Override
    public String toString() {
        return "\n\tResult{" + "\n\t\tid='" + id + '\'' + ", \n\t\tname='" + name + '\'' + ", \n\t\tstatus='" + status + '\'' + ", \n\t\tspecies='" + species + '\'' + ", \n\t\ttype='" + type + '\'' + ", \n\t\tgender='" + gender + '\'' + ", \n\t\torigin=" + origin + ", \n\t\tlocation=" + location + ", \n\t\timage='" + image + '\'' + ", \n\t\tepisode=" + printEpisode(episode) + ", \n\t\turl='" + url + '\'' + ", \n\t\tcreated='" + created + '\'' + '}';
    }

    private String printEpisode(String[] episodes){
        StringBuilder salida = new StringBuilder();
        for(String s: episodes){
            if( s.equals(episodes[episodes.length-1]) ) {
                salida.append(s);
            } else {
                salida.append(s).append("\n\t\t\t");
            }
        }
        return salida.toString();
    }
 }