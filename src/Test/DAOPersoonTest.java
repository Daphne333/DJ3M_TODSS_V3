package Test;

import Model.domein.Persoon;
import dao.PersoonDAO;

public class DAOPersoonTest {
	
	public static void main(String[] args){
		PersoonDAO persoonDAO = new PersoonDAO();
		Persoon persoon = new Persoon();
		
		persoon = persoonDAO.getPersoonByID("test");
		System.out.println(persoon);
	}

}
