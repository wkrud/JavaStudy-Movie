package com.movie.movieController;

import com.movie.movieService.LoginNJoin;
import com.movie.utils.CommonUtils;
import com.movie.vo.ComStr;
import com.movie.vo.UserVo;

import java.util.*;

public class MovieMenu extends CommonUtils {

    private ComStr comStr;
    private Scanner sc = new Scanner(System.in);

    private LoginNJoin loginNJoin = new LoginNJoin();

    public MovieMenu() {
    }

    public Map<String, Object> selectMenu(Map<String, Object> startMap) throws Exception {
        Map<String, Object> usrMap = null;

        try {
            usrMap = chkLogin(startMap);

            if (comStr.NONE.equals((String) usrMap.get("chk"))) {
                selectForAll(usrMap);
            } else {
                selectForUsr(usrMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return usrMap;
    }

    public Map<String, Object> selectForAll(Map<String, Object> usrMap) throws Exception {
        String selectedNum = "";
        Boolean loginBool = false;

        try {
            System.out.print(comStr.MAINSTR);
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
                    System.out.println("종료");
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
            System.out.print(comStr.MAINSTR);
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
//                    System.out.println(usrMap);
//                    usrMap = loginNJoin.doLogin(usrMap);
//                    usrMap = loginCtl(usrMap);
//                    loginNJoin.loginCtl(usrMap);
//                    usrMap = loginNJoin.loginCtl(usrMap);
//                    usrMap = Collections.unmodifiableMap(loginNJoin.loginCtl(usrMap));
                    break;
                case "3":
                    System.out.println(comStr.PAGECUT);
                    System.out.println("로그아웃");
                    break;
                case "4":
                    System.out.println(comStr.PAGECUT);
                    System.out.println("종료");
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
