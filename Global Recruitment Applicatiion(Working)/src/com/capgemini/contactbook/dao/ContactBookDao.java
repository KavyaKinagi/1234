package com.capgemini.contactbook.dao;

import com.capgemini.exception.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;

public interface ContactBookDao {

	public int addEnquiry(EnquiryBean enqry) throws ContactBookException;
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException;
	
}
