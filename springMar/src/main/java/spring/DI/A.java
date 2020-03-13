package spring.DI;

public class A {
	private String id;
	private String name;
	private int birth;
	
	public A() {}
	public A(String id, String name, int birth) {
		this.id = id;
		this.name = name;
		this.birth = birth;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	
	public void doA () {
		System.out.println("id : " + id + " name " + name + " birth "  + birth);
	}

}
