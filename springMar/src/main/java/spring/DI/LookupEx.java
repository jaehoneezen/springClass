package spring.DI;

public class LookupEx {
	Baz baz;
	
	public Baz getBazByLookUp() {
		return null;
	}
	
	public void doLookupEx() {
		baz = getBazByLookUp();
		baz.doBaz();
	}

}
