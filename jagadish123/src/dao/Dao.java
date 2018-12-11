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
	ArrayList<Customer> alist = new ArrayList<Customer>();
	public ArrayList<Customer> viewdetails() {
		try {
			con = DatabaseUtil.getConnection();
			ps = con.prepareStatement("select * from Customer1");
			rs = ps.executeQuery();
			while(rs.next())
			{
				Customer c = new Customer(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getInt(4));
				//Customer c = new Customer();
				//c.setName(rs.getString(1));
				//c.setAge(rs.getInt(2));
				//c.setGender(rs.getString(3));
               //c.setPhone(rs.getInt(4));
				alist.add(c);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alist;
	}
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
	
}
