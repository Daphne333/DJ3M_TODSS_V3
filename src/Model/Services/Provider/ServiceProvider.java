package Model.Services.Provider;

import Model.Services.Account.AccountService;
import Model.Services.Account.LoginService;
import Model.Services.Account.RegisterService;
import Model.Services.Account.WijzigPersoonService;

public class ServiceProvider {
	// Met deze klasse kan je straks alle service Klassen aan gaan roepen. aan gaan roepen.
	
	private static AccountService account = new AccountService();
	private static LoginService login = new LoginService();
	private static RegisterService register =  new RegisterService();
	private static WijzigPersoonService wijzigPersoon = new WijzigPersoonService();
	
	 public static AccountService getAccountService() {
	        return account;
	 }
	 public static LoginService getLoginService() {
	        return login;
	 }
	 public static RegisterService getRegisterService() {
	        return register;
	 }
	 public static WijzigPersoonService getWijzigPersoonService() {
	        return wijzigPersoon;
	 }
	
}
