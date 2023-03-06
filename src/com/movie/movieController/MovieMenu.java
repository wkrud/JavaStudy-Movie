package com.movie.movieController;

import com.movie.vo.ComStr;
import com.movie.vo.UserVo;

import java.util.Map;
import java.util.Scanner;

public class MovieMenu {

    private ComStr comStr = new ComStr();
    private Scanner sc = new Scanner(System.in);

    public UserVo selectMenu() {
        String selectedNum = "";

        System.out.print(comStr.MAINSTR);
        selectedNum = sc.next();
        System.out.println();

        switch(selectedNum) {
            case "1":
                System.out.println("현재상영작");
                break;
            case "2":
                System.out.println("로그인");
                break;
            case "3":
                System.out.println("회원가입");
                break;
            case "4":
                System.out.println("종료");
                break;
            default : System.out.println("메뉴에 있는 번호를 입력해 주시기 바랍니다.");
        }

        return null;
    }

}
