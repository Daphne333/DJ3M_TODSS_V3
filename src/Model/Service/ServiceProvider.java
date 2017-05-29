package Model.Service;


public class ServiceProvider {
	// Met deze klasse kan je straks alle service Klassen aan gaan roepen. aan gaan roepen.
	
	private static AccountService Account = new AccountService();
	private static PersoonService Persoon = new PersoonService();
	 public static AccountService getAccountService() {
	        return Account;
	 }
	 public static PersoonService getPersoonService() {
	        return Persoon;
	 }
}
