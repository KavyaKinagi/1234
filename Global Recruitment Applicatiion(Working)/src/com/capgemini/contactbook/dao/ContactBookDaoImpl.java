package com.capgemini.contactbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


import com.capgemini.exception.ContactBookException;
import com.capgemini.utils.DBUtils;
import com.capgemini.utils.Log4jHTMLLayout;
import com.igate.contactbook.bean.EnquiryBean;

public class ContactBookDaoImpl implements ContactBookDao {

	
private static Logger log = Logger.getLogger(Log4jHTMLLayout.class);
	
	private Connection dbConnection;

	{
		try {
			dbConnection = DBUtils.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int generateNextOrderId() throws SQLException {
		int id = 0;

		String selectQuery = "select enquiries.nextval from dual";

		Statement selectStatement = dbConnection.createStatement();
		ResultSet result = selectStatement.executeQuery(selectQuery);

		result.next();

		id = result.getInt(1);
		return id;
	}

	//implemented Methods
	
	@Override
	public int addEnquiry(EnquiryBean enqry) throws ContactBookException {
		
		String insertQuery = "insert into enquiry values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement insertStatement = dbConnection.prepareStatement(insertQuery);
			
			insertStatement.setInt(1, generateNextOrderId());
			
			insertStatement.setString(2, enqry.getfName());
			
			insertStatement.setString(3, enqry.getlName());
			
			insertStatement.setString(4, enqry.getContactNo());
			
			insertStatement.setString(5, enqry.getpDomain());
			
			insertStatement.setString(6, enqry.getpLocation());
			
			int rows = insertStatement.executeUpdate();
			
			if(rows>0){
				System.out.println("New Enquiry Added..");
				log.info("New Enquiry is Added");
				return 1;
			}
			else 
				return 0;
				
		} catch (SQLException e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			return 0;
		}
		
		
	}

	
	
	
	@Override
	public EnquiryBean getEnquiryDetails(int EnquiryID) throws ContactBookException {
		
		String selectQuery = "select * from enquiry where enqryId = ?";
		
		try{
		
		PreparedStatement selectStatement = dbConnection.prepareStatement(selectQuery);
		
		selectStatement.setInt(1, EnquiryID);
		
		ResultSet result = selectStatement.executeQuery();
		
		while (result.next()) {
			
			int enqryid = result.getInt(1);
			
			String fname = result.getString(2);
			
			String lname = result.getString(3);
			
			String contactNo = result.getString(4);
			
			String domain = result.getString(5);
			
			String location = result.getString(6);
			
			EnquiryBean enquiry = new EnquiryBean();
			enquiry.setEnqryid(enqryid);
			enquiry.setfName(fname);
			enquiry.setlName(lname);
			enquiry.setContactNo(contactNo);
			enquiry.setpDomain(domain);
			enquiry.setpLocation(location);
			
			return enquiry;
			
		}
		
		} catch(SQLException e){
			
			e.printStackTrace();
			
			throw new ContactBookException("Enquiry not found",e);
		}
		
		return null;
	}
	
	
	
	
	
	
	
}
