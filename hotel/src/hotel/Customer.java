package hotel;

public class Customer {
	  // 신규및 기존고객 정보
	   private String id;
	   private String pwd;
	   private String name;
	   private String phoneNo;
	   private String iden;

	   public Customer(String id, String pwd, String name, String phonNO, String iden) {
		   super();
		   
	      this.id = id;
	      this.pwd = pwd;
	      this.name = name;
	      this.phoneNo = phoneNo;
	      this.iden = iden;
	   }

	   public Customer() {}


	public String getid() {
	      return id;
	   }

	   public void setid(String id) {
	      this.id = id;
	   }

	   public String getpwd() {
	      return pwd;
	   }

	   public void setpwd(String pwd) {
	      this.pwd = pwd;
	   }

	   public String getname() {
	      return name;
	   }

	   public void setname(String name) {
	      this.name = name;
	   }

	   public String getphoneNo() {
	      return phoneNo;
	   }

	   public void setphoneNo(String phoneNo) {
	      this.phoneNo = phoneNo;
	   }
	   
	   public String getiden() {
		   return iden;
	   }
	   public void setiden(String iden) {
		   this.iden = iden;
	   }

	   @Override
	   public String toString() {
	      return "Customer[id=" + id + ", pwd=" + pwd + ", name=" + name + ", phoneNo=" + phoneNo + ", iden=" + iden +"]";

	   }

}