package pac;

public class MyTest {
    private int x; //클래스 안에서만쓰임
    int y; //디폴트는 같은 폴더, 패키지 안에있는 클래스에서만 사용
    protected int z; //패키지는 다르더라도 자식은 사용가능 > 아무리 자식이라도 private이나 디폴트는 접근 못함.
    public int k; //어디서든 사용 가능

    public MyTest() {} //디폴트 생성자는 클래스 안에잇는 변수나 함수는 같은 클래스안에서만 호출하도록 되어있습니다. 다른 패키지에서 사용하려면 public으로 설정해줘야합니다.
    //퍼블릭을 붙일 수 있는것은 클래스 앞에만 가능합니다.
//    접근제어: 퍼블릭 프로텍티드 프라이빗 디폴트
    public void method() {
        x=100;
    }

}
