package com.movie.movieService;

import com.movie.utils.CommonUtils;
import com.movie.vo.ComStr;
import com.movie.vo.UserVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LoginNJoin extends CommonUtils {

    private ComStr comStr;
    private final Scanner sc = new Scanner(System.in);

    public Map<String, Object> doLogin(Map<String, Object> usrMap) throws Exception {
        Map<String, Object> chkedUsr = null;
        try {
            chkedUsr = chkLogin(usrMap);

            if (comStr.NONE.equals(chkedUsr.get("id"))) {
                loginCtl(chkedUsr);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return chkedUsr;
    }


    public List<UserVo> loginCtl(Map<String, Object> chkMap) {
        boolean loginBool = false;
        List<UserVo> usrList = null;
        if (chkMap.containsKey("usrList")) {
            usrList = (List<UserVo>) chkMap.get("usrList");
        } else {
            usrList = new ArrayList<>();
        }
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
