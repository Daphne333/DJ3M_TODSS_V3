package Test;

import java.util.List;

import Model.Service.PersoonService;
import Model.domein.FunctieRol;
import Model.domein.Persoon;

public class TestPersoonDAO {
	public static void main(String[] args) {
		PersoonService persoonService = new PersoonService();
		FunctieRol rol = FunctieRol.CURSIST;
		List<Persoon> allePersonen = persoonService.getManagersBijBedrijf("HU");
		for (Persoon pers : allePersonen) {
			if(pers != null){
			System.out.println(pers.getNaam());
			} else {
				System.out.println("er is een nullpointer.");
				break;
			}
		}
	}
}
