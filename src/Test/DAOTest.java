package Test;

import Model.domein.Persoon;
import dao.PersoonDAO;

public class DAOTest {
	
	
	public static void main(String[] args){
		PersoonDAO persoonDAO = new PersoonDAO();
		Persoon persoon = new Persoon();
		persoon.setAchternaam("Klaas");
		persoon.setNaam("Pietje");
		persoon.setBsnnummer(342423422);
		persoon.setUsername("piet_Jan@gmail.com");
		persoon.setPersonID(2);
		persoon.setPlaats("Utrecht");
		persoon.setPostcode("1242GD");
		persoon.setTelefoonnummer(0621343243);
		persoon.setToevoeging("De");
		persoon.setTussenvoegsel("fsdsdf");
		
		persoonDAO.create(persoon);
	}

}
