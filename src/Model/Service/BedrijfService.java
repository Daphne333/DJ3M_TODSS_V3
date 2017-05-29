package Model.Service;

import java.util.List;

import Model.domein.Bedrijf;
import Model.domein.Persoon;
import dao.BedrijfDAO;

public class BedrijfService {
	BedrijfDAO dao = new BedrijfDAO();
	
	public List<Bedrijf> getBedrijven(){
		return dao.getListBedrijven();
	}
	public Bedrijf getBedrijfBijNaam(String naam){
		return dao.getBedrijfBijNaam(naam);
	}

}

