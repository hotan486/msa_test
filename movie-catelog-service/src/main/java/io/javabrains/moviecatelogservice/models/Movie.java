package io.javabrains.moviecatelogservice.models;


public class Movie {

    private String movieId;
    private String name;

    public Movie(String movieId, String name) {
        this.movieId = movieId;
        this.name = name;
    }

    public Movie(){

    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }
}
