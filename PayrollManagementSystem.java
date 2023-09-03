package Projects;

import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int ID;

    Employee(String name, int ID){
        this.name =name;
        this.ID=ID;
    }

    public String getName(){
        return name;
    }

    public int getID(){
        return ID;
    }

    public abstract double calculatePayment();

    @Override
    public String toString(){
        return "Employee [Name="+ name +" ID="+ID+" Salary="+ calculatePayment()+"]";
    }
}

class FullTimeEmployee extends Employee{
    private double salary;

    FullTimeEmployee(String name, int ID, double Salary){
        super(name, ID);
        this.salary =Salary;
    }

    @Override
    public double calculatePayment(){
        return salary;
    }
}

class PartTimeEmployee extends Employee{
    private double salary;
    private double hours;
    private double time;

    PartTimeEmployee(String name, int ID,double Hours, double Time ){
        super(name, ID);
        this.hours =Hours;
        this.time =Time;
    }

    @Override
    public double calculatePayment(){
        salary = hours * time;
        return salary;
    }

}

class PayRollSystem {
    ArrayList<Employee> empList =  new ArrayList();

    public void getEmployee(int ID){
        for (Employee emp: empList){
            if (emp.getID()==ID){
                System.out.println(emp);
                break;
            }
        }
    }

    public void addEmployee(Employee employee){
        empList.add(employee);
    }

    public void removeEmployee(int ID){
        Employee employeeToRemove =  null;
       for(Employee emp : empList){
           if (emp.getID()==ID){
               employeeToRemove=emp;
               break;
           }
       }
       if (employeeToRemove!=null)
        empList.remove(employeeToRemove);
    }

    public void showEmployees(){
        for (Employee emp : empList){
            System.out.println(emp);
        }
    }
}
public class PayrollManagementSystem {
    public static void main(String[] args){
        PayRollSystem obj = new PayRollSystem();
       FullTimeEmployee emp1 = new FullTimeEmployee("Sanket", 1,70000);
       PartTimeEmployee emp2 =  new PartTimeEmployee("Akashy", 2 , 40,100);
       obj.addEmployee(emp1);
       obj.addEmployee(emp2);

        System.out.println("Show All employees :");
        obj.showEmployees();

        System.out.println("Show employee ID 2 details:");
        obj.getEmployee(2);

        System.out.println("Remove employee ID 1");
        obj.removeEmployee(1);

        System.out.println("Show All employees :");
        obj.showEmployees();

    }
}
