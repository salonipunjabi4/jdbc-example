package JDBCExample.Controller;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import JDBCExample.model.Employee;
import JDBCExample.service.EmployeeService;
import JDBCExample.repository.DBRepository;

public class EmployeeController {
	EmployeeService es = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		EmployeeController ec = new EmployeeController();
		//ec.save();
		ec.fetchData();
		//ec.fetchById(101);
		//ec.delete(107);
		ec.update(new Employee(103, "Black", "black@gmail.com", 6789f));
		ec.fetchData();
		ec.closeConn();

	}
	
	public void fetchData() throws ClassNotFoundException, SQLException {
		es = new EmployeeService();
		List<Employee> list = es.fetchAll();
		
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Employee e = (Employee) itr.next();
			//System.out.println("Fetching data");
			System.out.println("id= " + e.getId() +", name= "+e.getName() + ", email= " + e.getEmail() + ", salary= " + e.getSalary());
		}
	}
	
	public void save() throws ClassNotFoundException, SQLException {
		es = new EmployeeService();
		boolean status = es.save(new Employee(107, "Black", "black@gmail.com", 12345f));
		if(status) {
			System.out.println("Employee record inserted successfully");
		} else {
			System.out.println("Error in the query");
		}
	}
	
	public void fetchById(Integer id) throws ClassNotFoundException, SQLException{
		es = new EmployeeService();
		Employee e = es.fetchById(id);
		System.out.println("id= " + e.getId() +", name= "+e.getName() + ", email= " + e.getEmail() + ", salary= " + e.getSalary());
		//System.out.println(e);
	}
	
	public void delete(Integer id) throws ClassNotFoundException, SQLException{
		es = new EmployeeService();
		boolean status = es.delete(id);
		if(status) {
			System.out.println("Employee with "+ id + " deleted successfully");
		} else {
			System.out.println("Error in the query");
		}
		
	}
	
	public void update(Employee e) throws ClassNotFoundException, SQLException{
		es = new EmployeeService();
		boolean status = es.update(e);
		if(status) {
			System.out.println("Employee with updated successfully");
		} else {
			System.out.println("Error in the query");
		}
		
		
	}
	
	public void closeConn() throws SQLException {
		DBRepository.closeConnection();
	}

}
