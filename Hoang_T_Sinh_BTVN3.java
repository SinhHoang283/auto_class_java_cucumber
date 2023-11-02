package lop_hoc_auto;

import java.util.Scanner;


public class BTVN3 {
    public static void main(String[] args) {
        int arr1[] = {4, 6, 8, 9, 50, 11, 54, 64};
        int arr2[] = bubble_sort_sap_xep_mag_giam_dan(arr1);
        printArray(arr2);
//    input_and_check_out_conditions();
        int[] arr3 = nhap_mang_tu_ban_phim();
        check_arr_and_out(arr3);
    }

    public static void input_and_check_out_conditions() {
        Scanner userinput = new Scanner(System.in);
        System.out.println("Mời bạn nhập 1 số: ");
        int var1 = userinput.nextInt();
        if (var1 % 6 == 0) System.out.println("Điều kiện thoát xảy ra");
        while (var1 % 6 != 0) {
            System.out.println("Mời bạn nhập 1 số: ");
            var1 = userinput.nextInt();
            int var2 = var1;
            if (var2 % 6 == 0) {
                System.out.println("Điều kiện thoát xảy ra");
            }
        }
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

    public static void check_arr_and_out(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            if ((arr[i] % 2 == 0) && (arr[i] %3 == 0)) {
                System.out.println("Với phần tử " + arr[i] + " Điều kiện thoát xảy ra");
                break;
            } else  System.out.println("phần tử thứ " + j + " của mảng là: " + arr[i]);

        }
    }

    public static int[] bubble_sort_sap_xep_mag_giam_dan(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] < arr[j + 1]) {
                    // swap arr[j+1] và arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
    }

    // In các phần tử của arr
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}



