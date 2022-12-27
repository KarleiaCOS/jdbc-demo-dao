package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department objDepartment) {
		PreparedStatement ps = null;
		try {
		ps = conn.prepareStatement(
				"INSERT INTO department "
				+ "(Id, Name) "
				+ "VALUES "
				+ "(?, ?)",
				Statement.RETURN_GENERATED_KEYS);
				
			ps.setInt(1, objDepartment.getId());
			ps.setString(2, objDepartment.getName());
			
			int rowsAffected = ps.executeUpdate();
					if (rowsAffected > 0) {
						ResultSet rs = ps.getGeneratedKeys();
							if(rs.next()) {
								int id = rs.getInt(1);
								objDepartment.setId(id);
							}	
						DB.closeResultSet(rs);
					}
					else {
						throw new DbException("Inexpected error! No rows affected!");
					}
				}
				catch (SQLException e) {
					throw new DbException(e.getMessage());
				}
				finally {
					DB.closeStatement(ps);
				}
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
