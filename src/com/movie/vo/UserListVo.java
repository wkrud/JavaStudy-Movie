package com.movie.vo;

import java.io.Serializable;
import java.util.List;

public class UserListVo extends UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private UserVo loginUsr;
    private List<UserVo> usrList;
    private String end;

    public UserListVo() {}

    public UserListVo(UserVo loginUsr, List<UserVo> usrList, String end) {
        this.loginUsr = loginUsr;
        this.usrList = usrList;
        this.end = end;
    }

    public UserVo getLoginUsr() {
        return getLoginUsr();
    }

    public List<UserVo> getUsrList() {
        return getUsrList();
    }

    public String getEnd() { return getEnd(); }

    public void setLoginUsr(UserVo loginUsr) {
        this.loginUsr = loginUsr;
    }

    public void setUsrList(List<UserVo> usrList) {
        this.usrList = usrList;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "UserListVo{" +
                "loginUsr=" + loginUsr +
                ", usrList=" + usrList +
                ", end=" + end +
                '}';
    }
}
