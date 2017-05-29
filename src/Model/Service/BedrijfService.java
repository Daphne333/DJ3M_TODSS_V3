package Model.Service;

import java.util.List;

import Model.domein.Bedrijf;
import dao.BedrijfDAO;

public class BedrijfService {
	BedrijfDAO dao = new BedrijfDAO();
	
	public void maakBedrijfAan(Bedrijf b) {
		if (b != null) {
			dao.create(b);
		}
	}

	public void WijzigBedrijf(Bedrijf b) {
		if (b != null) {
			dao.update(b);
		}
	}
	
	public List<Bedrijf> getBedrijven(){
		return dao.getListBedrijven();
	}
	public Bedrijf getBedrijfBijNaam(String naam){
		return dao.getBedrijfBijNaam(naam);
	}

}

