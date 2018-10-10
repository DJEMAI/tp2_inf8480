package Persistence;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Departement;
import Model.Equipe;
public class PersEquipe {

	private static EntityManagerFactory managerFactory = null;
	private static EntityManager manager = null;

	public void setUp () {
		if (managerFactory == null) 
			managerFactory = Persistence.
					createEntityManagerFactory("TP5");
		
		if (manager == null) 
			manager = managerFactory.createEntityManager();
		
	}

	public Equipe read (String matricule) {
		return manager.find(Equipe.class, matricule);
	}
	public List<Equipe> selectAll() {
		Query query = manager.createQuery("select e from Equipe e");
		return query.getResultList();
	}
	public List<Equipe> selectAllOnDepartement(String departement) {
		Query query = manager.createQuery("select e from Equipe e where departement ='"+departement+"'");
		return query.getResultList();
	}
	public void update(Equipe equipe) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(equipe);
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
