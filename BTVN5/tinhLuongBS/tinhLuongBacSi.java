package overloading;

public class tinhLuongBacSi {
    public int luongCB;
    public int heSoLuong;
    public double hsloai;
    public int soNamKN;

    public String tenBS;
    public String loai;
    public int luong_bs(int luongCB, int heSoLuong){
        return luongCB*heSoLuong;
    }

    public int luong_bs(int luongCB, int heSoLuong, int soNamKN){
        return luongCB*heSoLuong*soNamKN;
    }
    public double luong_bs(int luongCB, int heSoLuong, int soNamKN, double loai){
        return luongCB*heSoLuong*soNamKN*loai;
    }

    public void setTenBS(String tenBS) {
        this.tenBS = tenBS;
    }

    public String getTenBS() {
        return tenBS;
    }


    public void setHsloai(String loai) {
        if (loai.equals("chuyên khoa")) {
            this.hsloai = 0.2;
            this.loai="chuyên khoa";
        }
        else if (loai.equals("đa khoa")) {this.hsloai = 0.45; this.loai="đa khoa";}
        else System.out.printf("Nhập sai loại đối tượng bác sĩ");
    }

    public void setLuongCB(int luongCB) {
        this.luongCB = luongCB;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public void setSoNamKN(int soNamKN) {
        this.soNamKN = soNamKN;
    }

}
