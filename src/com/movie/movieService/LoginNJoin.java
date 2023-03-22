package com.movie.movieService;

import com.movie.utils.CommonUtils;
import com.movie.vo.ComStr;
import com.movie.vo.UserVo;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LoginNJoin extends CommonUtils {

    private final Scanner sc = new Scanner(System.in);

    /**
     * 메소드 설명 : 로그인
     * @param usrMap
     * @return usrMap
     */
    public Map<String, Object> loginCtl(Map<String, Object> usrMap) throws Exception {
        boolean loginBool = false;
        UserVo loginUsr = null;
        List<UserVo> usrList = null;

        try {
            String ans = "";
            System.out.print(ComStr.LOGINID);
            ans = sc.next();
            System.out.println();

            usrList = (List<UserVo>) usrMap.get("usrList");

            IdLoop :
            for (UserVo chkId : usrList) {
                if (ans.equals(chkId.getId())) {
                    System.out.print(ComStr.LOGINPW);
                    ans = sc.next();
                    System.out.println();

                    for (UserVo chkPw : usrList) {
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
                System.out.println(ComStr.LOGINSUCCESS);
            } else {
                System.out.println(ComStr.LOGINFAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return usrMap;
    }

    /**
     * 메소드 설명 : 로그아웃
     * @param usrMap
     * @return usrMap
     * @throws Exception
     */
    public Map<String, Object> doLogout(Map<String, Object> usrMap) throws Exception {

        try {
            usrMap.remove("loginUsr");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        return usrMap;
    }

    /**
     * 메소드 설명 : 회원가입
     * @param usrMap
     * @return
     */
    public Map<String, Object> joinUsr(Map<String, Object> usrMap) throws Exception {

        String ans = "";
        String id = "";
        String pw = "";
        String pwChk = "";
        List<UserVo> usrList = null;
        boolean idChkBool = false;
        boolean menuBool = true;
        UserVo newUsr = null;

        try {
            usrList = (List<UserVo>) usrMap.get("usrList");

            while (true) {
                // 멘트
                System.out.print(ComStr.LOGINID);
                id = sc.next();
                System.out.println();

                idChkBool = false;
                // 아이디 유효성 검사
                for (UserVo vo : usrList) {
                    menuBool = true;
                    if (id.equals(vo.getId())) {
                        System.out.println(ComStr.DUPID);
                        idChkBool = true;

                        while (menuBool) {
                            System.out.println(ComStr.JOIN);
                            ans = sc.next();
                            switch (ans) {
                                case "1" : menuBool = false; break;
                                case "2" : fndPw(usrList);
                                           break;
                                case "3" : return usrMap;
                                default: System.out.println(ComStr.DEFAULT_MSG);
                            }
                        }


                    }
                }

                // 비밀번호 확인
                if (!idChkBool) {
                    idChkBool = true;
                    while (idChkBool) {
                        System.out.println(ComStr.LOGINPW);
                        pw = sc.next();
                        System.out.println();
                        System.out.println(ComStr.CHKPW);
                        pwChk = sc.next();
                        if (pw.equals(pwChk)) {
                            System.out.println(ComStr.CHKPWS);
                            newUsr = new UserVo();
                            newUsr.setId(id);
                            newUsr.setPw(pw);
                            usrList.add(newUsr);
                            usrMap.put("usrList", usrList);
                            return usrMap;
                        } else {
                            System.out.println(ComStr.CHKPWF);
                            System.out.println(ComStr.PAGECUT);

                            while (idChkBool) {
                                System.out.println(ComStr.WRONGPW);
                                ans = sc.next();

                                switch (ans) {
                                    case "1" : idChkBool = false; break;
                                    case "2" : return usrMap;
                                    default : System.out.println(ComStr.DEFAULT_MSG);
                                }
                            }
                        }
                        idChkBool = true;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }

    }

    /**
     * 메소드 설명 : 비밀번호 찾기
     * @param usrList
     * @throws Exception
     */
    private void fndPw(List<UserVo> usrList) throws Exception {

        String nm = "";
        String eml = "";
        int cnt = 0;

        try {
            System.out.println(ComStr.CHKNAME);
            nm = sc.next();
            System.out.println(ComStr.CHKEML);
            eml = sc.next();

            for (UserVo vo : usrList) {
                if (nm.equals(vo.getName()) && eml.equals(vo.getEmail())) {
                    System.out.println(ComStr.LOGINPW + " " + vo.getPw());
                    cnt++;
                }
            }

            if (cnt == 0) {
                System.out.println(ComStr.LOGINFAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }

    }

}
