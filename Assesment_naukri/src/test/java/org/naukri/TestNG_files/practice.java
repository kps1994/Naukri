package org.naukri.TestNG_files;

public class practice {
	int a=4;
	int b= 5;
     int c;
	 void plus() {
	 c=a+b;
	System.out.println(c);
	}
	
//	public int plus() {
//		 c=a+b;
//		System.out.println(c);
//		return c;
//		}
	void mul() {
		int f= 7;
		int d= c*f;
		System.out.println(d);
	}
	public static void main(String[] args) {
practice p =new practice();
p.plus();
p.mul();
	}

}
