import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class  KhoHoatuoi {
    private String maHoa;
	private String tenHoa;
    private String mau;
    private String xuatXu;
    private int soLuong;

    public KhoHoatuoi(String maHoa){
        this.maHoa=maHoa;
    }

  
    
	public KhoHoatuoi(String maHoa, String tenHoa, String mau, String xuatXu,int soLuong){
        super();
        this.maHoa=maHoa;
        this.tenHoa = tenHoa;
        this.mau=mau;
        this.xuatXu=xuatXu;
        this.soLuong=soLuong;

    }
    public String getMahoa() {
        return maHoa;
    }
    public void setMaHoa(String maHoa) {
        this.maHoa=maHoa;
    }
	public String getTenhoa() {
        return tenHoa;
    }
    public void setTenHoa(String tenHoa) {
        this.tenHoa=tenHoa;
    }
    public String getMau() {
        return mau;
    }
    public void setMau(String mau) {
        this.mau=mau;
    }
    public String getXuatXu() {
        return xuatXu;
    }
    public void setXuatXu(String xuatXu) {
        this.xuatXu=xuatXu;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong=soLuong;
    }
    public String toString(){
        return "KhoHoatuoi["+" Ma hoa: "+ maHoa +
        "   Ten Hoa: "+tenHoa +
        "   Mau hoa: "+ mau +
        "   Xuat xu: " +xuatXu +
        "   So luong: "+soLuong +"]";
    }
}

class Nhaphoa extends KhoHoatuoi {
    private String ngayNhap;
    private double giaNhap;

    public Nhaphoa(String maHoa){
        super(maHoa);
    }

    public Nhaphoa(String maHoa, String tenHoa, String mau, String xuatXu, double giaNhap, int soLuong, String ngayNhap) {
        super(maHoa,tenHoa, mau, xuatXu,soLuong);
       this.ngayNhap = ngayNhap;
       this.giaNhap=giaNhap;
   }

   public String getNgayNhap() {
       return ngayNhap;
   }
   public void setNgayNhap(String ngayNhap) {
       this.ngayNhap = ngayNhap;
   }
   public double getGiaNhap() {
    return giaNhap;
    }
    public void setGiaNhap(double giaNhap) {
    this.giaNhap=giaNhap;
    }
   @Override
   public String toString() {
    return "Nhap hoa:" +super.toString()+"\nGia nhap:"+this.giaNhap+"\nNgayNhap:"+this.ngayNhap;
    }
}

class Xuathoa extends KhoHoatuoi {
    private String ngayXuat;
    private double giaXuat;
    public Xuathoa(String maHoa, String tenHoa, String mau, String xuatXu,int soLuong, double giaXuat,
     String ngayXuat){
        super(maHoa, tenHoa, mau, xuatXu, soLuong);
        this.giaXuat=giaXuat;
        this.ngayXuat=ngayXuat;
    }
    public String getNgayXuat() {
        return ngayXuat;
    }
    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat=ngayXuat;
    }
    public double getGiaxuat() {
     return giaXuat;
     }
     public void setGiaBan(double giaXuat) {
     this.giaXuat=giaXuat;
     }
    @Override
    public String toString() {
     return "Thong tin xuat hoa:" +super.toString()+"\nNgayXuat:"+this.ngayXuat+"\nGia ban:"+this.giaXuat;
 }
}
class Danhsachnhap{
    private ArrayList<Nhaphoa> nh;
    public Danhsachnhap(){
        this.nh = new ArrayList<Nhaphoa>();
    }
    public Danhsachnhap(ArrayList<Nhaphoa> nh){
        this.nh = nh;
    }
    public void themhoaDSN(Nhaphoa nhn){
        this.nh.add(nhn);
    }
    public void inDanhSachhoaNhap() {
        for(Nhaphoa nhap: nh ){
           System.out.println(nhap);
        }
    }
    public boolean kiemtrahoaton(Nhaphoa nhn) {
		return this.nh.contains(nhn);
	}
	public boolean xoaHoa(Nhaphoa nhn) {
		return this.nh.remove(nhn);
	}
    public boolean kiemtrakhocorong(){
        return this.nh.isEmpty();
    }
    public void lamrongkho(){
        this.nh.removeAll(nh);
    }
    public void timMaHoa(String maHoa){
        for (KhoHoatuoi kht : nh) {
            if(kht.getMahoa().indexOf(maHoa)>=0){
                System.out.println(kht);
            } 
        }
    }
    public int soluonghoatuoi(){
        return this.nh.size();
    }            
    public boolean kiemtrahoa(Nhaphoa nhn){
        return this.nh.contains(nhn);
    }
    public void sapxepSoluongHoa() {
		Collections.sort(this.nh, new Comparator<Nhaphoa>(){

			public int compare(Nhaphoa nh1, Nhaphoa nh2) {
				if(nh1.getSoLuong()<nh2.getSoLuong()) {
					return 1;
				}else if(nh1.getSoLuong()>nh2.getSoLuong()){
					return -1;
				}else {
					return 0;
				}
			}
            });				
         }
         public void SapXeptheoGiaNhap() {
            Collections.sort(this.nh, new Comparator<Nhaphoa>() {

                public int compare(Nhaphoa nh1, Nhaphoa nh2) {
                    if(nh1.getGiaNhap()<nh2.getGiaNhap()) {
                        return 1;
                    }else if(nh1.getGiaNhap()>nh2.getGiaNhap()){
                        return -1;
                    }else {
                        return 0;
                    }
                }
                });				
             }
}

class Danhsachxuat{
    private ArrayList<Xuathoa> xh;
    public Danhsachxuat(){
        this.xh = new ArrayList<Xuathoa>();
    }
    public Danhsachxuat(ArrayList<Xuathoa> xh){
        this.xh = xh;
    }
    public void themhoaDSX(Xuathoa xhn){
        this.xh.add(xhn);
    }
    public void inDanhSachhoaxuat() {
        for(Xuathoa nhap: xh ){
           System.out.println(nhap);
        }
    }
    
 } 

 public class NNN {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        Danhsachnhap dsn = new Danhsachnhap();
        Danhsachxuat dsx = new Danhsachxuat();
		int n=0;
		do {
            System.out.println("\n_______Quan ly kho hoa tuoi_______");
            System.out.println("_______________MENU_______________");
            System.out.println(         
            "\n1.Them hoa" + 
            "\n2.In danh sach hoa" +
            "\n3.Sap xep so luong hoa" +
            "\n4.Sap xep theo gia nhap"+
            "\n5.Xoa hoa" +
            "\n6.Tim kiem hoa"+
            "\n7.Danh sach kho co rong khong?"+
            "\n8.Lam rong kho"+
            "\n9.So luong hoa tuoi "+
            "\n10. Nhap hoa vao danh sach xuat "+
            "\n11.In danh sach hoa da xuat di"+
            "\n0.____Nhan 0 de thoat____");

            System.out.println("Xin hay nhap lua chon: "); 
            n=sc.nextInt();
            sc.nextLine();
            if(n==1)
                    {
                        System.out.println("Nhap ma hoa: ");
                        String maHoa=sc.nextLine();

                        System.out.println("Nhap ten hoa: ");
                        String tenHoa=sc.nextLine();

                        System.out.println("Nhap mau hoa: ");
                        String mau=sc.nextLine();

                        System.out.println("Nhap xuat xu: ");
                        String xuatXu=sc.nextLine();

                        System.out.println("Nhap so luong hoa: ");
                        int soLuong=sc.nextInt();

                        System.out.println("Nhap vao gia nhap: ");
                        double giaNhap=sc.nextDouble();
                        sc.nextLine();

                        System.out.println("Nhap vao ngay nhap hoa: ");
                        String ngayNhap=sc.nextLine();

                       Nhaphoa nh= new Nhaphoa(maHoa, tenHoa, mau, xuatXu, giaNhap, soLuong, ngayNhap);
                        

                        dsn.themhoaDSN(nh);
                        System.out.println("Them hoa moi thanh cong!");
                        System.out.println("Thong tin hoa moi: \n" + 
                        "   Ma hoa: " + maHoa +
                        "   Ten hoa: "+ tenHoa +
                        "   Mau hoa: "+ mau +
                        "   Xuat xu: " +xuatXu +
                        "   So luong: "+soLuong+
                        "   Gia nhap: " +giaNhap +
                        "   Ngay nhap: " +ngayNhap);
                    }
                    else if(n==2)
                    {
                        dsn.inDanhSachhoaNhap();
                    }
                    else if(n==3)
                    {
                        dsn.sapxepSoluongHoa();
                        dsn.inDanhSachhoaNhap();
                    }else if(n==4){
                        dsn.SapXeptheoGiaNhap();
                     }
                    else if(n==5)
                    { 
                    System.out.println("Nhap ma hoa muon xoa: ");
                    String maHoa=sc.nextLine();

		            Nhaphoa nhvk = new Nhaphoa(maHoa);
		            System.out.println("Xoa hoa:"+dsn.xoaHoa(nhvk));
                    }
                    else if(n==6)
                    {
                        System.out.println("Nhap ma hoa can tim: ");
                        String maHoa=sc.nextLine();
                        
                        Nhaphoa nh=new Nhaphoa(maHoa);
                        System.out.println("Tim hoa: ");
                        dsn.timMaHoa(maHoa);
                    }
                    else if(n==7)
                    {
                            System.out.println("Danh sach co rong khong: "+dsn.kiemtrakhocorong());
                        }
                        else if(n==8)
                        {
                            dsn.lamrongkho();
                            System.out.println("Da lam rong kho!");
                    }else if(n==9)
                    {
                        if(dsn.soluonghoatuoi()==0){
                            System.out.println("Khong co hoa nao !");
                        }else{

                            System.out.println("so luong hoa la:"+dsn.soluonghoatuoi());
                        }
                    } else if(n==10)
                    {
                        System.out.println("Nhap ma hoa: ");
                        String maHoa=sc.nextLine();

                        System.out.println("Nhap ten hoa: ");
                        String tenHoa=sc.nextLine();

                        System.out.println("Nhap mau hoa: ");
                        String mau=sc.nextLine();

                        System.out.println("Nhap xuat xu: ");
                        String xuatXu=sc.nextLine();

                        System.out.println("Nhap so luong hoa: ");
                        int soLuong=sc.nextInt(); 

                        System.out.println("Nhap ngay xuat kho: ");
                        String ngayXuat=sc.nextLine();

                        System.out.println("Nhap gia xuat hoa :");
                        double giaxuat = sc.nextDouble(); 
                     
                       
                         Xuathoa xhx= new Xuathoa(maHoa, tenHoa, mau, xuatXu, soLuong, giaxuat, null);
                         dsx.themhoaDSX(xhx);

                        System.out.println("Xuat hoa thanh cong!");
                        System.out.println("Thong tin hoa duoc xuat: \n" + 
                        "   Ma hoa: "+maHoa +
                        "   Ten hoa: "+tenHoa +
                        "   Mau hoa: "+mau +
                        "   Xuat xu: "+xuatXu +
                        "   So luong: "+soLuong +
                        "   Ngay xuat: "+ngayXuat +
                        "   Gia xuat: "+ giaxuat);
                    }else if(n==11){
                         dsx.inDanhSachhoaxuat();
                     }
        }while (n!=0);
    }
}