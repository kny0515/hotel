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
	List<ReserveInfo> reserves; // ��������
	Scanner sc = new Scanner(System.in);
	private int rOwnNum;

	int num1 = 5;
	int num2 = 5;
	int num3 = 5;

	public HotelManagement() {
		info = new ArrayList<HotelInfo>();
		reserves = new ArrayList<ReserveInfo>();
		info.add(new HotelInfo("Ư��", 100000, 6, num1));
		info.add(new HotelInfo("�𷰽���", 70000, 4, num2));
		info.add(new HotelInfo("�Ϲݷ�", 50000, 2, num3));

	}

	public void print(List<HotelInfo> info) {
		for (int i = 0; i < info.size(); i++) {
			System.out.print(Array.get(info, i));
			System.out.println();
		}
	}

	int count;
	int count2 = 1;

	public void reserve(List<HotelInfo> info, List<Customer> cust) { // ���� �ϱ�
		int reservecount = 0;

		System.out.print(info.toString());
		System.out.println();

		int num;
		System.out.print("�����������ּ���");
		num = sc.nextInt();
		String str = sc.nextLine();

		while (info.get(num).getrSpareCount() == 0) {
			System.out.print("�����������ּ���");
			num = sc.nextInt();
			String str2 = sc.nextLine();
			System.out.println("�����Ҽ������ϴ�. �ٸ������������ּ���");

		}

		// num���� ���� ����������� -1

		switch (num) {

		case 0:
			num1--;
			info.remove(0);
			info.add(0, new HotelInfo("Ư��", 100000, 6, num1));
			break;

		case 1:
			num2--;
			info.remove(1);
			info.add(1, new HotelInfo("�𷰽���", 70000, 4, num2));
			break;

		case 2:
			num3--;
			info.remove(2);
			info.add(2, new HotelInfo("�Ϲݷ�", 50000, 2, num3));
			break;
		}

		System.out.println(info.get(num) + "�� ���õǾ����ϴ�");

		System.out.print("üũ�� ��¥:");
		String date = sc.nextLine();
		System.out.print("���ڱⰣ:");
		int period = sc.nextInt();
		String str3 = sc.nextLine();
		System.out.print("�����ο�:");
		int count = sc.nextInt();
		reservecount += count;
		String str2 = sc.nextLine();
		total = period * info.get(num).getrPrice();

		if (count > info.get(num).getrLimitNumber()) {
			System.out.println("�߰� �ο���" + (count - (info.get(num).getrLimitNumber())) + "�� �Դϴ�");
			System.out.println("1�δ� �߰��ݾ��� 20,000�� �Դϴ� �߰��Ͻðڽ��ϱ�? (Yes / No)");
			String a = sc.nextLine();

			if (a.equals("Yes")) {
				int p = info.get(num).getrPrice() * period;
				p += 20000 * period * (count - info.get(num).getrLimitNumber());

				total = p;

				reservecount += count - (info.get(num).getrLimitNumber());

			} else
				return;

		}

		System.out.println("������ �Ϸ�Ǿ����ϴ�");
		int reserveNo = count2++;

		rOwnNum = count++;

		System.out.println("�����ȣ��" + reserveNo + "�Դϴ�");
		reserves.add(new ReserveInfo(info.get(num), cust.get(index++),date,period,reserveNo,reservecount));

	}

	public void reserveAssure() { // ���� Ȯ��
		System.out.print("�����ȣ:");
		int reserveNo = sc.nextInt();
		String ss = sc.nextLine();

		for (int i = 0; i < reserves.size(); i++) {
			int a = reserves.get(i).getReserveNo();

			if (reserveNo == a) {
				System.out.println(reserves.toString());
			}
		}
	}

	public void checkin() { // üũ��

		System.out.print("�����ȣ�� �Է����ּ���");
		int w = sc.nextInt();
		String s = sc.nextLine();

		for (int i = 0; i < reserves.size(); i++) {
			if (reserves.get(i).getReserveNo() == w) {
				System.out.println(reserves.get(i).getH().getrName() + "-" + (rOwnNum) + "�����Դϴ�");
				reserves.get(i).setrOwnNum(rOwnNum);

			}
		}
	}

	int index;

	public void checkout() { // üũ�ƿ�

		System.out.print("�����̸��� �Է����ּ���");
		String r = sc.nextLine();
		for (int i = 0; i < reserves.size(); i++) {
			String ownnum = reserves.get(i).getH().getrName() + "-" + reserves.get(i).getrOwnNum();

			if (r.equals(ownnum)) {
				index = i;
				System.out.println("üũ�ƿ��� �Ϸ�Ǿ����ϴ�");
				System.out.println("��꼭�� �޾��ֻ���");
				bills();
				reserves.remove(i);

			} else
				System.out.println("�߸��Է��ϼ̽��ϴ�");
		}
	}

	public void bills() { // �������

		System.out.print("�������� (1: ���� 2: ī��)");
		String input = sc.nextLine();

		switch (input) {
		case "1": // ���ݰ���
			int price = reserves.get(index).getH().getrPrice();

			//int price = reserves.get(index).getTotal();
			String str = sc.nextLine();
			System.out.println(price + "���� �������ּ���");
			System.out.print("�����ݾ�:");
			int pay = sc.nextInt();
			int re = -1;

			while (re < 0) {
				System.out.print("���� �ݾ�:");
				int pay1 = sc.nextInt();
				re = pay1 - price;
			}

			System.out.println("�Ž�����:" + re);

			break;

		case "2": // ī�����

			String cardNo = "";
			int price2 = reserves.get(index).getH().getrPrice();

			//int price2 = reserves.get(index).getTotal();
			System.out.println(price2 + "���� �������ּ���");

			while (!(cardNo.equals(reserves.get(index).getC().getiden()))) {
				System.out.print("ī���ȣ�� �Է����ּ���");
				cardNo = sc.nextLine();
				if (!(cardNo.equals(reserves.get(index).getC().getiden())));
			}

			System.out.println("�����Ǿ����ϴ�");

			break;

		default:
			System.out.println("�߸��Է��ϼ̽��ϴ�");
			break;
		}

	}
}
