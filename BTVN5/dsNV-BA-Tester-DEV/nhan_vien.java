package BTVNB5_BT3;

public abstract class nhan_vien {
    public String tenNV;
    public String maSoNhanVien;
    public String phongBan;

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public void setMaSoNhanVien(String maSoNhanVien) {
        this.maSoNhanVien = maSoNhanVien;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public abstract void thongTinNV();
}
