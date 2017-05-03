package dao;

import domeinBackup.Persoon;

public class main {

	public static void main(String[] args) {
		PersoonDAO dao = new PersoonDAO();
		Persoon persoon = new Persoon();
		dao.create(persoon);
	}

}
