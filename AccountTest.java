import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.text.NumberFormat;



class Account {
    long sotk;
    String tentk;
    double sotien;
    String trangthai;

    public Account() {
    }

    public Account(long sotk, String tentk, double sotien, String trangthai) {
        this.sotk = sotk;
        this.tentk = tentk;
        this.sotien = sotien;
    }

    public long getSotk() {
        return sotk;
    }

    public void setSotk(long sotk) {
        this.sotk = sotk;
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        this.sotien = sotien;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(localeVN);
        String str = formatter.format(sotien);
        return "Tai khoan [" +
                "So tai khoan" + sotk +
                "Ten tai khoan" + tentk + 
                "So tien" + sotien +
                "Trang thai" + trangthai + "]";
    }

    public double napTien() {
        Scanner sc = new Scanner(System.in);
        double nap;
        System.out.print("Nhap so tien can nap: ");
        nap = sc.nextDouble();
        if (nap >= 0) {
            sotien = nap + sotien;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(nap);
            System.out.println("ban vua nap " + str1 + " vao tai khoan.");
        } else {
            System.out.println("So tien nap khong hop le!");
        }
        return nap;
    }
 
    public double rutTien() {
        Scanner sc = new Scanner(System.in);
        double phirut = 1000;
        double rut;
        System.out.print("Nhap so tien can rut: ");
        rut = sc.nextDouble();
        if (rut <= (sotien - phirut)) {
            sotien = sotien - (rut + phirut);
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(rut);
            System.out.println("Ban vua rut " + str1 + "tu tai khoan, phi la 1000 VND.");
        } else {
            System.out.println("So tien rut khong hop le!");
            return rutTien();
        }
        return rut;
    }

    public double chuyenTien() {
        Scanner sc = new Scanner(System.in);
        double phichuyen = 1500;
        double chuyen;
        String ghichu;
        System.out.println("Nhap so tai khoan can chuyen");
        long sotk1 = sc.nextLong();
        sc.nextLine();
        System.out.println("Nhap so tien can chuyen: ");
        chuyen = sc.nextDouble();
        if (chuyen <= (sotien - phichuyen)) {
            sotien = sotien - (chuyen + phichuyen);
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str1 = currencyEN.format(chuyen);
            System.out.println("Ban vua chuyen " + str1 + "vao tai khoan" + sotk1 + " phi la 1500 VND.");
        } else {
            System.out.println("So tien rut khong hop le!");
            return rutTien();
        }
        return chuyen;
    }

    public double daoHan() {
        double laiSuat = 0.035;
        sotien = sotien + sotien * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(sotien);
        System.out.println("Ban vua duoc " + str1 + " tu dao han 1 thang");
        return sotien;
    }

    void inTK() {
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(sotien);
        System.out.printf("%-10d %-20s %-20s \n", sotk, tentk, str1);
    }
}

class AccountList {
    private ArrayList <Account> tknh;
    public AccountList() {
        this.tknh = new ArrayList<Account>(10);
    }

    public AccountList(ArrayList<Account> tknh) {
		this.tknh = tknh;
	}

    public void themTK(Account ttk) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong TK muon them");
        int n = sc.nextInt();
        for(int i = 0;i < n; i++) {
        System.out.println("\nTai khoan thu " + (i + 1)+": ");
            if(ttk instanceof Account) {
            ttk = new Account();

            System.out.println("Nhap so TK");
            long sotk = sc.nextLong();
            sc.nextLine();
            System.out.println("Nhap ten TK");
            String tentk = sc.nextLine();
            System.out.println("Nhap so tien");
            Double sotien = sc.nextDouble();
            sc.nextLine();
            System.out.println("Nhap trang thai");
            String trangthai = sc.nextLine();
            }       
        }
        tknh.add(ttk);
    }
    

    public void timTK(long sotk) {
        for (Account ktk : tknh) {
            if(ktk.getSotk() >= 0) {
                System.out.println(ktk);
            } 
        }
    }

    public boolean xoaTK(Account ttk) {
		return this.tknh.remove(ttk);
	}

    public int soluongTK() {
        return this.tknh.size();
    }

    public void inDanhSachTKNH() {
        for (Account o: tknh) {
            o.toString();
        }
    
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account tk = new Account(0, null, 0, null);
        Account p;
        AccountList al = new AccountList();
        long p1, p2;
        Account a[] = null;
        int n = 0;
        int m = 0;
        do {
            System.out.println("\n_______Quan ly tai khoan ngan hang ABC_______");
            System.out.println("\nMoi ban chon");
            System.out.println("1.Them tai khoan");
            System.out.println("2.So TK hien co");
            System.out.println("3.In thong tin tat ca TK");
            System.out.println("4.Nap tien vao TK");
            System.out.println("5.Rut tien");
            System.out.println("6.Chuyen tien");
            System.out.println("0.Ket thuc");
            m = sc.nextInt();
            sc.nextLine();

            if(m==1){
                p = new Account();
                al.themTK(tk);
                        System.out.println("Them TK thanh cong!");
            }

            else if(m==2) {
                if(al.soluongTK() == 0){
                    System.out.println("Khong co TK nao !");
                }else{
                    System.out.println("So luong TK la: " + al.soluongTK());
                }
            }

            else if(m==3) {
                al.inDanhSachTKNH();
            }

            else if(m==4) {
                System.out.println("Nhap so TK can nap: ");
                p1 = sc.nextLong();
                for (int i = 0; i < n; i++) {
                    p2 = a[i].getSotk();
                    if (p1 == p2) {
                        System.out.println("Ban chon TK: " + p2);
                        a[i].napTien();
                    } else {
                        System.out.println("");
                    }
                }
            }

            else if(m==5) {
                System.out.println("Nhap so TK can rut: ");
                    p1 = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        p2 = a[i].getSotk();
                        if (p1 == p2) {
                            System.out.println("Ban chon TK: " + p2);
                            a[i].rutTien();
                        }
                    }
            }

            else if(m==6) {
                System.out.println("Nhap so TK can chuyen: ");
                    p1 = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        p2 = a[i].getSotk();
                        if (p1 == p2) {
                            System.out.println("Ban chon TK: " + p2);
                            a[i].chuyenTien();
                        }
                    }
            }
        } while (m!=0);
    }
}
