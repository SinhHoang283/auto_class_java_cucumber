package lop_hoc_auto;

public class Developer {
    public static void main(String[] args) {
        Employee nhanVien1 = new Employee();
        Employee nhanVien2 = new Employee();
        nhanVien1.Set_employee_name("Hoàng Thị Sinh");
        nhanVien1.Set_employee_id(20023001);
        nhanVien2.Set_employee_name("Hoàng Thị Hồng");
        nhanVien2.Set_employee_id(20023002);
        System.out.println("Tên NV là: " + nhanVien1.Get_employee_name() + ", Mã NV là: "+ nhanVien1.get_employee_id() + " Lương: "+nhanVien1.Get_Salary());
        System.out.println("Tên NV là: " + nhanVien2.Get_employee_name() + ", Mã NV là: "+ nhanVien2.get_employee_id() + " Lương: "+nhanVien2.Get_Salary());
    }

}
