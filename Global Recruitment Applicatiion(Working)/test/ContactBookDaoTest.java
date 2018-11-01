import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.exception.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookDaoTest {

	private ContactBookDao daoRef;
	
	@Before
	public void setup(){
		System.out.println("DAO instantiated");
		daoRef = new ContactBookDaoImpl();
	}
	
	@After
	public void tearDown(){
		System.out.println("DAO cleaned");
		daoRef = null;
	}
	
	
	@Test
	public void addEnquiry() throws ContactBookException{
		
		EnquiryBean en = new EnquiryBean();
		
		boolean flag=true;
		int bool = daoRef.addEnquiry(en);
		if(bool==0){
			flag=false;
		}
	   Assert.assertTrue(flag);
		
	}
	
	
	
	
	
	@Test
	public void getEnquiryDetails() throws ContactBookException{
		
		int id = 1001;
		EnquiryBean en = daoRef.getEnquiryDetails(id) ;
		
		Assert.assertNotNull(en);
		Assert.assertEquals(id, en.getEnqryid());
	}
}
	
