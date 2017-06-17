package Model.Service;

public class ServiceProvider {
	// Met deze klasse kan je straks alle service Klassen aan gaan roepen. aan
	// gaan roepen.

	private static AccountService Account = new AccountService();
	private static AntwoordCursistService AntwoordCursist = new AntwoordCursistService();
	private static AntwoordOpdrachtService AntwoordOpdracht = new AntwoordOpdrachtService();
	private static BedrijfService Bedrijf = new BedrijfService();
	private static CursusService Cursus = new CursusService();
	private static CursusUitvoeringService CursusUitvoering = new CursusUitvoeringService();
	private static OpdrachtService Opdracht = new OpdrachtService();
	private static PersoonService Persoon = new PersoonService();
	private static ResultaatCursistService ResultaatCursist = new ResultaatCursistService();
	private static TrainingService Training = new TrainingService();

	public static AccountService getAccount() {
		return Account;
	}

	public static AntwoordCursistService getAntwoordCursist() {
		return AntwoordCursist;
	}

	public static AntwoordOpdrachtService getAntwoordOpdracht() {
		return AntwoordOpdracht;
	}

	public static BedrijfService getBedrijf() {
		return Bedrijf;
	}

	public static CursusService getCursus() {
		return Cursus;
	}

	public static CursusUitvoeringService getCursusUitvoering() {
		return CursusUitvoering;
	}

	public static OpdrachtService getOpdracht() {
		return Opdracht;
	}

	public static PersoonService getPersoon() {
		return Persoon;
	}

	public static ResultaatCursistService getResultaatCursist() {
		return ResultaatCursist;
	}

	public static TrainingService getTraining() {
		return Training;
	}
}
