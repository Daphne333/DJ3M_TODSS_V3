package Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;

import Model.Service.AccountService;
import Model.Service.ResultaatCursistService;
import Model.Service.ServiceProvider;
import Model.domein.Account;
import Model.domein.CursusUitvoering;
import Model.domein.ResultaatCursist;

public class ResultatenTests {
	public static void main(String[] args) {

		List<ResultaatCursist> lijst = null;
		RequestDispatcher rd = null;

		String rol = "MANAGER";
		ServiceProvider service = new ServiceProvider();
		ResultaatCursistService Res = service.getResultaatCursist();

		AccountService c = null;

		{
			// acties voor de verschillende rollen
			switch (rol) {
			case "BEHEERDER":

				lijst = Res.getResultaten();
				// req.getSession().setAttribute("Resultaten", lijst);
				break;

			case "MANAGER":
				int bedrijfid = 1;
				List<ResultaatCursist> M_l = Res.getResultaten();
				for (int i = 0; i <= M_l.size(); i++) {
					int resultaat_bedrijfid = M_l.get(i).getAntwoordcursist().getAccount().getPersoonID().getBedrijfID()
							.getBedrijfID();
					if (bedrijfid == resultaat_bedrijfid) {
						lijst.add(M_l.get(i));
					}
				}
				for (ResultaatCursist curs : M_l) {
					curs.toString();
				}
				break;

			case "CURSIST":

				int Cursistid = 1;
				List<ResultaatCursist> C_l = Res.getResultaten();
				for (int i = 0; i <= C_l.size(); i++) {
					int resultaat_Cursistid = C_l.get(i).getAntwoordcursist().getAccount().getPersoonID().getPersonID();
					if (Cursistid == resultaat_Cursistid) {
						lijst.add(C_l.get(i));
					}
				}
				break;

			case "DOCENT":

				/*
				 * // pak cursus die account geeft Set<CursusUitvoering>
				 * gegevencursus = account.getGeeftCursus(); for
				 * (Iterator<CursusUitvoering> it = gegevencursus.iterator();
				 * it.hasNext();) { CursusUitvoering f = it.next(); // neem de
				 * cursuid daarvan int cursusid = f.getCursus().getCursusId();
				 * List<ResultaatCursist> D_l = Res.getResultaten(); for (int i
				 * = 0; i <= D_l.size(); i++) { // pak uit lijst cursus die hij
				 * volgt Set<CursusUitvoering> resultaat_cursus =
				 * D_l.get(i).getAntwoordcursist().getAccount()
				 * .getUitvoeringen(); for (Iterator<CursusUitvoering> a =
				 * resultaat_cursus.iterator(); it.hasNext();) {
				 * CursusUitvoering b = it.next(); // neem cursus id daarvan int
				 * resultaat_cursusid = b.getCursus().getCursusId(); //
				 * vergelijk if (cursusid == resultaat_cursusid) {
				 * lijst.add(D_l.get(i)); } //
				 * req.getSession().setAttribute("Resultaten", lijst); } } }
				 */
				break;

			}
		}

	}

}
