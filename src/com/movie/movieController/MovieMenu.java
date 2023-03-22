package com.movie.movieController;

import com.movie.movieService.LoginNJoin;
import com.movie.utils.CommonUtils;
import com.movie.vo.ComStr;
import com.movie.vo.UserVo;

import java.util.Map;
import java.util.Scanner;

public class MovieMenu extends CommonUtils {

    private Scanner sc = new Scanner(System.in);

    private LoginNJoin loginNJoin = new LoginNJoin();

    public MovieMenu() {
    }

    public void selectMenu(Map<String, Object> usrMap) throws Exception {
//        Map<String, Object> usrMap = null;
        try {
            while (!"END".equals((String) usrMap.get("END"))) {
//                userList.setEnd("END");
                System.out.println(usrMap);
                if (usrMap.containsKey("loginUsr") && !"".equals(((UserVo) usrMap.get("loginUsr")).getId())) {
                    usrMap = selectForUsr(usrMap);
                } else {
                    usrMap = selectForAll(usrMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }

    }

    public Map<String, Object> selectForAll(Map<String, Object> usrMap) throws Exception {
        String selectedNum = "";
        Boolean loginBool = false;

        try {
            System.out.print(ComStr.MAINSTR_ALL);
            selectedNum = sc.next();
            System.out.println();
            System.out.println(ComStr.PAGECUT);

            switch(selectedNum) {
                case "1":
                    System.out.println("현재상영작");
                    break;
                case "2":
                    System.out.println("로그인");
                    usrMap = loginNJoin.loginCtl(usrMap);
                    break;
                case "3":
                    System.out.println("회원가입");
                    usrMap = loginNJoin.joinUsr(usrMap);
                    break;
                case "4":
                    usrMap = getEnd(usrMap);
                    break;
                default :
                    System.out.println(ComStr.DEFAULT_MSG);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e);
        }
        return usrMap;
    }

    public Map<String, Object> selectForUsr(Map<String, Object> usrMap) throws Exception {
        String selectedNum = "";
        Boolean loginBool = false;

        try {
            System.out.print(ComStr.MAINSTR_USR);
            selectedNum = sc.next();
            System.out.println();
            System.out.println(ComStr.PAGECUT);

            switch(selectedNum) {
                case "1":
                    System.out.println("현재상영작");
                    break;
                case "2":
                    System.out.println("마이페이지");
                    break;
                case "3":
                    System.out.println("로그아웃");
                    usrMap = loginNJoin.doLogout(usrMap);
                    break;
                case "4":
                    usrMap = getEnd(usrMap);
                    break;
                default :
                    System.out.println(ComStr.DEFAULT_MSG);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e);
        }
        return usrMap;
    }

}
