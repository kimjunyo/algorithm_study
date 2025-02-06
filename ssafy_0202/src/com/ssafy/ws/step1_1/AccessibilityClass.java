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
public class AccessibilityClass {

    /* 접근 제한자 연습하기 */

    // Q. 모든 곳에서 접근이 가능한 접근 제한자를 작성해 봅시다.
    ____ String name = "SSAFY";

    // Q. 같은 클래스, 같은 패키지, 다른 패키지의 자식 클래스에서만 접근 가능한 제한자를 작성해 봅시다.
    ____ int money = 500;

    // Q. 같은 클래스, 같은 패키지에서만 접근 가능한 제한자를 작성해 봅시다. (*접근 제한자를 별도로 설정하지 않으면 다음의 접근 제어자가 자동으로 설정됨)
    ____ int height = 183;

    // Q. 같은 클래스에서만 접근 가능한 제한자를 작성해 봅시다.
    ____ int weight = 83;

}
