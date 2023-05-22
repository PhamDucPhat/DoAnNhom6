import java.util.Scanner;
import javax.swing.plaf.synth.SynthSplitPaneUI;
import java.util.ArrayList;
import java.util.List;

class PhongHoc{
    private String maPhong;
	private int dayNha;
    private double dienTich;
    private int soBongDen;
    public PhongHoc(String maPhong, int dayNha, double dienTich, int soBongDen){
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }
    public String getMaPhong(){
        return maPhong;
    }
    public void setMaPhong(String maPhong){
        this.maPhong = maPhong;
    }
    public int getDayNha(){
        return dayNha;
    }
    public void setDayNha(int dayNha){
        this.dayNha = dayNha;
    }
    public double getDienTich(){
        return dienTich;
    }
    public void setDienTich(double dienTich){
        this.dienTich = dienTich;
    }
    public int getSoBongDen(){
        return soBongDen;
    }
    public void setSoBongDen(int soBongDen){
        this.soBongDen = soBongDen;
    }
    @Override
    public String toString(){
        return String.format("%20s %10s %15s %10s", maPhong, dayNha, dienTich, soBongDen);
    }
    public boolean datChuan(){
        return (this.dienTich / this.dayNha) >= 10;
    }
    public static PhongHoc input(String maPhong){
        int dayNha = KiemDuyet.getInt("Nhap day phong hoc: ");
        double dienTich = KiemDuyet.getDouble("Nhap dien tich phong hoc: ");
        int soBongDen = KiemDuyet.getInt("Nhap so bong den: ");
        return new PhongHoc(maPhong, dayNha, dienTich, soBongDen);
    }
}
class KiemDuyet{
    static Scanner sc = new Scanner(System.in);
    static int getInt(String s){
        System.out.println(s);
        int ketQua = 0;
        try{
            ketQua = sc.nextInt();
        }catch(NumberFormatException e){
            System.out.println("Nhap khong hop le: " + s);
        }
        return ketQua;
    }
    static double getDouble(String s){
        System.out.println(s);
        double ketQua = 0;
        try{
            ketQua = sc.nextDouble();
        }catch(NumberFormatException e){
            System.out.println("Nhap khong hop le: " + s);
        }
        return ketQua;
    }
    static String getString(String s){
        String ketQua = "";
        System.out.println(s);
        try{
            ketQua = sc.nextLine();
        }catch(NumberFormatException e){
            System.out.println("Nhap khong hop le: " + s);
        }
        return ketQua;
    }
    static String getStrings(String s){
        System.out.println(s);
        String ketQua = "";
        try{
            sc.nextLine();
            ketQua = sc.nextLine();
        }catch(NumberFormatException e){
            System.out.println("Nhap khong hop le: " + s);
        }
        return ketQua;
    }
    static boolean getBoolean(String s){
        boolean ketQua = false;
        try{
            ketQua = sc.nextBoolean();
        }catch(NumberFormatException e){
            System.out.println("Nhap khong hop le: " + s);
        }
        return ketQua;
    }
}
class PhongLyThuyet extends PhongHoc{
    private final static String label = "LT";
    private boolean mayChieu;
    public PhongLyThuyet(String maPhong, int dayNha, double dienTich, int soBongDen, boolean mayChieu){
        super(label + maPhong, dayNha, dienTich, soBongDen);
        this.mayChieu = mayChieu;
    }
    public boolean getMayChieu(){
        return mayChieu;
    }
    public void setMayChieu(boolean mayChieu){
        this.mayChieu = mayChieu;
    }
    @Override
    public boolean datChuan(){
        return this.mayChieu && super.datChuan();
    }
    public static PhongLyThuyet input(String maPhong){
        PhongHoc ph = PhongHoc.input(maPhong);
        boolean mayChieu = KiemDuyet.getBoolean("Nhap so luong may chieu: ");
        return new PhongLyThuyet(maPhong, ph.getDayNha(), ph.getDienTich(), ph.getSoBongDen(), mayChieu);
    }
}
class PhongMayTinh extends PhongHoc{
    private int mayTinh;
    private final static String label = "MT";
    public PhongMayTinh(String maPhong, int dayNha, double dienTich, int soBongDen, int mayTinh){
        super(label + maPhong, dayNha, dienTich, soBongDen);
        this.mayTinh = mayTinh;
    }
    public int getMayTinh(){
        return mayTinh;
    }
    public void setMayTinh(int mayTinh){
        this.mayTinh = mayTinh;
    }
    @Override
    public boolean datChuan(){
        return (this.getDienTich() / getMayTinh()) >=1.5f &&super.datChuan();
    }
    public static PhongMayTinh input(String maPhong){
        PhongHoc ph = PhongHoc.input(maPhong);
        int mayTinh = KiemDuyet.getInt("Nhap so luong may tinh: ");
        return new PhongMayTinh(maPhong, ph.getDayNha(), ph.getDienTich(), ph.getSoBongDen(), mayTinh);
    }
}
class PhongThiNghiem extends PhongHoc{
    private String thongTinChuyenNganh;
    private int sucChua;
    private boolean bonRua;
    private final static String label = "TN";
    public PhongThiNghiem(String maPhong, int dayNha, double dienTich, int soBongDen, String thongTinChuyenNganh, int sucChua, boolean bonRua){
        super(label + maPhong, dayNha, dienTich, soBongDen);
        this.thongTinChuyenNganh = thongTinChuyenNganh;
        this.sucChua = sucChua;
        this.bonRua = bonRua;
    }
    public String getThongTinChuyenNganh(){
        return thongTinChuyenNganh;
    }
    public void setThongTinChuyenNganh(String thongTinChuyenNganh){
        this.thongTinChuyenNganh = thongTinChuyenNganh;
    }
    public int getSucChua(){
        return sucChua;
    }
    public void setSucChua(int sucChua){
        this.sucChua = sucChua;
    }
    public boolean getBonRua(){
        return bonRua;
    }
    public void setBonRua(boolean bonRua){
        this.bonRua = bonRua;
    }
    @Override
    public boolean datChuan(){
        return this.bonRua && super.datChuan();
    }
    public static PhongThiNghiem input(String maPhong){
        PhongHoc ph = PhongHoc.input(maPhong);
        String thongTinChuyenNganh = KiemDuyet.getString("Nhap thong tin chuyen nganh: ");
        System.out.println("Cong nghe");
        int sucChua = KiemDuyet.getInt("Nhap suc chua: ");
        boolean bonRua = KiemDuyet.getBoolean("Nhap bon rua: ");
        return new PhongThiNghiem(maPhong, ph.getDayNha(), ph.getDienTich(), ph.getSoBongDen(), thongTinChuyenNganh, sucChua, bonRua);
    }
}
class QuanLyDanhSachPhongHoc{
    private List<PhongHoc> dsph = new ArrayList<PhongHoc>();
    private PhongHoc timTheoMaPhongHoc(String maPhong){
        for (PhongHoc ph : dsph){
            if (ph.getMaPhong().equals(maPhong)){
                return ph;
            }
        }
        return null;
    }
    private void inDanhSachPhongHoc(List<PhongHoc> dsph1){
        System.out.println(String.format("%20s %10s %15s %10s", "MaPhong", "DayNha", "DienTich", "SoBongDen"));
        for (PhongHoc ph : dsph){
            System.out.println(ph); 
        }
    }
    private void inDanhSachPhongDatChuan(){
        System.out.println("Danh sach cac phong dat chuan: ");
        System.out.println(String.format("%20s %10s %15s %10s", "MaPhong", "DayNha", "DienTich", "SoBongDen"));
        for (PhongHoc ph : this.dsph){
            if (ph.datChuan()){
                System.out.println(ph);
            }
        }
    }
    private List<PhongHoc> sapTangTheoDayNha(){
        List<PhongHoc> dsph1 = this.dsph;
        dsph1.sort((o1, o2) -> o1.getDayNha() - o2.getDayNha());
        this.dsph = dsph1;
        return dsph1;
    }
    private List<PhongHoc> sapGiamTheoDienTich(){
        List<PhongHoc> dsph1 = this.dsph;
        dsph1.sort((o1, o2) -> (int) (o1.getDienTich() - o2.getDienTich()));
        this.dsph = dsph1;
        return dsph1;
    }
    private List<PhongHoc> sapTangTheoSoBongDen(){
        List<PhongHoc> dsph1 = this.dsph;
        dsph1.sort((o1, o2) -> o1.getSoBongDen() - o2.getSoBongDen());
        this.dsph = dsph1;
        return dsph1;
    }
    private void capNhapSoMayTinhTheoMaPhong(String maPhong, int mayTinh){
        PhongMayTinh pmt = (PhongMayTinh)this.timTheoMaPhongHoc(maPhong);
        if (pmt != null){
            pmt.setMayTinh(mayTinh);
            for (int i = 0; i < dsph.size(); i++){
                if (dsph.get(i).getMaPhong().equals(maPhong)){
                    dsph.remove(i);
                    dsph.add(i, pmt);
                }
            }
        }
    }
    public void PH(){
        this.dsph.add(new PhongLyThuyet("1", 1, 100, 10, true));
        this.dsph.add(new PhongLyThuyet("2", 2, 200, 20, true));
        this.dsph.add(new PhongLyThuyet("3", 3, 300, 30, true));
        this.dsph.add(new PhongMayTinh("4", 1, 100, 10, 10));
        this.dsph.add(new PhongMayTinh("5", 2, 200, 20, 20));
        this.dsph.add(new PhongMayTinh("6", 3, 300, 30, 30));
        this.dsph.add(new PhongThiNghiem("7", 1, 100, 10,"Cong nghe", 1, true));
        this.dsph.add(new PhongThiNghiem("8", 2, 200, 20,"Cong nghe", 2, true));
        this.dsph.add(new PhongThiNghiem("9", 3, 300, 30,"Cong nghe", 3, true));
    }
    private void menu(){
        System.out.println("1. Them phong ly thuyet");
        System.out.println("2. Them phong may tinh");
        System.out.println("3. Them phong thi nghiem");
        System.out.println("4. Cap nhat so may tinh cua phong may tinh");
        System.out.println("5. Sap tang danh sach theo day nha");
        System.out.println("6. Sap giam danh sach theo dien tich");
        System.out.println("7. Sap tang danh sach theo so bong den");
        System.out.println("8. In danh sach tat ca phong hoc");
        System.out.println("9. In danh sach phong dat chuan");
        System.out.println("10. Thoat");
        int chon = KiemDuyet.getInt("Nhap lua chon: ");
        menu(chon);
    }
    private void menu(int chon){
        switch(chon){
            case 1:
                this.dsph.add(PhongLyThuyet.input((dsph.size() + "")));
                break;
            case 2:
                this.dsph.add(PhongMayTinh.input((dsph.size() + "")));
                break;
            case 3:
                this.dsph.add(PhongThiNghiem.input((dsph.size() + "")));
                break;
            case 4:
                String maPhong = KiemDuyet.getStrings("Nhap ma phong hoc: ");
                int mayTinh = KiemDuyet.getInt("Nhap so luong may tinh: ");
                this.capNhapSoMayTinhTheoMaPhong(maPhong, mayTinh);
                break;
            case 5:
                this.inDanhSachPhongHoc(this.sapTangTheoDayNha());
                break;
            case 6:
                this.inDanhSachPhongHoc(this.sapGiamTheoDienTich());
                break;
            case 7:
                this.inDanhSachPhongHoc(this.sapTangTheoSoBongDen());
                break;
            case 8:
                this.inDanhSachPhongHoc(this.dsph);
                break;
            case 9:
                this.inDanhSachPhongDatChuan();
                break;
            case 10:
                System.exit(0);
                break;
        }
    }
    public void khoiChay(){
        this.PH();
        while(true){
            this.menu();
        }
    }
}
public class LabTH5 {
    public static void main(String args[]){
        new QuanLyDanhSachPhongHoc().khoiChay();
    }
}
