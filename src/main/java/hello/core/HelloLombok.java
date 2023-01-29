package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok 을 설치하면 이노테이션 만으로 사용 가능 => 훨씬 더 간편하게 사용 가능
@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hong");

        String name = helloLombok.getName();
        //System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);
    }
}
