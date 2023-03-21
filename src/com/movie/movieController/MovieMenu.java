package com.movie.movieController;

import com.movie.movieService.LoginNJoin;
import com.movie.utils.CommonUtils;
import com.movie.vo.ComStr;
import com.movie.vo.UserListVo;
import com.movie.vo.UserVo;

import java.util.*;

public class MovieMenu extends CommonUtils {

    private ComStr comStr;
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
            System.out.print(comStr.MAINSTR_ALL);
            selectedNum = sc.next();
            System.out.println();

            switch(selectedNum) {
                case "1":
                    System.out.println(comStr.PAGECUT);
                    System.out.println("현재상영작");
                    break;
                case "2":
                    System.out.println(comStr.PAGECUT);
                    System.out.println("로그인");
                    usrMap = loginNJoin.loginCtl(usrMap);
                    break;
                case "3":
                    System.out.println(comStr.PAGECUT);
                    System.out.println("회원가입");
                    break;
                case "4":
                    System.out.println(comStr.PAGECUT);
                    usrMap = getEnd(usrMap);
                    break;
                default :
                    System.out.println(comStr.PAGECUT);
                    System.out.println("메뉴에 있는 번호를 입력해 주시기 바랍니다.");
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
            System.out.print(comStr.MAINSTR_USR);
            selectedNum = sc.next();
            System.out.println();

            switch(selectedNum) {
                case "1":
                    System.out.println(comStr.PAGECUT);
                    System.out.println("현재상영작");
                    break;
                case "2":
                    System.out.println(comStr.PAGECUT);
                    System.out.println("마이페이지");
                    break;
                case "3":
                    System.out.println(comStr.PAGECUT);
                    System.out.println("로그아웃");
                    break;
                case "4":
                    System.out.println(comStr.PAGECUT);
                    usrMap = getEnd(usrMap);
                    break;
                default :
                    System.out.println(comStr.PAGECUT);
                    System.out.println("메뉴에 있는 번호를 입력해 주시기 바랍니다.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new Exception(e);
        }
        return usrMap;
    }

}
