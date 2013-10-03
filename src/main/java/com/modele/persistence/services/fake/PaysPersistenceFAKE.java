/*
 * Created on 3 oct. 2013 ( Time 15:16:11 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.modele.persistence.services.fake;

import java.util.List;
import java.util.Map;

import com.modele.bean.Pays;
import com.modele.persistence.commons.fake.GenericFakeService;
import com.modele.persistence.services.PaysPersistence;

/**
 * Fake persistence service implementation ( entity "Pays" )
 *
 * @author Telosys Tools Generator
 */
public class PaysPersistenceFAKE extends GenericFakeService<Pays> implements PaysPersistence {

	public PaysPersistenceFAKE () {
		super(Pays.class);
	}
	
	protected Pays buildEntity(int index) {
		Pays entity = new Pays();
		// Init fields with mock values
		entity.setPaId( nextInteger() ) ;
		entity.setPaCode( nextString() ) ;
		entity.setPaNom( nextString() ) ;
		return entity ;
	}
	
	
	public boolean delete(Pays entity) {
		log("delete ( Pays : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( int paId ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(Pays entity) {
		log("insert ( Pays : " + entity + ")" ) ;
	}

	public Pays load( int paId ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<Pays> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<Pays> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<Pays> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public Pays save(Pays entity) {
		log("insert ( Pays : " + entity + ")" ) ;
		return entity;
	}

	public List<Pays> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

}