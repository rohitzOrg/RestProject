package com.org.navz.service;


public interface RestResponseService {

	public void writeToDatabase();
	
	public void ReadFromDatabase();
	
	public void readingRelationships();
	

	/*@PersistenceContext
	EntityManager em;
	
	@Transactional
	public List<RestTable> findAll() {
		Query query = em.createNamedQuery(
				"select * from [RestServices].[dbo].[rest_table]", RestTable.class);
		return query.getResultList();
	}*/
}
