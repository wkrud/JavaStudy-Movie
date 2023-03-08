package com.movie.main;

import com.movie.movieController.MovieMenu;
import com.movie.vo.UserVo;

import java.util.HashMap;
import java.util.Map;

public class MovieMain {

    private MovieMenu movieMenu = new MovieMenu();

    public void MainStream() throws Exception {
        Map<String, Object> voMap = new HashMap<>();
        UserVo usrVo = new UserVo();
        try {
            while(true) {
                voMap = movieMenu.selectMenu(voMap);

                if (voMap.containsKey("END")) break;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e);
        }

    }

}
