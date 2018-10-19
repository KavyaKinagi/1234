package xyz;

import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		int n;
		System.out.println("enter");
		Scanner s = new Scanner(System.in);
		n= s.nextInt(); 
		int a[]=new int[n];  //making array size as the size given by user
		
		
		for ( int i=0;i<n;i++)
		{
			System.out.print(i+" ");
		}
		
		
		

	}

}
