import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class SinhVienNhap {
    private int maSV;
    private String hoTen, diaChi, sDT;

    public SinhVienNhap() {        
    }
    public SinhVienNhap(int maSV, String hoTen, String diaChi, String sDT) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sDT = sDT;
    }

    public int getMaSV() {
        return maSV;
    }
    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getSDT() {
        return sDT;
    }
    public void setSDT(String sDT) {
        this.sDT = sDT;
    }

    @Override
    public String toString() {
        return "Sinh Vien [" + 
        "Ma So Sinh Vien" + maSV +
        "Ho Ten" + hoTen +
        "Dia Chi" + diaChi +
        "So Dien Thoai" + sDT + "]";
    }
}

class DanhSachSinhVien {
    private ArrayList <SinhVienNhap> dssv;
    public DanhSachSinhVien(){
        this.dssv=new ArrayList<SinhVienNhap>();
    }
    public DanhSachSinhVien(ArrayList<SinhVienNhap> dssv) {
		this.dssv = dssv;
	}
    public void nhapThongTinSV(SinhVienNhap nsv) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong sinh vien can khai bao");
        int n = sc.nextInt();
        for(int i = 0;i < n; i++) {
        System.out.println("\nSinh vien thu " + (i + 1)+": ");
            if(nsv instanceof SinhVienNhap) {
            nsv = new SinhVienNhap();

            System.out.println("Nhap ma so sinh vien");
            int maSV = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhap ho ten");
            String hoTen = sc.nextLine();
            System.out.println("Nhap dia chi");
            String diaChi = sc.nextLine();
            System.out.println("Nhap so dien thoai");
            String sDT = sc.nextLine();
            }       
        }
        dssv.add(nsv);
    }
    public void inDSSV() {
        for (SinhVienNhap o: dssv) {
            o.toString();
        }
    }
    public void sapXepSV() {
        Collections.sort(this.dssv, new Comparator<SinhVienNhap>() {
            @Override
            public int compare(SinhVienNhap nsv1, SinhVienNhap nsv2){
                    if(nsv1.getMaSV() < nsv2.getMaSV()){
                        return 1;
                    }
                    else if(nsv1.getMaSV() > nsv2.getMaSV()){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            });
    }
}

public class SinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVienNhap sv = new SinhVienNhap();
        SinhVienNhap p;
        DanhSachSinhVien dssv1 = new DanhSachSinhVien();

        int m = 0;
        do {
            System.out.println("Moi ban chon");
            System.out.println("\n1.Nhap thong tin sinh vien");
            System.out.println("\n2.Xuat thong tin sinh vien");
            System.out.println("\n0.Nhan 0 de thoat");
            m = sc.nextInt();
            sc.nextLine();
            if(m==1){
                p = new SinhVienNhap();
                dssv1.nhapThongTinSV(sv);
            }
            else if(m==2) {
                dssv1.sapXepSV();
                dssv1.inDSSV();
            }
        } while (m!=0);
    }
}
