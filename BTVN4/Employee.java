package lop_hoc_auto;

public class Employee {
    public int employee_id;
    public String employee_name;
    private int salary=100;
    public int get_employee_id(){
        return employee_id;
    }
    public void Set_employee_name(String employee_name){
        this.employee_name=employee_name;
    }
    public void Set_employee_id(int employee_id){
        this.employee_id=employee_id;
    }
    public String Get_employee_name(){
        return employee_name;
    }
    public int Get_Salary(){
        return salary;
    }
}
