package co.edu.eafit.jsrules.property;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * This class allows to work with the Properties Entity.
 * @author Sebastian Velez
 * @author Julian Ortega
 *
 */
public class PropertyFacade {

	/**
	 * This method saves a property in to the database.
	 * Preconditions: The property is not null.
	 * Postconditions: The value of the property is updated.
	 * @param p Property to update/save.
	 * @throws Exception in case of error connecting to the database.
	 */
	public void saveProperty(Property p) throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = factory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(p);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			em.close();
			throw e;
		} 
		em.close();
	}
	
	/**
	 * Gets the property with the given key.
	 * @param key key of the property to get.
	 * @return the property.
	 */
	public Property getPropertyByKey(Integer key) throws Exception {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("Select p from Property p where p.propertyKey = :propertyKey");
		q.setParameter("propertyKey", key);
		return (Property) q.getSingleResult();
	}
	
}
