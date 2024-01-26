
public class VariableTest {
	public static void main(String[] args) {
		boolean isMarried = true;
		char bloodType = 'B';
		int age = 30;
		double height = 173.5;
		float weight = 75.3f;
//		byte b = 128; //overflow
		String name = "홍길동";
		System.out.println(age);
		System.out.println(height);
		System.out.println(weight);
		System.out.println(name);
		System.out.println(isMarried);
		System.out.println(bloodType);
		
		age = 50;
		System.err.println(age);
		
		final double PI = 3.14;
		//PI = 3.141; //final은 변경 불가
		
		char ch = '홍';
		char ch2 = ' ';
		String str1 = null;
		String str2 = "";
		
		int value = 10 + 20;
		System.out.println(value);
		
		String str3 = "안녕하세요?";
		String str4 = "반갑습니다.";
		System.out.println(str3+str4);
		
		System.out.println("7"+7+7);
		System.out.println(7+7+"7");
		System.out.println(name+""+height+""+weight);
		
		float f = 1.6F;
		float d = 1.6F;
		double d2 = 3.23;
		float f2 = (float)d2;
		//특정데이터나 변수 앞에 강제로 형태를 변환시켜준것 무조건 왼쪽과 오른쪽의 형태가 같은 데이터 타입이어야 하는데
		//작은데이터를 큰 데이터에 넣을땐 강제로 형 변환이 됩니다.
		
	}

}
