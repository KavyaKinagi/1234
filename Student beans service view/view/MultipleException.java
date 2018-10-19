package com.capgemini.view;

public class MultipleException {

	public static void main(String[] args) {
		 int a=0;
		 int b=9;
		 
		 
		 try
		 {
			 float c=(float)a/b;
			 System.out.println("result is:" + c);
			// System.out.println("last");
		 }
		 catch(ArithmeticException ae)
		 {
			 System.out.println("cannot divide by zero");
		 }
	}

}
