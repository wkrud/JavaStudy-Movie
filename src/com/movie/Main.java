package com.movie;

import com.movie.movieController.MovieMenu;
import com.movie.vo.UserListVo;
import com.movie.vo.UserVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        MovieMain select = new MovieMain();
        MovieMenu movie = new MovieMenu();
        try {
            Map<String, Object> usrMap = new HashMap<>();
            List<UserVo> usrList = new ArrayList<>();
            UserVo usrVo = new UserVo();
            usrVo.setLoginBool(false);
            usrVo.setId("default");
            usrVo.setPw("default");
            usrList.add(usrVo);

            usrMap.put("usrList", usrList);
            usrMap.put("END", "START");
            movie.selectMenu(usrMap);
//            select.MainStream();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
