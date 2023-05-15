import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.event.SwingPropertyChangeSupport;

class GiaoDich{
    private String maGiaoDich;
    private String ngayGiaoDich;
    private double donGia;
    private double dienTich;

    Scanner sc = new Scanner(System.in);
    public GiaoDich(){
        super();
    }
    public GiaoDich(String maGiaoDich, String ngayGiaoDich, double donGia, double dienTich){
        super();
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }
    public String getMaGiaoDich(){
        return maGiaoDich;
    }
    public void setMaGiaoDich(String maGiaoDich){
        this.maGiaoDich = maGiaoDich;
    }
    public String getNgayGiaoDich(){
        return ngayGiaoDich;
    }
    public void setNgayGiaoDich(String ngayGiaoDich){
        this.ngayGiaoDich = ngayGiaoDich;
    }
    public double getDonGia(){
        return donGia;
    }
    public void setDonGia(double donGia){
        this.donGia = donGia;
    }
    public double getDienTich(){
        return dienTich;
    }
    public void setDienTich(double dienTich){
        this.dienTich = dienTich;
    }
    public void Nhaptt(){
        System.out.println("Nhap ma giao dich: ");
        maGiaoDich = sc.nextLine();
        System.out.println("Nhap ngay giao dich (ngay/thang/nam): ");
        ngayGiaoDich = sc.nextLine();
        System.out.println("Nhap don gia: ");
        donGia = sc.nextDouble();
        System.out.println("Nhap dien tich: ");
        dienTich = sc.nextDouble();
    }

    @Override
    public String toString(){
        return super.toString() + "Ma giao dich " + this.maGiaoDich +
                                    "  |  Ngay giao dich: " + this.ngayGiaoDich + 
                                    "  |  Don gia: " + this.donGia +
                                    "  |  Dien tich: " + this.dienTich;
    }
}
class GiaoDichDat extends GiaoDich{
    private String loaiDat;
    private String choice;

    public GiaoDichDat() {
        super();
    }
    public GiaoDichDat(String loaiDat){
        super();
        this.loaiDat = loaiDat;
    }
    public String getLoaiDat(){
        return loaiDat;
    }
    public void setLoaiDat(String loaiDat){
        this.loaiDat = loaiDat;
    }
    public void Nhaptt(){
        super.Nhaptt();;
        System.out.println("Nhap loai dat (A/B/C): ");
        loaiDat = sc.nextLine();
        sc.nextLine();
    }
    public String toString(){
        return super.toString() + "Loai dat: " + this.loaiDat;
    }
}
class GiaoDichNha extends GiaoDichDat{
    private String loaiNha, diaChi;
    private int chon;

    public GiaoDichNha(){
        super();
    }
    public GiaoDichNha(String loaiNha, String diaChi){
        super();
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }
    public String getLoaiNha(){
        return loaiNha;
    }
    public void setLoaiNha(String loaiNha){
        this.loaiNha = loaiNha;
    }
    public String getDiaChi(){
        return diaChi;
    }
    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }
    public void Nhaptt(){
        System.out.println("Nhap dia chi: ");
        diaChi = sc.nextLine();
        System.out.println("Nhap loai nha (1. cap cao, 2. cap thap): ");
        chon = sc.nextInt();
        switch (chon) {
            case 1:
                loaiNha = "cap cao";
                break;
            case 2:
                loaiNha = "cap thap";
                break;
            default:
                System.out.println("Loai nha khong hop le!");
                break;
        }
    }
    @Override
    public String toString(){
        return super.toString() + "  |  Loai nha: " + this.loaiNha +
                                  "  |  Dia chi: " +this.diaChi;
    }
}
public class LabTH4B1 {
    public static void main(String[] args){
        ArrayList<GiaoDichDat> arrGiaoDichDat = new ArrayList<>();
        ArrayList<GiaoDichNha> arrGiaoDichNha = new ArrayList<>();
        int soLuongGDDat = 0, soLuongGDNha = 0;
        double tongTienGDDat = 0, trungBinhThanhTien = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong giao dich dat can khai bao: ");
        soLuongGDDat = sc.nextInt();
        System.out.println("Nhap so luong giao dich nha can khai bao: ");
        soLuongGDNha = sc.nextInt();
        for(int i = 0;i < soLuongGDDat; i++) {
            System.out.println("\nNhap thong tin giao dich dat thu " + (i + 1) + ": ");
                GiaoDichDat gdd = new GiaoDichDat(null);
                gdd.Nhaptt();
                arrGiaoDichDat.add(gdd);
            System.out.println("\nNhap thong tin giao dich nha thu " + (i + 1) + ": ");
                GiaoDichNha gdn = new GiaoDichNha(null, null);
                gdn.Nhaptt();
                arrGiaoDichNha.add(gdn);
        }
        System.out.println("============================================================Thong tin cac giao dich dat====================");
        for (int i = 0; i < arrGiaoDichDat.size(); i++){
            System.out.println(arrGiaoDichDat.get(i).toString());
        }
        System.out.println("============================================================Thong tin cac gia dich nha====================");
        for (int i = 0; i < arrGiaoDichNha.size(); i++){
            System.out.println(arrGiaoDichNha.get(i).toString());
        }
        for (int i = 0; i < arrGiaoDichDat.size(); i++){
            if (arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("A")){
                tongTienGDDat += arrGiaoDichDat.get(i).getDienTich() * arrGiaoDichDat.get(i).getDonGia() * 1.5;
            }else if (arrGiaoDichDat.get(i).getLoaiDat().equals("B") || arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("C")){
                tongTienGDDat += arrGiaoDichDat.get(i).getDienTich() * arrGiaoDichDat.get(i).getDonGia();
            }
        }
        trungBinhThanhTien = tongTienGDDat / (arrGiaoDichDat.size());
        System.out.println("====================Trung binh thanh tien cua giaon dich dat: " + trungBinhThanhTien);
        System.out.println("Cac giao dich dat duoc ghi nhan: ");
        for(int i = 0; i < arrGiaoDichDat.size(); i++) {
            String[] dateGiaoDichDat = arrGiaoDichDat.get(i).getNgayGiaoDich().split("/");
            if(dateGiaoDichDat[1].equals("5") && dateGiaoDichDat[2].equals(2023)){
                System.out.println(arrGiaoDichDat.get(i).toString());
            }
        }
        System.out.println("Cac giao dich nha duoc ghi nhan: ");
        for (int i = 0; i < arrGiaoDichDat.size(); i++){
            String[] dateGiaoDichNha = arrGiaoDichNha.get(i).getNgayGiaoDich().split("/");
            if(dateGiaoDichNha[1].equals("5") && dateGiaoDichNha[2].equals("2023")){
                System.out.println(arrGiaoDichNha.get(i).toString());
            }
        }
    }
}
