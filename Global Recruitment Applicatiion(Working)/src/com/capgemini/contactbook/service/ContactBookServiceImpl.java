package com.capgemini.contactbook.service;

import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.exception.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookServiceImpl implements ContactBookService {

	ContactBookDao cbd= new ContactBookDaoImpl();
	
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException {
		
		return cbd.addEnquiry(enqry);
	}

	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException {
		
		return cbd.getEnquiryDetails(EnquiryID);
	}

	@Override
	public boolean isValidEnquiry(EnquiryBean enqry) throws ContactBookException {
	
 	    if(!enqry.getContactNo().matches("[0-9]{10}")){
 	    	throw new ContactBookException("Contact numner must be of 10 Digits..", null);
 	    }
 	    
 	    if(enqry.getfName()==null||enqry.getpLocation()==null||enqry.getpDomain()==null){
 	    	throw new ContactBookException("First name, Domain Name , Loaction must be filled.", null);
 	    }
		return true;
	}

	
	
	
}
