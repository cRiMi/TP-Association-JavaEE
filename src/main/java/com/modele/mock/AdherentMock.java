
/*
 * Created on 3 oct. 2013 ( Time 15:16:11 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.modele.mock;

import java.util.LinkedList;
import java.util.List;

import com.modele.bean.Adherent;
import com.modele.mock.tool.MockValues;

public class AdherentMock {

	private MockValues mockValues = new MockValues();
	
	/**
	 * Creates an instance with random Primary Key
	 * @return
	 */
	public Adherent createInstance() {
		// Primary Key values

		return createInstance( mockValues.nextInteger() );
	}
	
	/**
	 * Creates an instance with a specific Primary Key
	 * @param id1
	 * @return
	 */
	public Adherent createInstance( int adId ) {
		Adherent entity = new Adherent();
		// Init Primary Key fields
		entity.setAdId( adId) ;
		// Init Data fields
		entity.setAdLogin( mockValues.nextString(255) ) ; // java.lang.String 
		entity.setAdPassword( mockValues.nextString(255) ) ; // java.lang.String 
		entity.setAdNom( mockValues.nextString(255) ) ; // java.lang.String 
		entity.setAdPrenom( mockValues.nextString(255) ) ; // java.lang.String 
		entity.setAdAdresse( mockValues.nextString(255) ) ; // java.lang.String 
		entity.setAdCodepostal( mockValues.nextString(255) ) ; // java.lang.String 
		entity.setAdVille( mockValues.nextString(255) ) ; // java.lang.String 
		// Init Link fields (if any)
		// setPays( TODO ) ; // Pays 
		return entity ;
	}
	
	/**
	 * Creates a list of instances
	 * @param count number of instances to be created
	 * @return
	 */
	public List<Adherent> createList(int count) {
		List<Adherent> list = new LinkedList<Adherent>();		
		for ( int i = 1 ; i <= count ; i++ ) {
			list.add( createInstance() );
		}
		return list;
	}
}