package hotel;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerManagement { // ȸ������

	Scanner sc = new Scanner(System.in);
	LinkedList<Customer> list = new LinkedList<Customer>();
	LinkedList<Customer> login = new LinkedList<Customer>();

	// ������Ʈ
	public void newCustomer() {
		System.out.print("id:");
		String id = sc.nextLine();
		System.out.print("��й�ȣ:");
		String pwd = sc.nextLine();
		System.out.print("�̸�:");
		String name = sc.nextLine();
		System.out.print("��ȭ��ȣ:");
		String phoneNo = sc.nextLine();
		System.out.print("ī���ȣ:");
		String cardNo = sc.nextLine();

		list.add(new Customer(id, pwd, name, phoneNo, cardNo));
	}

	public List<Customer> name() {

		int a = -1;

		while (a == -1 || login.isEmpty()) {
			System.out.print("1:ȸ������ 2: �α���");
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
				System.out.print("��й�ȣ:");
				pwd = sc.nextLine();

				if (!(list.get(i).getid().equals(id)) || !(list.get(i).getpwd().equals(pwd))) {
					System.out.println("�ٽ��Է����ּ���");
				}
			} while (!(list.get(i).getid().equals(id)) || !(list.get(i).getpwd().equals(pwd)));

			list2.add(0, new Customer(list.get(i).getid(), list.get(i).getpwd(), list.get(i).getname(),
					list.get(i).getphoneNo(), list.get(i).getiden()));
			System.out.println(list.get(i).getname() + "�� �ݰ����ϴ�.");
		}
		return list2;

	}

	public void updateCustomer() { // ȸ������ ����

		System.out.print("id:");
		String id = sc.nextLine();
		System.out.print("��й�ȣ:");
		String pwd = sc.nextLine();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getid().equals(id) && list.get(i).getpwd().equals(pwd)) {
				// �α��� ����
				System.out.print("�̸�:");
				String name = sc.nextLine();
				System.out.print("��ȭ��ȣ:");
				String phoneNo = sc.nextLine();
				System.out.print("�ֹε�Ϲ�ȣ:");
				String iden = sc.nextLine();

				list.remove(i);
				list.add(i, new Customer(id, pwd, name, phoneNo, iden));
			}
		}

	} // ȸ������ ���� ��

	public void removeCustomer() { // ȸ�� Ż��
		System.out.print("id:");
		String id = sc.nextLine();
		System.out.print("��й�ȣ:");
		String pwd = sc.nextLine();

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getid().equals(id) && list.get(i).getpwd().equals(pwd)) {
				// �α��� ����
				System.out.print("Ż���Ͻðڽ��ϱ�?(1:Yes 2: No)");
				String input = sc.nextLine();
				if (input.equals("1")) {
					list.remove(i);
				} else
					return;
			}
		}
	} // ȸ�� Ż�� ��

}
