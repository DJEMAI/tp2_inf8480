package Persistence;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Departement;
public class PersDepartement {

	private static EntityManagerFactory managerFactory = null;
	private static EntityManager manager = null;

	public void setUp () {
		if (managerFactory == null) {
			managerFactory = Persistence.
					createEntityManagerFactory("TP5");
		}
		if (manager == null) {
			manager = managerFactory.createEntityManager();
		}
	}

	public Departement read (String matricule) {
		return manager.find(Departement.class, matricule);
	}
	public List<Departement> selectAll() {
		Query query = manager.createQuery("select d from Departement d");
		return query.getResultList();
	}
	public void update(Departement departement) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(departement);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
	}
	
	public void close() {
		manager.close();
		managerFactory.close();
	}

}
