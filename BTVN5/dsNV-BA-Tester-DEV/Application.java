package BTVNB5_BT3;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        String[] arr = nhapThongTinNV();
        System.out.println(arr[2]);
        if (arr[2].equals("BA")) BAteam(arr);
        else if (arr[2].equals("tester")) {
            testTeam(arr);
        } else if (arr[2].equals("developer")) {
            devTeam(arr);
        } else System.out.println(" Vui lòng nhập đúng chính tả phòng ban là BA, tester, hoặc developer ");

    }

    public static void BAteam(String arr1[]) {
        BA ba1 = new BA();
        ba1.tenNV = arr1[0];
        ba1.maSoNhanVien = arr1[1];
        ba1.phongBan = arr1[2];
        ba1.setTccv("Vất vả, nghĩ nhiều.");
        ba1.thongTinNV();
        ba1.tinhChatCongViec();
        System.out.println(" --------------------- ");
    }

    public static void testTeam(String arr2[]) {
        tester tt1 = new tester();
        tt1.maSoNhanVien = arr2[1];
        tt1.tenNV = arr2[0];
        tt1.phongBan = arr2[2];
        tt1.thongTinNV();
        tt1.TtBoSung(7, "Test Lead");
        tt1.TtBoSung("đủ điều kiện trở thành nhân viên cấp cao");
        System.out.println(" --------------------- ");
    }

    public static void devTeam(String arr3[]) {
        developer dev1 = new developer();
        dev1.maSoNhanVien = arr3[1];
        dev1.tenNV = arr3[0];
        dev1.phongBan = arr3[2];
        dev1.thongTinNV();
    }

    public static String[] nhapThongTinNV() {
        Scanner input = new Scanner(System.in);
        System.out.println("Mời bạn nhập họ tên NV: ");
        String hoVaTen = input.nextLine();
        System.out.println("Mời bạn nhập mã NV: ");
        String msnv = input.nextLine();
        System.out.println("Mời bạn nhập phòng ban (Nhập đúng BA, tester hoặc developer): ");
        String phongBan = input.nextLine();
        String[] arr = new String[3];
        arr[0] = hoVaTen;
        arr[1] = msnv;
        arr[2] = phongBan;
        return arr;
    }

}
