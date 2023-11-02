package lop_hoc_auto;

import java.util.Scanner;

public class BTVN2 {
    public static void main(String[] args) {
        int[] array = nhap_mang_tu_ban_phim();
        in_ra_mang(array);
        tinh_tong_mang_1_chieu(array);
    }

    public static void tinh_tong_mang_1_chieu(int[] arr) {
        int kq = 0;
        for (int i = 0; i < arr.length; i++) {
            kq = kq + arr[i];
        }
        System.out.println("Tổng phần tử của mảng vừa nhập là: " + kq);
    }

    public static void in_ra_mang(int[] array) {
        System.out.print("mảng vừa nhập là: array = {");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + ", ");
            } else System.out.print(array[i] + "}");
        }
        System.out.println();
    }

    public static int[] nhap_mang_tu_ban_phim() {
        Scanner userinput = new Scanner(System.in);
        System.out.println("Mời bạn nhập số phần tử của mảng: ");
        int var1 = userinput.nextInt();
        int[] array = new int[var1];
        for (int i = 0; i < var1; i++) {
            int j = i + 1;
            System.out.println("Mời bạn phần tử thứ " + j + " của mảng: ");
            array[i] = userinput.nextInt();
        }
        return array;
    }
}
