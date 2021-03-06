/*
 * Created on 7 oct. 2013 ( Time 08:51:45 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.model.persistence.services.fake;

import java.util.List;
import java.util.Map;

import com.model.bean.Article ;
import com.model.persistence.commons.fake.GenericFakeService;
import com.model.persistence.services.ArticlePersistence;

/**
 * Fake persistence service implementation ( entity "Article" )
 *
 * @author Telosys Tools Generator
 */
public class ArticlePersistenceFAKE extends GenericFakeService<Article> implements ArticlePersistence {

	public ArticlePersistenceFAKE () {
		super(Article.class);
	}
	
	protected Article buildEntity(int index) {
		Article entity = new Article();
		// Init fields with mock values
		entity.setArId( nextInteger() ) ;
		entity.setArCode( nextString() ) ;
		entity.setArNom( nextString() ) ;
		entity.setArPrix( nextInteger() ) ;
		entity.setArStock( nextInteger() ) ;
		return entity ;
	}
	
	
	public boolean delete(Article entity) {
		log("delete ( Article : " + entity + ")" ) ;
		return true;
	}

	public boolean delete( int arId ) {
		log("delete ( PK )") ;
		return true;
	}

	public void insert(Article entity) {
		log("insert ( Article : " + entity + ")" ) ;
	}

	public Article load( int arId ) {
		log("load ( PK )") ;
		return buildEntity(1) ; 
	}

	public List<Article> loadAll() {
		log("loadAll()") ;
		return buildList(40) ;
	}

	public List<Article> loadByNamedQuery(String queryName) {
		log("loadByNamedQuery ( '" + queryName + "' )") ;
		return buildList(20) ;
	}

	public List<Article> loadByNamedQuery(String queryName, Map<String, Object> queryParameters) {
		log("loadByNamedQuery ( '" + queryName + "', parameters )") ;
		return buildList(10) ;
	}

	public Article save(Article entity) {
		log("insert ( Article : " + entity + ")" ) ;
		return entity;
	}

	public List<Article> search(Map<String, Object> criteria) {
		log("search (criteria)" ) ;
		return buildList(15) ;
	}

}
