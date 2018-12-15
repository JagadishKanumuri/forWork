package service;

import java.util.ArrayList;

import bean.Customer;
import dao.Dao;

public class Service {
	Dao d = new Dao();
	public ArrayList<Customer> viewdetails() {
		return d.viewdetails();
	}
	public int insert(Customer c) {
		return d.insert(c);
	}
	public int delete(String name) {
		return d.delete(name);
	}
	public int update(Customer c) {
		return d.update(c);
	}
	public ArrayList<Customer> search(String name) {
		return d.search(name);
	}
}
