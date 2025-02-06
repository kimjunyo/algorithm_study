package com.ssafy.ws.step1;

/**
 * 접근 제한자 연습하기
 *
 * 주석을 참고하여 ____ 부분을 채우고 프로그램을 완성해 봅시다.
 *
 * 접근 제한자는 상황에 따라 데이터의 접근을 제한하고자 사용하는 키워드입니다.
 * 접근 제한자로 public, protected, default(package), private가 있습니다.
 *
 * 실습 순서
 * 1) AccessibilityClass 구현
 * 2) AccessibilityTest 구현
 */
public class AccessibilityTest {
    public static void main(String[] args) {

        // Q. AccessibilityClass 객체를 생성해 봅시다.
        AccessibilityClass accessibilityClass = new AccessibilityClass();

        // Q. name에 접근해 봅시다.
        System.out.println("name: " + accessibilityClass.____);

        // Q. money에 접근해 봅시다.
        System.out.println("money: " + accessibilityClass.____);

        // Q. height에 접근해 봅시다.
        System.out.println("height: " + accessibilityClass.____);

        // Q. weight에 접근해 봅시다.
        System.out.println("weight: " + accessibilityClass.____);

        // Q. weight에 접근하는 경우 발생하는 메시지를 작성해 봅시다.
        System.out.println("private 접근자를 갖는 weight에 접근하면 The field AccessibilityClass.weight is ____ ____이 발생합니다.");

    }
}
