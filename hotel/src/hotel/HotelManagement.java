package hotel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManagement {

	private int total;
	private int idx;
	private HotelInfo h;
	List<HotelInfo> info;
	List<ReserveInfo> reserves; // 예약정보
	Scanner sc = new Scanner(System.in);
	private int rOwnNum;

	int num1 = 5;
	int num2 = 5;
	int num3 = 5;

	public HotelManagement() {
		info = new ArrayList<HotelInfo>();
		reserves = new ArrayList<ReserveInfo>();
		info.add(new HotelInfo("특실", 100000, 6, num1));
		info.add(new HotelInfo("디럭스룸", 70000, 4, num2));
		info.add(new HotelInfo("일반룸", 50000, 2, num3));

	}

	public void print(List<HotelInfo> info) {
		for (int i = 0; i < info.size(); i++) {
			System.out.print(Array.get(info, i));
			System.out.println();
		}
	}

	int count;
	int count2 = 1;

	public void reserve(List<HotelInfo> info, List<Customer> cust) { // 예약 하기
		int reservecount = 0;

		System.out.print(info.toString());
		System.out.println();

		int num;
		System.out.print("룸을선택해주세요");
		num = sc.nextInt();
		String str = sc.nextLine();

		while (info.get(num).getrSpareCount() == 0) {
			System.out.print("룸을선택해주세요");
			num = sc.nextInt();
			String str2 = sc.nextLine();
			System.out.println("선택할수없습니다. 다른룸을선택헤주세요");

		}

		// num번쨰 방의 남은방수에서 -1

		switch (num) {

		case 0:
			num1--;
			info.remove(0);
			info.add(0, new HotelInfo("특실", 100000, 6, num1));
			break;

		case 1:
			num2--;
			info.remove(1);
			info.add(1, new HotelInfo("디럭스룸", 70000, 4, num2));
			break;

		case 2:
			num3--;
			info.remove(2);
			info.add(2, new HotelInfo("일반룸", 50000, 2, num3));
			break;
		}

		System.out.println(info.get(num) + "이 선택되었습니다");

		System.out.print("체크인 날짜:");
		String date = sc.nextLine();
		System.out.print("숙박기간:");
		int period = sc.nextInt();
		String str3 = sc.nextLine();
		System.out.print("예약인원:");
		int count = sc.nextInt();
		reservecount += count;
		String str2 = sc.nextLine();
		total = period * info.get(num).getrPrice();

		if (count > info.get(num).getrLimitNumber()) {
			System.out.println("추가 인원은" + (count - (info.get(num).getrLimitNumber())) + "명 입니다");
			System.out.println("1인당 추가금액은 20,000원 입니다 추가하시겠습니까? (Yes / No)");
			String a = sc.nextLine();

			if (a.equals("Yes")) {
				int p = info.get(num).getrPrice() * period;
				p += 20000 * period * (count - info.get(num).getrLimitNumber());

				total = p;

				reservecount += count - (info.get(num).getrLimitNumber());

			} else
				return;

		}

		System.out.println("예약이 완료되었습니다");
		int reserveNo = count2++;

		rOwnNum = count++;

		System.out.println("예약번호는" + reserveNo + "입니다");
		reserves.add(new ReserveInfo(info.get(num), cust.get(index++),date,period,reserveNo,reservecount));

	}

	public void reserveAssure() { // 예약 확인
		System.out.print("예약번호:");
		int reserveNo = sc.nextInt();
		String ss = sc.nextLine();

		for (int i = 0; i < reserves.size(); i++) {
			int a = reserves.get(i).getReserveNo();

			if (reserveNo == a) {
				System.out.println(reserves.toString());
			}
		}
	}

	public void checkin() { // 체크인

		System.out.print("예약번호를 입력해주세요");
		int w = sc.nextInt();
		String s = sc.nextLine();

		for (int i = 0; i < reserves.size(); i++) {
			if (reserves.get(i).getReserveNo() == w) {
				System.out.println(reserves.get(i).getH().getrName() + "-" + (rOwnNum) + "객실입니다");
				reserves.get(i).setrOwnNum(rOwnNum);

			}
		}
	}

	int index;

	public void checkout() { // 체크아웃

		System.out.print("객실이름을 입력해주세요");
		String r = sc.nextLine();
		for (int i = 0; i < reserves.size(); i++) {
			String ownnum = reserves.get(i).getH().getrName() + "-" + reserves.get(i).getrOwnNum();

			if (r.equals(ownnum)) {
				index = i;
				System.out.println("체크아웃이 완료되었습니다");
				System.out.println("계산서를 받아주새요");
				bills();
				reserves.remove(i);

			} else
				System.out.println("잘못입력하셨습니다");
		}
	}

	public void bills() { // 결제방법

		System.out.print("결제수단 (1: 현금 2: 카드)");
		String input = sc.nextLine();

		switch (input) {
		case "1": // 현금결제
			int price = reserves.get(index).getH().getrPrice();

			//int price = reserves.get(index).getTotal();
			String str = sc.nextLine();
			System.out.println(price + "원을 결제해주세요");
			System.out.print("결제금액:");
			int pay = sc.nextInt();
			int re = -1;

			while (re < 0) {
				System.out.print("결제 금액:");
				int pay1 = sc.nextInt();
				re = pay1 - price;
			}

			System.out.println("거스름돈:" + re);

			break;

		case "2": // 카드결제

			String cardNo = "";
			int price2 = reserves.get(index).getH().getrPrice();

			//int price2 = reserves.get(index).getTotal();
			System.out.println(price2 + "원을 결제해주세요");

			while (!(cardNo.equals(reserves.get(index).getC().getiden()))) {
				System.out.print("카드번호를 입력헤주세요");
				cardNo = sc.nextLine();
				if (!(cardNo.equals(reserves.get(index).getC().getiden())));
			}

			System.out.println("결제되었습니다");

			break;

		default:
			System.out.println("잘못입력하셨습니다");
			break;
		}

	}
}
