package com.movie.vo;

import java.io.Serializable;
import java.util.Date;

public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String pw;
    private String name;
    private String email;
    private Boolean loginBool = false;
    private Date regDt;
    private Date updDt;

    public UserVo() {
    }

    public UserVo(String id, String pw, String name, String email, Boolean loginBool, Date regDt, Date updDt) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.loginBool = loginBool;
        this.regDt = regDt;
        this.updDt = updDt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getLoginBool() {return loginBool;}

    public void setLoginBool(Boolean loginBool){this.loginBool = loginBool;}

    public Date getRegDt() {
        return regDt;
    }

    public void setRegDt(Date regDt) {
        this.regDt = regDt;
    }

    public Date getUpdDt() {
        return updDt;
    }

    public void setUpdDt(Date updDt) {
        this.updDt = updDt;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", loginBool='" + loginBool + '\'' +
                ", regDt=" + regDt +
                ", updDt=" + updDt +
                '}';
    }
    
}
