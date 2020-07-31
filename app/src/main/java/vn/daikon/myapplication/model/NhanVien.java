package vn.daikon.myapplication.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NhanVien {

    public enum ChuyenMon {
        KE_TOAN,
        CNTT,
        MARKETING
    }
    public static List<String> getChuyenMon(){
        ChuyenMon[] list = ChuyenMon.values();
        List<String> names = new ArrayList<>();
        for (int i =0 ;i< list.length;i++) names.add( list[i].name());
        return names;
    }
    public enum ChucVu {
        NHAN_VIEN,
        TRUONG_PHONG,

    }
    public static List<String> getChucVu(){
        ChucVu[] list = ChucVu.values();
        List<String> names = new ArrayList<>();
        for (int i =0 ;i< list.length;i++) names.add( list[i].name());
        return names;
    }
    public enum TrinhDo {
        CAP3,
        CU_NHAN,
        KY_SU,
        THAC_SI,
        TIEN_SI
    }
    public static List<String> getTrinhDo(){
        TrinhDo[] list = TrinhDo.values();
        List<String> names = new ArrayList<>();
        for (int i =0 ;i< list.length;i++) names.add( list[i].name());
        return names;
    }
    public enum Phong {
        KINH_DOANH,
        PHAN_MEM,
        KIEM_DINH,
        TO_CHUC,
    }
    public static List<String> getPhong(){
        Phong[] list = Phong.values();
        List<String> names = new ArrayList<>();
        for (int i =0 ;i< list.length;i++) names.add( list[i].name());
        return names;
    }
    public String user;
    public String password;
    public String ho;
    public String ten;
    public String queQuan;
    public String namSinh;
    public ChuyenMon chuyenMon;
    public ChucVu chucVu;
    public TrinhDo trinhDo;
    public Phong phong;

    public NhanVien(String user, String password, String ho, String ten, String queQuan, String namSinh, ChuyenMon chuyenMon, ChucVu chucVu, TrinhDo trinhDo, Phong phong) {
        this.user = user;
        this.password = password;
        this.ho = ho;
        this.ten = ten;
        this.queQuan = queQuan;
        this.namSinh = namSinh;
        this.chuyenMon = chuyenMon;
        this.chucVu = chucVu;
        this.trinhDo = trinhDo;
        this.phong = phong;
    }

    public NhanVien(String user, String password) {
        this.user = user;
        this.password = password;
    }
}
