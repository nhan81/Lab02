package Manh;


	import java.text.NumberFormat;
	import java.util.Scanner;
	public class Account {
	 
	    private long soTK;
	    private String tenTK;
	    private double soTienTrongTK;
	    String trangthai;
	 
	    Scanner sc = new Scanner(System.in);
	 
	    public Account() {
	    }
	 
	    
	    public Account(long soTK, String tenTK, double soTienTrongTK,String trangthai) {
	        this.soTK = soTK;
	        this.tenTK = tenTK;
	        this.soTienTrongTK = soTienTrongTK;
	        this.trangthai = trangthai;
	    }
	 
	   
	    public String getTrangthai() {
			return trangthai;
		}


		public void setTrangthai(String trangthai) {
			this.trangthai = trangthai;
		}


		public long getSoTK() {
	        return this.soTK;
	    }
	 
	    public void setSoTK(long soTK) {
	        this.soTK = soTK;
	    }
	 
	    public String getTenTK() {
	        return this.tenTK;
	    }
	 
	    public void setTenTK(String tenTK) {
	        this.tenTK = tenTK;
	    }
	 
	    public double getSoTienTrongTK() {
	        return this.soTienTrongTK;
	    }
	 
	    public void setSoTienTrongTK(double soTienTrongTK) {
	        this.soTienTrongTK = soTienTrongTK;
	    }
	 
	   
	    @Override
	    public String toString() {
	        
	        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
	        String str1 = currencyEN.format(soTienTrongTK);
	        return soTK + "-" + tenTK + "-" + str1;
	    }
	 

	    public double napTien() {
	        double nap;
	        System.out.print("Nhap so tien ban can nap: ");
	        nap = sc.nextDouble();
	  
	        if (nap >= 0) {
	            soTienTrongTK = nap + soTienTrongTK;
	            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
	            String str1 = currencyEN.format(nap);
	            System.out.println("ban vua nap " + str1 + " vao tai khoan .");
	        } else {
	            System.out.println("so tien nap khong hop le");
	        }
	        return nap;
	    }
	 
	 
	    public double rutTien() {
	        double phi = 5;
	        double rut;
	        System.out.print("Nhap so tien ban can rut ");
	        rut = sc.nextDouble();
	       
	        if (rut <= (soTienTrongTK - phi)) {
	            soTienTrongTK = soTienTrongTK - (rut + phi);
	            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
	            String str1 = currencyEN.format(rut);
	            System.out.println("Ban vua rut " + str1 + "Đ tu tai khoan. Phi là $5.");
	        } else {
	            System.out.println("So tien muon rut khong hop le");
	            return rutTien();
	        }
	        return rut;
	    }
	 
	    public double daoHan() {
	        double laiSuat = 0.035;
	        soTienTrongTK = soTienTrongTK + soTienTrongTK * laiSuat;
	        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
	        String str1 = currencyEN.format(soTienTrongTK);
	        System.out.println("Ban vua duoc " + str1 + " tu dao han 1 thang ");
	        return soTienTrongTK;
	    }
	 
	    
	    void inTK() {
	        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
	        String str1 = currencyEN.format(soTienTrongTK);
	        System.out.printf("%-10d %-20s %-20s \n", soTK, tenTK, str1);
	    }
	}

	 class Main {
	    static Scanner sc = new Scanner(System.in);
	    static void nhapTK(Account tk) {
	        System.out.println("Nhap so tai khoan : ");
	        tk.setSoTK(sc.nextInt());
	        sc.nextLine();
	        System.out.println("Nhap ten tai khoan: ");
	        tk.setTenTK(sc.nextLine());
	        tk.setSoTienTrongTK(50);
	    }
	    public static void main(String[] args) {
	        Account a[] = null;
	        int  b, n = 0;
	        long s, d, c, f;
	        boolean flag = true;
	        do {
	            System.out.println("Bạn chọn làm gì: ");
	            System.out.println("1.Nhap thong tin cua khach hang \n"
	                    + "2.Xuat thong tin \n" + "3.Nap tien \n" + "4.Rut tien \n"
	                    + "5.Dao han\n" + "6.Chuyen khoan \n" + "thoat ");
	            b = sc.nextInt();
	            switch (b) {
	                case 1:
	                    System.out.println("Nhap so luong khach muon nhap ");
	                    n = sc.nextInt();
	                    a = new Account[n];
	                    for (int i = 0; i < n; i++) {
	                        System.out.println("Khách hàng số: " + (i+1));
	                        a[i] = new Account();
	                        nhapTK(a[i]);
	                    }
	                    break;
	                case 2:
	                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "Số tiền trong TK");
	                    for (int i = 0; i < n; i++) {
	                        a[i].inTK();
	                    }
	                    break;
	                case 3:
	                    System.out.println("Nhập số tài khoản khách hàng cần nạp tiền: ");
	                    s = sc.nextLong();
	                    for (int i = 0; i < n; i++) {
	                        d = a[i].getSoTK();
	                        if (s == d) {
	                            System.out.println("Bạn chọn tài khoản: " + d);
	                            a[i].napTien();
	                        } else {
	                            System.out.println("");
	                        }
	                    }
	                    break;
	                case 4:
	                    System.out.println("Nhập số tài khoản khách hàng cần rút tiền: ");
	                    s = sc.nextLong();
	                    for (int i = 0; i < n; i++) {
	                        d = a[i].getSoTK();
	                        if (s == d) {
	                            System.out.println("Bạn chọn tài khoản: " + d);
	                            a[i].rutTien();
	                        }
	                    }
	                    break;
	                case 5:
	                    System.out.println("Nhập số tài khoản khách hàng cần đáo hạn: ");
	                    s = sc.nextLong();
	                    for (int i = 0; i < n; i++) {
	                        d = a[i].getSoTK();
	                        if (s == d) {
	                            System.out.println("Bạn chọn tài khoản: " + d);
	                            a[i].daoHan();
	                        } else {
	                            System.out.println("");
	                        }
	                    }
	                    break;
	                case 6:
	                    double chuyen,
	                            nhan,
	                            tienChuyen;
	                    System.out.print("Nhập số tài khoản khách hàng chuyển tiền: ");
	                    s = sc.nextLong();
	                    System.out.print("Nhập số tài khoản khách hàng nhận tiền: ");
	                    c = sc.nextLong();
	                    for (int i = 0; i < n; i++) {
	                        d = a[i].getSoTK();
	                        if (s == d) {
	                            chuyen = a[i].getSoTienTrongTK();
	                            for (int j = 0; j < n; j++) {
	                                f = a[j].getSoTK();
	                                if (c == f) {
	                                    nhan = a[j].getSoTienTrongTK();
	                                    System.out.println("Nhập số tiền cần chuyển");
	                                    tienChuyen = sc.nextDouble();
	                                    if (tienChuyen <= chuyen) {
	                                        chuyen = chuyen - tienChuyen;
	                                        nhan = nhan + tienChuyen;
	                                        a[i].setSoTienTrongTK(chuyen);
	                                        a[j].setSoTienTrongTK(nhan);
	                                        System.out.println("Tài khoản số " + d + " vừa chuyển: $" + tienChuyen);
	                                        System.out.println("Tài khoản số " + f + " vừa nhận: $" + tienChuyen);
	                                    } else {
	                                        System.out.println("Số tiền nhập không hợp lệ!");
	                                    }
	                                } else {
	                                    System.out.println("");
	                                }
	                            }
	                        } else {
	                            System.out.println("");
	                        }
	                    }
	                    break;
	                default:
	                    System.out.println("Bye!!");
	                    flag = false;
	                    break;
	            }
	        } while (flag);
	    
	}

	}


