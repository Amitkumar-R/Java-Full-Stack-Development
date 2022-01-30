package com.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.EmployeeBean;
import com.dbconnection.DBConnection;

public class EmployeeCRUD {
	
	// Inserting data into database
	public static int insert(EmployeeBean eb) {
		int status = 0;
		
		try {
			Connection conn = DBConnection.dbConn();
			PreparedStatement ps = conn.prepareStatement
					("insert into Employee(name, password, email) values(?,?,?)");
			ps.setString(1, eb.getName());
			ps.setString(2, eb.getPassword());
			ps.setString(3, eb.getEmail());
			
			status = ps.executeUpdate();
			conn.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
		
	}
	
	// Retrieving the data from database
	public static List<EmployeeBean> retrieve() {
		List<EmployeeBean> listEmp = new ArrayList<EmployeeBean>();
		
		try {
			Connection conn = DBConnection.dbConn();
			PreparedStatement ps = conn.prepareStatement("select * from Employee");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				EmployeeBean empBean = new EmployeeBean();
				empBean.setId(rs.getInt(1));
				empBean.setName(rs.getString(2));
				empBean.setPassword(rs.getString(3));
				empBean.setEmail(rs.getString(4));
				listEmp.add(empBean);
			}
			conn.close();
		} catch(Exception e) {
			System.out.println(e);
		}
		return listEmp;
	}
	
	// Deleting data from database
	public static int delete(int id) {
		int status = 0;
		
		try {
			Connection conn = DBConnection.dbConn();
			PreparedStatement ps = conn.prepareStatement("delete from Employee where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	// Updating the data into the database
	public static int edit(EmployeeBean eb) {
		int status = 0;
		
		try {
			Connection conn = DBConnection.dbConn();
			PreparedStatement ps = conn.prepareStatement
					("update Employee set name=?, password=?, email=?");
			ps.setString(1, eb.getName());
			ps.setString(2, eb.getPassword());
			ps.setString(3, eb.getEmail());
			ps.setInt(4, eb.getId());
			
			status = ps.executeUpdate();
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
