package com.ssafy.hw.step2;

import java.util.Arrays;

// IUserManager 의 실제 구현, IUserManager 에 정의된 메소드들을 모두 구현 해야한다.
public class UserManagerImpl implements  IUserManager {

    private User[] userList = new User[100];

    private final int MAX_SIZE = 100;

    private int size = 0;

    // 싱글톤 패턴을 위한 객체 생성, 알맞은 접근 제어자 설정
    private static UserManagerImpl um = new UserManagerImpl();

    // 싱글톤 패턴의 기본 생성자, 객체 생성을 외부에서 하지 못하게 막음
    private UserManagerImpl() {};

    // 외부에서 사용할 수 있도록 UserManagerImpl 인스턴스 반환
    public static UserManagerImpl getInstance() {
        return um;
    }

    public void add(User user) {
        if (size < MAX_SIZE) {
            userList[size++] = user;
        } else {
            System.out.println("유저의 수가 100을 넘었습니다. 등록 불가.");
        }
    }

    public User[] getList() {

        return Arrays.copyOfRange(userList, 0, size);
    }

    public User[] getUsers() {

        int cnt = 0;

        for (int i = 0; i < this.size; i++) {
            if (!(userList[i] instanceof VipUser)) {
                cnt++;
            }
        }

        if (cnt == 0)
            return null;

        User[] res = new User[cnt];

        for (int i = 0, index = 0; i < this.size; i++) {
            if (!(userList[i] instanceof VipUser)) {
                res[index++] = userList[i];
            }
        }

        return res;

    }

    public VipUser[] getVipUsers() {

        int cnt = 0;

        for (int i = 0; i < this.size; i++) {
            if (userList[i] instanceof VipUser) {
                cnt++;
            }
        }

        if (cnt == 0)
            return null;

        VipUser[] res = new VipUser[cnt];

        for (int i = 0, index = 0; i < this.size; i++) {
            if (userList[i] instanceof VipUser) {
                res[index++] = (VipUser) userList[i];
            }
        }

        return res;

    }

    public User[] searchByName(String name) {

        int cnt = 0;

        for (int i = 0; i < this.size; i++) {
            if (userList[i].getName().contains(name)) {
                cnt++;
            }
        }

        if (cnt == 0)
            return null;

        User[] res = new User[cnt];

        for (int i = 0, index = 0; i < this.size; i++) {
            if (userList[i].getName().contains(name)) {
                res[index++] = userList[i];
            }
        }

        return res;
    }

    public double getAgeAvg() {

        int sum = 0;

        for (int i = 0; i < this.size; i++) {
            sum += userList[i].getAge();
        }

        return sum / this.size;

    }

}
