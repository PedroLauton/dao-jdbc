package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.Id = department.Id WHERE seller.Id = ?");
			ps.setInt(1, 1);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Department dp = new Department();
				dp.setId(rs.getInt("DepartmentId"));
				dp.setName(rs.getString("DepName"));
				
				Seller sl = new Seller();
				sl.setId(rs.getInt("Id"));
				sl.setName(rs.getString("Name"));
				sl.setEmail(rs.getString("Email"));
				sl.setBirthDate(rs.getDate("BirthDate"));
				sl.setBaseSalary(rs.getDouble("BaseSalary"));
				sl.setDepartment(dp);
				
				return sl;
			}else {
				return null;
			}
			
		} catch(SQLException e) {
			throw new DbException("Erro na consulta Por Id"); 
		} finally{
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
