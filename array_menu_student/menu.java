package xyz;

import java.util.Scanner;

public class menu {

public static void main(String[] args) {
	int choice;
	Scanner sc= new Scanner(System.in);
	while(true)
	{
		System.out.println("Enter choice");
		System.out.println("1. Add");
		System.out.println("2.Sub");
		System.out.println("3.Mul");
		System.out.println("4.Div");
		System.out.println("5.Exit");
		choice= sc.nextInt();
		
		switch(choice)
		{
		case 1: Scanner s = new Scanner (System.in);
		 Scanner s1 = new Scanner (System.in);
		      int c= sc.nextInt();
		      int d= sc.nextInt();
		        System.out.println(c+d);
		        break; 
		        
		case 2: Scanner p = new Scanner (System.in);
		 Scanner s2 = new Scanner (System.in);
		      int a= sc.nextInt();
		      int b= sc.nextInt();
		        System.out.println(a-b);
		        break; 
		case 3: Scanner q = new Scanner (System.in);
		 Scanner s3 = new Scanner (System.in);
		      int e= sc.nextInt();
		      int f= sc.nextInt();
		        System.out.println(e*f);
		        break; 
		case 4: Scanner r = new Scanner (System.in);
		 Scanner s4 = new Scanner (System.in);
		      int g= sc.nextInt();
		      int h= sc.nextInt();
		      float i = (float) g/h;
		        System.out.println(i);
		        break; 
		case 5:System.exit(0);
		}
	}
}
}
		
