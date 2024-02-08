class MyArray <T> {
    T[] datas;
//    object[] datas = new object[10];
    void setData(int idx, T data) {
        datas[idx] =  data;
    }
    T getData(int idx) {
        return datas[idx];
    }
}

public class GnericTest1 {
    public static void main(String[] args) {
        MyArray <Integer> ma = new MyArray<>();
        ma.setData(0, 100);
        ma.setData(1, 200);

        int n1 = (Integer) ma.getData(0);
        System.out.println(n1);

        MyArray<Person> ma2 = new MyArray<>();
        ma2.setData(0,new Person("hong",20));
        Person p = (Person)ma2.getData(0);
    }
}
