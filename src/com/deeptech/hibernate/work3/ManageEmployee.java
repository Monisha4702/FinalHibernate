package com.deeptech.hibernate.work3;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee 
{
	private static SessionFactory sf;
	
	public static void main(String[] args) 
	{
		try
		{
			sf=new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        
		//creating objects
		ManageEmployee Me = new ManageEmployee();
		Integer emp1=Me.addEmployee("Monisha" ,"N","Developer",30000);
		Integer emp2=Me.addEmployee("Anusha" ,"N","Test Engineer",35000);
		Integer emp3=Me.addEmployee("Rakshitha" ,"k","Developer",30000);
		Integer emp4=Me.addEmployee("Akshitha" ,"H","Developer",30000);
	    Me.listEmployee();
	    Me.updateEmployee(emp3,50000);
	}
	
	public void deleteEmployee(Integer emp)
	{
		Session s = sf.openSession();
		Transaction tx = null;
		try
		{
			tx = s.beginTransaction();
			Employee empdata = s.get(Employee.class, emp);
			s.delete(empdata);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void updateEmployee(Integer e1,double sal)
	{
		Session s = sf.openSession();
		Transaction tx = null;
		try
		{
			
			tx = s.beginTransaction();
			Employee emp = s.get(Employee.class, e1);
			emp.setSalary(sal);
			s.update(emp);
			tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
		
	public void listEmployee()
	{
		Session s = sf.openSession();
		Transaction tx = null;
		
		try
		{
			tx = s.beginTransaction();
			Query q = s.createQuery("from Employee");
			List<Employee> e = q.list();
			for(Employee emp :e)
			{
				System.out.println(emp.getFirstname()+"\t"+emp.getLastname()+"\t"+emp.getDesignation()+"\t"+emp.getSalary());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public Integer addEmployee(String fname,String lname,String desig ,double salary )
	{
		Session s=sf.openSession();
		Transaction tsc=null;
		Integer employeeID = null;
		try
		{
			tsc=s.beginTransaction();
			Employee emp=new Employee();
			emp.setFirstname(fname);
			emp.setLastname(lname);
			emp.setDesignation(desig);
			emp.setSalary(salary);
			employeeID=(Integer) s.save(emp);
			System.out.println("Record inserted successfully");
			tsc.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return employeeID;
	}

}
