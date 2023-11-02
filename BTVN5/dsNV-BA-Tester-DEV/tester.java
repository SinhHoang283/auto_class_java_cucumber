package BTVNB5_BT3;

public class tester extends nhan_vien{
    public int  soNamKn;
    public String vaiTro;
    public String TtThem;
    public void thongTinNV() {
        System.out.println("Nhân viên " + tenNV + " Có mã nhân viên là: "+ maSoNhanVien+ " thuộc phòng " + phongBan);
    }
    public void TtBoSung(int soNamKn, String vaiTro){
        System.out.println("Đã làm tại công ty: " + soNamKn + " năm, với vai trò " + vaiTro);
    }
    public void TtBoSung(String TtThem){
        System.out.println("Đã đủ điều kiện " + TtThem);
    }
}
