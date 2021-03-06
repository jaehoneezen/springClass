package spring.DI;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class CollectionEx {
	List<Baz> list; // Baz name a,b,c
	HashMap<String, String> map;
	Set set;
	Properties pro;
	
	public CollectionEx() {};
	
	public void setList(List<Baz> list) {
		this.list = list;
	}
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public void setPro(Properties pro) {
		this.pro = pro;
	}
	
	public void doCol() {
		for (int i = 0; i < list.size(); i++) {
			list.get(i).doBaz();
		}
	}

	@Override
	public String toString() {
		return "CollectionEx [list=" + list + ", map=" + map + ", set=" + set + ", pro=" + pro + "]";
	}
	
	
}
