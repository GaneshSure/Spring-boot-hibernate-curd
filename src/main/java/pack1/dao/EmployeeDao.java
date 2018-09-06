package pack1.dao;
import java.util.List;
import pack1.model.Employee;
public interface EmployeeDao 
{
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public void deleteEmployee(int eid);
}
