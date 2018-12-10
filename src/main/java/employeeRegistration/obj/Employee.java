package employeeRegistration.obj;

public class Employee {

    private Integer id;
    private String name;
    private Double salary;

    public Employee(Integer id, String name, Double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary(double percentage){
        salary += salary*percentage/100;
    }

    public Integer getId(){
        return id;
    }

    public String toString(){
        return id
                +", Name: "
                +name
                +", Salary: "
                +String.format("%.2f",salary)
                +"%n";
    }
}
