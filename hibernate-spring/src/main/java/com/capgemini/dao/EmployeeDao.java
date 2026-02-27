package com.capgemini.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.Employee;
import com.capgemini.main.JpaUtil;

/*
//mostly used for dao classes but work same as component
@Repository
public class EmployeeDao {
	
	@Autowired
	JpaUtil jpa;
	
	//need ref of entitymanager
//	@Autowired
//	EntityManager entityManager;
	
	EntityManager em=jpa.getEntityManager();
	public void insert(Employee e) {
		
//		entityManager.getTransaction().begin();
		em.getTransaction().begin();
		Employee employee=findById(e.getId());
		
		if(employee==null) {
//			entityManager.persist(e);
			em.persist(e);
		}else {
			System.out.println("Data Exist");
		}
		
//		entityManager.getTransaction().commit();
		em.getTransaction().commit();
	}
	
	
	public Employee findById(int id) {
//		return entityManager.find(Employee.class, id);
		return em.find(Employee.class, id);
	}
	public void delete(int id) {
//	    entityManager.getTransaction().begin();
//	    Employee emp = entityManager.find(Employee.class, id);
//
//	    if (emp != null) {
//	        entityManager.remove(emp);
//	        System.out.println("Employee deleted successfully!");
//	    } else {
//	        System.out.println("Employee not found!");
//	    }
//
//	    entityManager.getTransaction().commit();
		
		  em.getTransaction().begin();
		    Employee emp = em.find(Employee.class, id);

		    if (emp != null) {
		        em.remove(emp);
		        System.out.println("Employee deleted successfully!");
		    } else {
		        System.out.println("Employee not found!");
		    }

		    em.getTransaction().commit();
	}
	
	public void update(Employee e) {
//	    entityManager.getTransaction().begin();
//
//	    Employee emp = entityManager.find(Employee.class, e.getId());
		
		em.getTransaction().begin();

		    Employee emp = em.find(Employee.class, e.getId());
		    
	    if (emp != null) {
	        emp.setName(e.getName());
	        emp.setSalary(e.getSalary());
	        System.out.println("Employee updated successfully!");
	    } else {
	        System.out.println("Employee not found!");
	    }

//	    entityManager.getTransaction().commit();
	    em.getTransaction().commit();
	}
	
	public List<Employee> findAll() {
//	    return entityManager
//	            .createQuery("SELECT e FROM Employee e", Employee.class)
//	            .getResultList();
		   return em
		            .createQuery("SELECT e FROM Employee e", Employee.class)
		            .getResultList();
	}
	
}
*/

@Repository
public class EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    JpaUtil jpa;

    EntityManager em;   // only declaration

    @PostConstruct
    public void init() {
        em = jpa.getEntityManager();   // safe here
    }

    // INSERT
    public void insertEmp(Employee e) {

        em.getTransaction().begin();
        Employee existing = find(e.getId());
        em.getTransaction().commit();
    }

    // FIND
    public Employee find(int id) {
        return entityManager.find(Employee.class, id);
    }

    // DELETE
    public void del(int id) {

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Employee e = find(id);

        if (e != null) {
            entityManager.remove(e);
            System.out.println("Employee deleted");
        } else {
            System.out.println("Employee not found");
        }

        tx.commit();
    }

    // UPDATE
    public void update(Employee updatedEmp) {

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Employee existing = find(updatedEmp.getId());

        if (existing != null) {
            existing.setName(updatedEmp.getName());
            existing.setSalary(updatedEmp.getSalary());

            entityManager.merge(existing);
            System.out.println("Employee updated");
        } else {
            System.out.println("Employee not found");
        }

        tx.commit();
    }
}
