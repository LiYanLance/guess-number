package com.thoughtworks.training;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;

public class MovieFinderImpl implements MovieFinder {

    private List<String> movies = ImmutableList.of(
            "The Shawshank Redemption",
            "The Godfather",
            "The Godfather: Part II",
            "The Dark Knight",
            "12 Angry Men", "Schindler's List",
            "The Lord of the Rings: The Return of the King",
            "Pulp Fiction",
            "Il buono, il brutto, il cattivo",
            "Fight Club");

    @Override
    public List<String> find(String keyword) {
        return movies.stream().filter(name -> name.contains(keyword))
                .collect(Collectors.toList());
    }
}
