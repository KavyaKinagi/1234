package com.capgemini.contactbook.ui;
import java.util.Scanner;

import com.capgemini.contactbook.dao.ContactBookDao;
import com.capgemini.contactbook.dao.ContactBookDaoImpl;
import com.capgemini.contactbook.service.ContactBookService;
import com.capgemini.contactbook.service.ContactBookServiceImpl;
import com.capgemini.exception.ContactBookException;
import com.igate.contactbook.bean.EnquiryBean;
public class Client {

	public static void main(String[] args) throws ContactBookException {
		
		ContactBookService cbs = new ContactBookServiceImpl();
		Scanner sc = new Scanner(System.in);
		ContactBookDao daoRef = new ContactBookDaoImpl();
		EnquiryBean en = new EnquiryBean();
		do
		{
		System.out.println("***************Global Recruitments*************");
		System.out.println(" ");
		System.out.println("Choose an operation");
		System.out.println("1. Enter Enquiry Details");
		System.out.println("2.View Enquiry Details on ID");
		System.out.println("0.Exit");
		System.out.println(" ");
		System.out.println("***********************************************");
		
		
int choice=sc.nextInt();
		
		switch(choice){
		
		
		case 1: 
			
			
			
			System.out.println("Enter First Name: ");
			en.setfName(sc.next());
			
			System.out.println("Enter Last Name: ");
			en.setlName(sc.next());
			
			System.out.println("Enter Contact Number: ");
			en.setContactNo(sc.next());
			
			System.out.println("Enter Prefered Domain: ");
			en.setpDomain(sc.next());
			
			System.out.println("Enter Preffered Location: ");
			en.setpLocation(sc.next());
			
			try{
				if(cbs.isValidEnquiry(en)){
					System.out.println("Thank You "+en.getfName()+" "+en.getlName()+" your Unique id is "+en.getEnqryid()+
							" we will contact You Shortly");
					daoRef.addEnquiry(en);
				}
				
			}catch(ContactBookException e){
				e.printStackTrace();
				System.out.println("Please try Again");
			}
			
			
			
			
			
			
			
			
			/*System.out.println("Thank You "+en.getfName()+" "+en.getlName()+" your Unique id is "+en.getEnqryid()+
					" we will contact You Shortly");*/
			
			
			
			
			
			/*cbs.isValidEnquiry(enqry);*/
			
			break;
			
			
		case 2:
			System.out.println("Enter id to Enquiry No. ");
			daoRef = new ContactBookDaoImpl();
			
			int id= sc.nextInt();
			
			en = daoRef.getEnquiryDetails(id);
			
			System.out.println("Id: "+en.getEnqryid()+
					"\nFirst Name: "+en.getfName()+
					"\nLast Name: "+en.getlName()+
					"\n Contact NO: "+en.getContactNo()+
					"\nPrefered Domain: "+en.getpDomain()+
					"\nPrefered location: "+en.getpLocation());
			
			break;
			
			
		case 0:System.out.println("Thank You..");
        System.exit(0);
        
        break;
        
		default: System.out.println("Invalid Choice..Try Again..!!");
        
			
		
		}
		
		}while(true);
		
		
		
		

	}

}
