package kr.neo.portal.study.ex_01;

import org.junit.jupiter.api.Test;

public class IfExercise01 {

    @Test
    public void test() {
        int age = 22;
        int charge = 0;

        if(age < 8) {
            charge = 1000;
            System.out.println("미 취학 아동입니다.");
        }

        if(age < 14) {
            charge = 2000;
            System.out.println("초등학생 입니다.");
        }

        if(age < 20) {
            charge = 2500;
            System.out.println("중,고등학생 입니다.");
        }

        else {
            charge = 3000;
            System.out.println("성인 입니다.");
        }
        System.out.println("입장료는 " + charge + "원 입니다.");
    }

}
