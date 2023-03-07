package com.movie.movieController;

import com.movie.vo.ComStr;
import com.movie.vo.UserVo;

import java.util.List;
import java.util.Scanner;

public class LoginNJoin {

    private ComStr comStr;
    private final Scanner sc = new Scanner(System.in);

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
