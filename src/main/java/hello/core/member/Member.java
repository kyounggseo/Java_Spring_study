package hello.core.member;

public class Member {

    //클래스의 멤버변수는 private 처리를 해서 클래스 내에서만 사용 가능하도록, 하지만 getter, setter 를 사용해 외부에서 읽어올 수 있음
    private long id;
    private String name;
    private Grade grade;

    //생성자
    public Member(long id, String name, Grade grade) {
        // 'this.' 은 멤버변수에 할당한다는 뜻
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //메서드, = 함수
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
