
public class MyThread extends Thread {

	public static void main(String[] args) {
		Thread t= Thread.currentThread();
		
		System.out.println("Current name" +" " + t.getName());
		
		t.setName("kav");
		System.out.println("Updated name"+ " "+ t.getName());
		
		System.out.println("priority" + " "+ t.getPriority());
		
		t.setPriority(6);
		System.out.println("new priority"+ " "+ t.getPriority());

		
		for(int i=0;i<5;i++)
		{
			System.out.println("Main Thread");
		}
		
		ChildThread ct= new ChildThread();
		System.out.println("Child thread" + ct.getPriority());
	}

}
