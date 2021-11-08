package hotel;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		CustomerManagement cm = new CustomerManagement();
		HotelManagement hm = new HotelManagement();
	
		LinkedList<Customer>list = new LinkedList<Customer>();
		LinkedList<Customer>login = new LinkedList<Customer>();
		List<HotelInfo>list2 = new LinkedList<HotelInfo>();
		login = (LinkedList<Customer>)cm.name();
		
		while(true) {
			System.out.println("1.������ȸ 2.���ǿ��� 3.������Ȳ 4.ȸ������ 5.����");
			System.out.print("�������ּ���");
			String input = sc.nextLine();
			
			switch(input) {
			case"1": //������ȸ
				list2 = hm.info;
				System.out.println(list2.toString());
				break;
				
			case"2": //���ǿ���
				list2 = hm.info;
				hm.reserve(list2, login);
				break;
				
			case"3": //������Ȳ
				System.out.println("1:������Ȳ 2: üũ�� 3:üũ�ƿ�");
				String input2 = sc.nextLine();
				switch(input2) {
				
				case"1": //������Ȳ
					hm.reserveAssure();
					break;
					
				case"2": //üũ��
					hm.checkin();
					break;
					
				case"3": //üũ�ƿ�
					hm.checkout();
					break;
				}
				
				break;
				
			case"4": //ȸ������
				System.out.println("1:ȸ���������� 2:ȸ������ ����");
				String input3 = sc.nextLine();
				if(input3.equals("1")) {
					cm.updateCustomer();
					System.out.println(cm.list.toString());
				} else if(input3.equals("2")) {
					cm.removeCustomer();
					System.out.println(cm.list.toString());
					login.remove();
				}
				
				break;
			case"5": //����
				System.out.println("���α׷�����");
				return;
			}
		}
	}

}
