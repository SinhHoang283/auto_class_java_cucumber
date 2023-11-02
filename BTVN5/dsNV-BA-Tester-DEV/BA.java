package BTVNB5_BT3;

public class BA extends nhan_vien{
    public String CV = "phân tích thiết kế phần mềm";
    public String tccv;
    @Override
    public void thongTinNV() {
        System.out.println("Nhân viên " + tenNV + " Có mã nhân viên là: "+ maSoNhanVien+ " thuộc phòng " + phongBan);
    }

    public void setTccv(String tccv) {
        this.tccv = tccv;
    }

    public void tinhChatCongViec(){
        System.out.println("Công việc này " + tccv);
    }
}
