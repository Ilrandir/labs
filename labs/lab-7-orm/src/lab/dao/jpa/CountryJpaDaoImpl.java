package lab.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lab.dao.CountryDao;
import lab.model.Country;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(Country.class);
		em.getTransaction().commit();

		if (em != null) {
			em.close();
		}
	}

	@Override
	public List<Country> getAllCountries() {
		List<Country> countryList = null;
		EntityManager em = emf.createEntityManager();
		countryList = em.createQuery("from Country", Country.class).getResultList();

		if (em != null) {
			em.close();
		}
	
	return countryList;
		
	}// getAllcountries()

	@Override
	public Country getCountryByName(String name) {
//		TODO: Implement it

		return null;
	}

}
