package com.movie.main;

import com.movie.movieController.MovieMenu;
import com.movie.vo.UserVo;

import java.util.HashMap;
import java.util.Map;

public class MovieMain {

    private MovieMenu movieMenu = new MovieMenu();

    public void MainStream() {
        Map<String, Object> vo = new HashMap<>();

        while(true) {
            movieMenu.selectMenu();
        }

    }

}
