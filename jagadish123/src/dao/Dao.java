package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Customer;
import util.DatabaseUtil;

public class Dao {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//Viewing All Customers in PG
	ArrayList<Customer> alist = new ArrayList<Customer>();
	public ArrayList<Customer> viewdetails() {
		try {
			con = DatabaseUtil.getConnection();
			ps = con.prepareStatement("select * from Customer1");
			rs = ps.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
				alist.add(c);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alist;
	}
	
	//Registration in PG
	public int insert(Customer c) {
		int i =0;
		try {
			con = DatabaseUtil.getConnection();
			ps = con.prepareStatement("insert into Customer1 values(?,?,?,?)");
			ps.setString(1, c.getName());
			ps.setInt(2, c.getAge());
			ps.setString(3, c.getGender());
			ps.setInt(4, c.getPhone());
			 i = ps.executeUpdate();
			if(i>0)
			{
				return 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	{
		
	}
	//Deleting of Customer from PG
	public int delete(String name) {
		int i =0;
		try {
			con = DatabaseUtil.getConnection();
			ps = con.prepareStatement("delete from Customer1 where name=?");
			ps.setString(1, name);
			 i= ps.executeUpdate();
			if(i>0)
			{
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//Updating Customer Details in PG
	public int update(Customer c) {
		int i =0;
		try {
			con = DatabaseUtil.getConnection();
			ps = con.prepareStatement("update Customer1 set age=? ,gender=?, phone=? where name=?");
			ps.setInt(1, c.getAge());
			ps.setString(2, c.getGender());
			ps.setInt(3, c.getPhone());
			ps.setString(4, c.getName());
			i = ps.executeUpdate();
			if(i>0)
			{
				return 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	//Searching Customer Details by Name
	public ArrayList<Customer> search(String name)
	
	{
		ArrayList<Customer> alist = new ArrayList<Customer>();
		try {
			con = DatabaseUtil.getConnection();
			ps = con.prepareStatement("select * from Customer1 where name=?");
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
				alist.add(c);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alist;
	
	}
		
	
}
