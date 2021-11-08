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
			System.out.println("1.객실조회 2.객실예약 3.예약현황 4.회원정보 5.종료");
			System.out.print("선택해주세요");
			String input = sc.nextLine();
			
			switch(input) {
			case"1": //객실조회
				list2 = hm.info;
				System.out.println(list2.toString());
				break;
				
			case"2": //객실예약
				list2 = hm.info;
				hm.reserve(list2, login);
				break;
				
			case"3": //예약현황
				System.out.println("1:예약현황 2: 체크인 3:체크아웃");
				String input2 = sc.nextLine();
				switch(input2) {
				
				case"1": //예약현황
					hm.reserveAssure();
					break;
					
				case"2": //체크인
					hm.checkin();
					break;
					
				case"3": //체크아웃
					hm.checkout();
					break;
				}
				
				break;
				
			case"4": //회원정보
				System.out.println("1:회원정보수정 2:회원정보 삭제");
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
			case"5": //종료
				System.out.println("프로그램종료");
				return;
			}
		}
	}

}
