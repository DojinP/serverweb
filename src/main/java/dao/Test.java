package dao;

public class Test {

	public static void main(String[] args) {
		CustomerDAO obj = new CustomerDAOImpl();
		obj.login("bts", "bts1234");
	}

}
