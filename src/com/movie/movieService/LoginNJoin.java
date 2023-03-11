package com.movie.movieService;

import com.movie.utils.CommonUtils;
import com.movie.vo.ComStr;
import com.movie.vo.UserVo;

import java.util.*;

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


    public Map<String, Object> loginCtl(Map<String, Object> chkMap) {
        System.out.println(chkMap);
        boolean loginBool = false;
        List<UserVo> usrList = null;
        Map<String, Object> usrMap = null;
        if (chkMap.containsKey("usrList")) {
            usrList = (List<UserVo>) chkMap.get("usrList");
        } else {
            usrList = new ArrayList<>();
        }
        String ans = "";
        System.out.print(comStr.LOGINID);
        ans = sc.next();
        System.out.println();
        usrMap = new HashMap<>();

        IdLoop :
        for (UserVo chkId : usrList) {
            if (ans.equals(chkId.getId())) {
                System.out.print(comStr.LOGINPW);
                ans = sc.next();
                System.out.println();

                for (UserVo chkPw : usrList) {
                    if (ans.equals(chkPw.getPw())) {
                        loginBool = true;
                        chkPw.setLoginBool(loginBool);
                        break IdLoop;
                    }
                }
            }
        }
        usrMap.put("usrList", usrList);
        if (loginBool) {
            System.out.println(comStr.LOGINSUCCESS);
        } else {
            System.out.println(comStr.LOGINFAIL);
        }

        return usrMap;
    }

    public void test(Map<String, Object> map) {
        System.out.println(map);
    }

}
