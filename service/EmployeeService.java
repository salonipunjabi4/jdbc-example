package JDBCExample.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCExample.model.Employee;
import JDBCExample.repository.DBRepository;

public class EmployeeService {
	
	public List<Employee> fetchAll() throws ClassNotFoundException, SQLException {
		Connection conn = DBRepository.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from employee");
		
		ResultSet rs = ps.executeQuery();
		
		List<Employee> list = new ArrayList<>();
		while(rs.next()) {
			Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
			list.add(e);
		}
		
	return list;
	}
	
	public boolean save(Employee e) throws ClassNotFoundException, SQLException {
		Connection conn = DBRepository.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into employee(id, name, email, salary) values(?,?,?,?)");
		//? - placeholder
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getEmail());
		ps.setFloat(4, e.getSalary());
		int x = ps.executeUpdate();
		if(x > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public Employee fetchById(Integer id) throws ClassNotFoundException, SQLException {
		Connection conn = DBRepository.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from employee where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		
		Employee e = null;
		
		
		
		if(rs.next()) {
			e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
		}
		return e;
		
	}
	
	public boolean delete(Integer id) throws SQLException, ClassNotFoundException {
		Connection conn = DBRepository.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete from employee where id=?");
		ps.setInt(1, id);
		int x = ps.executeUpdate();
		if(x>0) {
			return true;
		} else {
			return false;
		}

	}
	
	public boolean update(Employee e) throws SQLException, ClassNotFoundException {
		Connection conn = DBRepository.getConnection();
		PreparedStatement ps = conn.prepareStatement("update employee set name = ?, email = ?, salary = ? where id=?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getEmail());
		ps.setFloat(3, e.getSalary());
		ps.setInt(4, e.getId());
		int x = ps.executeUpdate();
		if(x>0) {
			return true;
		} else {
			return false;
		}

	}
	
	
	
	

}
