package spring.mybatisPractice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.data.dao.MemberDao;
import spring.data.dto.MemberDto;

public class MemberMain {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("mybatisConfig.xml");
		MemberDao dao = context.getBean("memberDao", MemberDao.class);
		
		boolean stop = false;
		while(!stop) {
			System.out.println("1.selectAll, 2.selectOne, 3.updateName, 4.insert, 5.delete, 6.exit");
			System.out.print("input > ");
			int choose = scan.nextInt();
			
			switch (choose) {
				case 1: selectAll(dao); break;
				case 2: selectOne(dao); break;
				case 3: updateName(dao); break;
				case 4: insertMember(dao); break;
				case 5: deleteMember(dao); break;
				case 6: stop = exit(); 
						break;
			}
		}
	}
	
	public static boolean exit() {
		System.out.println("프로그램 종료");
		return true;
	}
	
	public static void selectAll(MemberDao dao) {
		List<MemberDto> members = dao.getAll();
		System.out.println(members);
	}
	
	public static void selectOne(MemberDao dao) {
		Scanner scan = new Scanner(System.in);
		String id;
		System.out.print("검색할 id 입력 >");
		id = scan.nextLine();
		
		if (id != null) {
			MemberDto member = dao.getOne(id);
			if (member != null) {
				System.out.println(member);
			} else {
				System.out.println("검색결과 없음");
			}
		} else {
			System.out.println("id 입력 오류");
		}
	}
	
	public static void updateName(MemberDao dao) {
		String id, name;
		System.out.print("업데이트대상 id 입력 >");
		id = scan.nextLine();
		System.out.print("업데이트할 name 입력 >");
		name = scan.nextLine();
		
		Map<String, String> m = new HashMap<>();
		if (id != null && name != null) {
			m.put("id", id);
			m.put("name", name);
			int ret = dao.updateMember(m);
			
			if (ret > 0) System.out.println("업데이트 성공");
			else System.out.println("업데이트 실패");;
		} else {
			System.out.println("입력제대로 안됨");
		}
	}
	
	public static void insertMember(MemberDao dao) {
		String id, password, name, email;
		System.out.println("id > ");
		id = scan.nextLine();
		System.out.println("password > ");
		password = scan.nextLine();
		System.out.println("name > ");
		name = scan.nextLine();
		System.out.println("email > ");
		email = scan.nextLine();
		
		if (id != null && password != null && name != null && email != null) {
			int ret;
			MemberDto m = new MemberDto();
			m.setId(id);
			m.setPassword(password);
			m.setName(name);
			m.setEmail(email);
			ret = dao.insertMember(m);
			if (ret == 1) System.out.println("입력성공");
			else System.out.println("입력실패"); 
		} else {
			System.out.println("입력오류");
		}
	}
	
	public static void deleteMember(MemberDao dao) {
		String id;
		System.out.println("삭제할 id > ");
		id = scan.next();
		if (id != null) {
			int ret;
			ret = dao.deleteMember(id);
			
			if (ret == 1) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}
		} else {
			System.out.println("입력오류");
		}
	}
}
