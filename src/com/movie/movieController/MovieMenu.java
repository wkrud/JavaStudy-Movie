package com.movie.movieController;

import com.movie.vo.ComStr;
import com.movie.vo.UserVo;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieMenu {

    private ComStr comStr;
    private Scanner sc = new Scanner(System.in);

    public UserVo selectMenu() throws Exception {
        String selectedNum = "";

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

        return null;
    }

    public List<UserVo> loginCtl(List<UserVo> usrList) {
        boolean loginBool = false;
        String ans = "";
        System.out.print(comStr.LOGINID);
        ans = sc.next();
        System.out.println();

        IdLoop :
        for (UserVo chkId : usrList) {
            if (ans.equals(chkId.getId())) {
                System.out.print(comStr.LOGINPW);
                ans = sc.next();
                System.out.println();

                for (UserVo chkPw : usrList) {
                    if (ans.equals(chkPw.getPw())) {
                        loginBool = true;
                        break IdLoop;
                    }
                }
            }
        }

        if (loginBool) {
            System.out.println(comStr.LOGINSUCCESS);
        } else {
            System.out.println(comStr.LOGINFAIL);
        }


        return usrList;
    }

}
