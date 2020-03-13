package spring.DI;

public class Baz {

	String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void doBaz() {
		System.out.println(name + "가 doBaz() 실행");
	}

	@Override
	public String toString() {
		return "Baz [name=" + name + "]";
	}
	

}
