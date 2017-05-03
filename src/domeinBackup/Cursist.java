package domeinBackup;

import java.util.ArrayList;
import java.util.List;

public class Cursist extends Persoon {
	private String chef;
	private int bedrijfsID;
	private List<CursusUitvoering> volgtCursusUitvoeringen = new ArrayList<CursusUitvoering>();
	private List<AntwoordCursist> antwoorden = new ArrayList<AntwoordCursist>();
	private List<ResultaatCursist> resultaten = new ArrayList<ResultaatCursist>();

	public Cursist() {
	}

	public String getFunctie() {
		return "Cursist";
	}

	public void setFunctie(String functie) {
		functie = "Cursist";
	}

	public String getChef() {
		return chef;
	}

	public void setChef(String chef) {
		this.chef = chef;
	}

	public int getBedrijfsID() {
		return bedrijfsID;
	}

	public void setBedrijfsID(int bedrijfsID) {
		this.bedrijfsID = bedrijfsID;
	}

	public List<CursusUitvoering> getVolgtCursusUitvoeringen() {
		return volgtCursusUitvoeringen;
	}

	public void addCursusUitvoeringToCursist(CursusUitvoering cursusuitvoering) {
		volgtCursusUitvoeringen.add(cursusuitvoering);
	}

	public void removeCursusUitvoeringFromCursist(int uitvoeringID) {
		for (CursusUitvoering cursusuitvoering : volgtCursusUitvoeringen) {
			if (uitvoeringID == cursusuitvoering.getUitvoeringID()) {
				volgtCursusUitvoeringen.remove(uitvoeringID);
			}

		}
	}

	public CursusUitvoering zoekCursusUitvoering(int uitvoeringID) {
		CursusUitvoering resp = null;
		for (CursusUitvoering cursusuitvoering : volgtCursusUitvoeringen) {
			if (uitvoeringID == cursusuitvoering.getUitvoeringID()) {
				resp = cursusuitvoering;
			}
		}
		return resp;
	}

	public List<AntwoordCursist> getAlleAntwoorden() {
		return antwoorden;

	}

	public List<AntwoordCursist> getAntwoordenVanOpdracht(int opdrachtID) {
		List<AntwoordCursist> antwoordenOpdracht = new ArrayList<AntwoordCursist>();
		for (AntwoordCursist antwoord : antwoorden) {
			if (opdrachtID == antwoord.getOpdracht().getOpdrachtID()) {
				antwoordenOpdracht.add(antwoord);
			}
		}
		return antwoordenOpdracht;

	}

	public void addAntwoordToCursist(AntwoordCursist antwoord) {
		antwoorden.add(antwoord);
	}

	public void removeAntwoordFromCursist(int antwoordcursistID) {
		for (AntwoordCursist antwoord : antwoorden) {
			if (antwoordcursistID == antwoord.getAntwoordCursistID()) {
				antwoorden.remove(antwoordcursistID);
			}

		}
	}

	public AntwoordCursist zoekAntwoordCursist(int antwoordcursistID) {
		AntwoordCursist resp = null;
		for (AntwoordCursist antwoord : antwoorden) {
			if (antwoordcursistID == antwoord.getAntwoordCursistID()) {
				resp = antwoord;
			}
		}
		return resp;
	}

	public List<ResultaatCursist> getAlleResultaten() {
		return resultaten;

	}

	public List<ResultaatCursist> getResultatenVanOpdracht(int opdrachtID) {
		List<ResultaatCursist> resultatenOpdracht = new ArrayList<ResultaatCursist>();
		for (ResultaatCursist resultaat : resultaten) {
			if (opdrachtID == resultaat.getAntwoordcursist().getOpdracht().getOpdrachtID()) {
				resultatenOpdracht.add(resultaat);
			}
		}
		return resultatenOpdracht;
	}

	public void addResultaatToCursist(ResultaatCursist resultaat) {
		resultaten.add(resultaat);
	}

	public void removeResultaatFromCursist(int resultaatID) {
		for (ResultaatCursist resultaat : resultaten) {
			if (resultaatID == resultaat.getResultaatID()) {
				resultaten.remove(resultaatID);
			}

		}
	}
}
