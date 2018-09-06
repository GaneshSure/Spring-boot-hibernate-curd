package pack1.controller;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack1.dao.EmployeeDao;
import pack1.model.Employee;
@Controller
public class EmployeeController 
{
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(HttpServletRequest  request)
	{
		Employee employee = new Employee();
		
		employee.setEmpId(Integer.parseInt(request.getParameter("empid")));
		employee.setEmpName(request.getParameter("empname"));
		employee.setEmpAddress(request.getParameter("empaddress"));
		employee.setEmpAge(Integer.parseInt(request.getParameter("empage")));
		employee.setSalary(Long.parseLong(request.getParameter("empsalary")));
		
		employeeDao.addEmployee(employee);
		return new ModelAndView("index","message", "Employee  added/updateD  to  Database");
	}

	@RequestMapping(value="/employees", method = RequestMethod.GET)
	public  String listEmployees(ModelMap  map) 
	{
		List<Employee>   list=employeeDao.listEmployeess();
		
		map.addAttribute("employees",list);
		
		return "employeesList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee()
	{
		return new ModelAndView("addEmployee");
	}
	
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@RequestParam("id")int  empid,ModelMap  map)
	{
		
		employeeDao.deleteEmployee(empid);
		
		List<Employee>   list=employeeDao.listEmployeess();
		
		map.addAttribute("employees",list);
		
		return new ModelAndView("employeesList");
		
		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("id")int  empid) 
	{
			
		return new ModelAndView("editEmployee","eid",empid);
	}
	
}
