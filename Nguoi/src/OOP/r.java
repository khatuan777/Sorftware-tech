import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class Nguoi {
    private String hoTen;
    private Date ngaySinh;
    private String queQuan;

    public Nguoi() {
        this.ngaySinh = new Date();
    }

    public Nguoi(String hoTen, Date ngaySinh, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap ngay sinh (dd-mm-yyyy): ");
        String ns = sc.nextLine();
        ngaySinh = chuyenStringDate(ns);
        System.out.print("Nhap que quan: ");
        queQuan = sc.nextLine();
    }

    public void hienThongTin() {
        System.out.println("Ho va ten: " + hoTen);
        System.out.println("Ngay Sinh: " + ngaySinh);
        System.out.println("Que quan: " + queQuan);
    }

    public Date chuyenStringDate(String str) {
        Date ns = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            ns = sdf.parse(str);
        } catch (Exception e) {
            System.out.println("Loi dinh dang ngay thang.!");
        }
        return ns;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

}

class HSHocSinh extends Nguoi {
    private String lop;
    private String khoaHoc;

    public HSHocSinh() {

    }

    public HSHocSinh(String hoTen, Date ngaySinh, String queQuan, String lop, String khoaHoc) {
        super(hoTen, ngaySinh, queQuan);
        this.lop = lop;
        this.khoaHoc = khoaHoc;
    }

    public void nhapThongTinhocsinh() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten lop: ");
        lop = sc.nextLine();
        System.out.print("Nhap khoa hoc: ");
        khoaHoc = sc.nextLine();
    }

    public void hienThongTinhocsinh() {
        super.hienThongTin();
        System.out.println("Lop: " + lop);
        System.out.println("Khoa hoc: " + khoaHoc);
    }

    public String getLop() {
        return this.lop;
    }
}

public class r {
    public static void main(String[] args) throws Exception {
        int n;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhap so luong hoc sinh: ");
            n = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            n = 1;
        }
        String tl = null;
        ArrayList ds = new ArrayList(n);
        HSHocSinh b = new HSHocSinh();
        while (true) {
            b.nhapThongTin();
            ds.add(b);
            System.out.print("Ban co muon nhap nua khong (c/k): ");
            tl = sc.nextLine();
            if (tl.equalsIgnoreCase("k"))
                break;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("--------------------");
            ds.get(i).
            System.out.println("--------------------");
        }

        System.out.println("Nhung sinh vien que o thai nguyen va sinh nam 1985 la: ");
        for (int i = 0; i < n; i++)
            if ((ds.get(i).getNgaySinh().getYear() - 1900 == 1985)
                    && (ds.get(i).getQueQuan().equalsIgnoreCase("Thai Nguyen")))
                ds.get(i).hienThongTin();

        System.out.println("Nhung sinh vien hoc lop 10A1 la: ");
        for (int i = 0; i < ds.size(); i++)
            if (ds.get(i).getLop().equalsIgnoreCase("10A1"))
                ds.get(i).hienThongTin();
    }
}
