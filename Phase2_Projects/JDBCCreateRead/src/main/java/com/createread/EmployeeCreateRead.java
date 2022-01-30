package com.createread;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.EmployeeBean;
import com.dbconnection.DBConnection;

public class EmployeeCreateRead {

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
	
}
