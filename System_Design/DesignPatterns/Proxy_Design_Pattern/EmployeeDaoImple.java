package System_Design.DesignPatterns.Proxy_Design_Pattern;

public class EmployeeDaoImple implements EmployeeDao{
    @Override
    public void create(String client, EmployeeDo obj) throws Exception {
        //creates new ROW
        System.out.println("Created new Row in Employee Table.");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        //delete a row
        System.out.println("deleted Row with employeeId: "+employeeId);
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        //fetch row

        System.out.println("Fetching Data From Db");
        return new EmployeeDo();
    }
}
