package pack1.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack1.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
	@Autowired
	private SessionFactory  factory;
	
	public void addEmployee(Employee employee)
	{
		Session   session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(employee);
		tx.commit();
		session.close();
	}

	public List<Employee> listEmployeess()
	{
		Session  session=factory.openSession();
		Query  query=session.createQuery("from  Employee  e");
		List<Employee>  list=query.list();
		session.close();
		return  list;
	}

	public void deleteEmployee(int  empid)
	{
		Session   session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Employee  e=(Employee)session.get(Employee.class, empid);
		session.delete(e);
		tx.commit();
		session.close();
	}
}
