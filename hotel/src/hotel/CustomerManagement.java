package hotel;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement { // 회원가입

	Scanner sc = new Scanner(System.in);
	LinkedList<Customer> list = new LinkedList<Customer>();
	LinkedList<Customer> login = new LinkedList<Customer>();

	// 고객리스트
	public void newCustomer() {
		System.out.print("id:");
		String id = sc.nextLine();
		System.out.print("비밀번호:");
		String pwd = sc.nextLine();
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("전화번호:");
		String phoneNo = sc.nextLine();
		System.out.print("카드번호:");
		String cardNo = sc.nextLine();

		list.add(new Customer(id, pwd, name, phoneNo, cardNo));
	}

	public List<Customer> name() {

		int a = -1;

		while (a == -1 || login.isEmpty()) {
			System.out.print("1:회원가입 2: 로그인");
			String input = sc.nextLine();
			if (input.equals("1")) {
				newCustomer();
			} else if (input.equals("2")) {
				login = (LinkedList<Customer>) login();
				a = 1;
			}

		}
		return login;

	}

	public List<Customer> login() {
		LinkedList<Customer> list2 = new LinkedList<Customer>();

		String id;
		String pwd;

		for (int i = 0; i < list.size(); i++) {

			do {
				System.out.print("id:");
				id = sc.nextLine();
				System.out.print("비밀번호:");
				pwd = sc.nextLine();

				if (!(list.get(i).getid().equals(id)) || !(list.get(i).getpwd().equals(pwd))) {
					System.out.println("다시입력해주세요");
				}
			} while (!(list.get(i).getid().equals(id)) || !(list.get(i).getpwd().equals(pwd)));

			list2.add(0, new Customer(list.get(i).getid(), list.get(i).getpwd(), list.get(i).getname(),
					list.get(i).getphoneNo(), list.get(i).getiden()));
			System.out.println(list.get(i).getname() + "님 반갑습니다.");
		}
		return list2;

	}

	public void updateCustomer() { // 회원정보 수정

		System.out.print("id:");
		String id = sc.nextLine();
		System.out.print("비밀번호:");
		String pwd = sc.nextLine();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getid().equals(id) && list.get(i).getpwd().equals(pwd)) {
				// 로그인 성공
				System.out.print("이름:");
				String name = sc.nextLine();
				System.out.print("전화번호:");
				String phoneNo = sc.nextLine();
				System.out.print("주민등록번호:");
				String iden = sc.nextLine();

				list.remove(i);
				list.add(i, new Customer(id, pwd, name, phoneNo, iden));
			}
		}

	} // 회원정보 수정 끝

	public void removeCustomer() { // 회원 탈퇴
		System.out.print("id:");
		String id = sc.nextLine();
		System.out.print("비밀번호:");
		String pwd = sc.nextLine();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getid().equals(id) && list.get(i).getpwd().equals(pwd)) {
				// 로그인 성공
				System.out.print("탈퇴하시겠습니까?(1:Yes 2: No)");
				String input = sc.nextLine();
				if (input.equals("1")) {
					list.remove(i);
				} else
					return;
			}
		}
	} // 회원 탈퇴 끝

}
