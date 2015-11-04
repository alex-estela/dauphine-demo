package cultureproduit.demo.vote;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class VoteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public Vote save(Vote vote) {
		entityManager.persist(vote);
		return vote;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Vote> findAll() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Vote e");
		    return (Collection<Vote>) query.getResultList();
		} 
		catch (PersistenceException e) {
			return null;
		}
	}

	
}
