/*
 * Created on 7 oct. 2013 ( Time 08:51:45 )
 * Generated by Telosys Tools Generator ( version 2.0.6 )
 */
package com.model.test.persistence;


import com.model.bean.Article;
import com.model.mock.ArticleMock;
import com.model.persistence.PersistenceServiceProvider;
import com.model.persistence.services.ArticlePersistence;
import junit.framework.Assert;
import org.junit.Test;


/**
 * JUnit test case for Article persistence service
 * 
 * @author Telosys Tools Generator
 *
 */
public class ArticlePersistenceTest 
{
	@Test
	public void test1() {
		
		System.out.println("Test Article persistence : delete + load ..." );
		
		ArticlePersistence service = PersistenceServiceProvider.getService(ArticlePersistence.class);
		
		ArticleMock mock = new ArticleMock();
		
		// TODO : set primary key values here 
		process( service, mock, 1  );
		// process( service, mock, ... );
	}

	private void process(ArticlePersistence service, ArticleMock mock, int arId ) {
		System.out.println("----- "  );
		System.out.println(" . load : " );
		Article entity = service.load( arId );
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
			entity = mock.createInstance( arId ) ;
			Assert.assertNotNull(entity);

			// No reference : insert is possible 
			// Try to insert the new instance
			System.out.println(" . insert : " + entity );
			service.insert(entity);
			System.out.println("   inserted : " + entity );

			System.out.println(" . delete : " );
			boolean deleted = service.delete( arId );
			System.out.println("   deleted = " + deleted);
			Assert.assertTrue(deleted) ;
		}		
	}
}
