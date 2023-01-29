package hello.core.singleton;

public class SingletonService {

    // 자기 자신 선언
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.printf("싱글톤 객체 로직 호출");
    }
}
