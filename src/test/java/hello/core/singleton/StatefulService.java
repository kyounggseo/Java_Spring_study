package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드 10000 -> 20000

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기서 문제!
    }

    // 싱글톤 방식 문제 해결 방안 , 이렇게 실행하면 됨
//    public int order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기서 문제!
//        return price;
//    }

    public int getPrice() {
        return price; //
    }
}
