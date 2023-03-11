package com.movie.main;

import com.movie.movieController.MovieMenu;
import com.movie.vo.UserVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieMain {

    private MovieMenu movieMenu = new MovieMenu();

    public void MainStream() throws Exception {
        Map<String, Object> voMap = new HashMap<>();
        List<UserVo> usrList = new ArrayList<>();
        UserVo usrVo = new UserVo();
        usrVo.setLoginBool(false);
        usrVo.setId("default");
        usrList.add(usrVo);
        voMap.put("usrList", usrList);
        voMap.put("chk", "NONE");
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
