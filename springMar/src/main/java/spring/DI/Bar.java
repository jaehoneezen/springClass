package spring.DI;

public class Bar {
	public void doBar() {
		System.out.println("doBar() 실행");
	}
	
	public Bar() {
		System.out.println("생성자 실행");
	}
	
	public void start() {
		System.out.println("초기화 메서드");
	}
	
	public void stop() {
		System.out.println("소멸 메서드");
	}

}
