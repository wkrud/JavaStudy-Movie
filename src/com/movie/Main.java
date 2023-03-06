package com.movie;

import com.movie.main.MovieMain;

public class Main {

    public static void main(String[] args) {

        MovieMain select = new MovieMain();
        try {
            select.MainStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
