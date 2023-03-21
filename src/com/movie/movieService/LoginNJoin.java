package com.movie.movieService;

import com.movie.utils.CommonUtils;
import com.movie.vo.ComStr;
import com.movie.vo.UserListVo;
import com.movie.vo.UserVo;

import java.util.*;

public class LoginNJoin extends CommonUtils {

    private ComStr comStr;
    private final Scanner sc = new Scanner(System.in);

    /**
     * 메소드 설명 : 로그인
     * @param usrMap
     * @return
     */
    public Map<String, Object> loginCtl(Map<String, Object> usrMap) {
        boolean loginBool = false;
        UserListVo chkedListVo = null;
        UserVo loginUsr = null;

        String ans = "";
        System.out.print(comStr.LOGINID);
        ans = sc.next();
        System.out.println();

        IdLoop :
        for (UserVo chkId : (List<UserVo>) usrMap.get("usrList")) {
            if (ans.equals(chkId.getId())) {
                System.out.print(comStr.LOGINPW);
                ans = sc.next();
                System.out.println();

                for (UserVo chkPw : (List<UserVo>) usrMap.get("usrList")) {
                    if (chkId.getId().equals(chkPw.getId()) && ans.equals(chkPw.getPw())) {
                        loginBool = true;
                        loginUsr = chkPw;
                        usrMap.put("loginUsr", loginUsr);
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

        return usrMap;
    }

    public Map<String, Object> doLogout(Map<String, Object> usrMap) {

        List<UserVo> usrList = (List<UserVo>) usrMap.get("usrList");
        List<UserVo> reList = new ArrayList<>();

        for (UserVo vo : usrList) {
            if (vo.getLoginBool()) {
                vo.setLoginBool(false);
            }
            reList.add(vo);
        }

        return null;
    }

}
