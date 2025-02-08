package com.ssafy.ws.step1;

public class CarMangerImpl implements ICarManager {
    // 관리하는 자동차 정보 배열 크기 100
    private Car[] carList = new Car[100];
    // 현재 등록된 자동차 정보 수
    private int size = 0;

    // 싱글톤 디자인패턴을 위해 유지하는 객체 참조
    // 클래스가 메모리에 로드될 때 객체를 1번만 생성하여 참조를 유지한다.
    private static CarMangerImpl instance = new CarMangerImpl();

    // 외부에서 객체 생성을 하지 못하도록 생성자를 _________ 으로 선언
    private CarMangerImpl() {
    }

    // 내부에서 생성한 객체의 참조를 반환한다.
    public static ICarManager getInstance() {
        return instance;
    }

    @Override
    public boolean add(Car car) {
        if (size < 100) {
            carList[size++] = car;
            return true;
        }
        return false;
    }

    @Override
    public Car[] getList() {
        Car[] result = new Car[size];

        for (int i = 0; i < size; i++) {
            result[i] = carList[i];
        }

        return result;
    }

    @Override
    public Car[] searchByModelName(String modelName) {
        int cnt = 0;
        for (int i = 0; i < this.size; i++) {
            if (carList[i].getModelName().contains(modelName))
                cnt++;
        }

        Car[] result = new Car[cnt];
        int idx = 0;
        for (int i = 0; i < this.size; i++) {
            if (carList[i].getModelName().contains(modelName))
                result[idx++] = carList[i];
        }
        return result;
    }

    @Override
    public ElectricCar[] getElectricCars() {
        int cnt = 0;
        for (int i = 0; i < this.size; i++) {
            if (carList[i] instanceof ElectricCar)
                cnt++;
        }

        ElectricCar[] eList = new ElectricCar[cnt];

        int idx = 0;
        for (int i = 0; i < this.size; i++) {
            if (carList[i] instanceof ElectricCar)
                eList[idx++] = (ElectricCar) carList[i];
        }

        return eList;
    }

    @Override
    public int getTotalMileage() {
        int total = 0;

        for (int i = 0; i < this.size; i++) {
            total += carList[i].getMileage();
        }

        return total;
    }

}
