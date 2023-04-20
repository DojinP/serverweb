package basic;

abstract class A{
	abstract void print();
}

class SubA extends A{
	@Override
	void print() {
		System.out.println("subA");
	}
}
class SubB extends A{
	@Override
	void print() {
		System.out.println("subB");
	}
}

public class Test {
	public static void run(A obj){
		obj.print();
	}
	public static void main(String[] args) {
		A obj = new SubA();
		run(obj);
		A obj2 = new SubB();
		run(obj2);
	}
}
