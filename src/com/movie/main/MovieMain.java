package com.movie.main;

import com.movie.movieController.MovieMenu;
import com.movie.vo.UserListVo;
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
        usrVo.setPw("default");
        usrList.add(usrVo);
        voMap.put("usrList", usrList);
        voMap.put("chk", "NONE");
        UserListVo userListVo = new UserListVo();
        userListVo.setUsrList(usrList);
        userListVo.setEnd("START");

        boolean bool = true;
        try {
            while ("END".equals(userListVo.getEnd())) {
//                userListVo = movieMenu.selectMenu(userListVo);

//                if ("END".equals(userListVo.getEnd())) bool = false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e);
        }

    }

}
