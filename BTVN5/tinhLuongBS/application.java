package overloading;

public class application {
    public static void main(String[] args) {
        System.out.println("---------------------------");
        tinhLuongBacSi bs1 = new tinhLuongBacSi();
        bs1.setTenBS("Nguyễn Văn A");
        bs1.setLuongCB(3000);
        bs1.setHeSoLuong(2);
        bs1.setSoNamKN(3);
        bs1.setHsloai("chuyên khoa");
        System.out.println("Lương của bác sĩ "  + bs1.tenBS + " là: " + bs1.luong_bs(bs1.luongCB, bs1.heSoLuong));
        System.out.println("Lương của " + bs1.tenBS + " là: " + bs1.luong_bs(bs1.luongCB, bs1.heSoLuong, bs1.soNamKN));
        System.out.println("Lương của " + bs1.loai +" " +bs1.tenBS + " là: " + bs1.luong_bs(bs1.luongCB, bs1.heSoLuong, bs1.soNamKN, bs1.hsloai));
    }
}
