/*
 * Created on 7 oct. 2013 ( Time 08:51:45 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.model.test.persistence;


import com.model.bean.Pays ;
import com.model.mock.PaysMock;
import com.model.persistence.PersistenceServiceProvider;
import com.model.persistence.services.PaysPersistence;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test case for Pays persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class PaysPersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test Pays persistence : delete + load ..." );
		
		PaysPersistence service = PersistenceServiceProvider.getService(PaysPersistence.class);
		
		PaysMock mock = new PaysMock();
		
		// TODO : set primary key values here 
		process( service, mock, 1  );
		// process( service, mock, ... );
	}

	private void process(PaysPersistence service, PaysMock mock, int paId ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		Pays entity = service.load( paId );
		if ( entity != null ) {
			// Found 
			System.out.println("   FOUND : " + entity );
			
			// Save (update) with the same values to avoid database integrity errors  
			System.out.println(" . save : " + entity );
			service.save(entity);
			System.out.println("   saved : " + entity );
		}
		else {
			// Not found 
			System.out.println("   NOT FOUND" );
			// Create a new instance 
			entity = mock.createInstance( paId ) ;
			Assert.assertNotNull(entity);

			// No reference : insert is possible 
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );

			System.out.println(" . delete : " );
			boolean deleted = service.delete( paId );
			System.out.println("   deleted = " + deleted);
			Assert.assertTrue(deleted) ;
		}		
	}
}
