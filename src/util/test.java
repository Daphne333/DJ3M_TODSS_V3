package util;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import Model.domein.AntwoordCursist;
import Model.domein.AntwoordOpdracht;
import Model.domein.Bedrijf;
import Model.domein.Cursist;
import Model.domein.Cursus;
import Model.domein.CursusUitvoering;
import Model.domein.Docent;
import Model.domein.Opdracht;
import Model.domein.ResultaatCursist;
import Model.domein.Training;



public class test {
	protected static void add() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Bedrijf bedrijf = new Bedrijf();
		bedrijf.setBedrijfsnaam("lala123");
		bedrijf.setKvknummer(3878);
		
		Docent docent = new Docent();
		docent.setNaam("doc");
		
		Cursist cursist = new Cursist();
		cursist.setNaam("cur");
		
		Cursus cursus = new Cursus();
		cursus.setOmschrijving("test");
		
		CursusUitvoering cu = new CursusUitvoering();
		cu.setCursus(cursus);
		cu.setAantalPlaatsen(2);
		
		Set<Cursist> cursisten = new HashSet<Cursist>();
		cursisten.add(cursist);
		cu.setCursisten(cursisten);
		
		Training training = new Training();
		training.setCursus(cursus);
		training.setDocent(docent);
		
		Opdracht opdracht = new Opdracht();
		opdracht.setVraag("test");;
		Set<Opdracht> opdrachten = new HashSet<Opdracht>();
		opdrachten.add(opdracht);
		
		training.setOpdrachten(opdrachten);
		
		AntwoordCursist ac =new AntwoordCursist();
		ac.setAntwoord("goeie");
		ac.setCursist(cursist);
		ac.setOpdracht(opdracht);
		
		AntwoordOpdracht ao =new AntwoordOpdracht();
		ao.setAntwoord("goeie");
		ao.setOpdracht(opdracht);
		
		ResultaatCursist rc = new ResultaatCursist();
		rc.setAntwoordcursist(ac);
		rc.setAntwoordopdracht(ao);
		session.save(bedrijf);
		session.save(docent);
		session.save(cursist);
		session.save(cursus);
		session.save(cu);
		session.save(opdracht);
		session.save(training);
		session.save(ao);
		session.save(ac);
		session.save(rc);
		session.getTransaction().commit();
		session.close();
	}

	public static void main(String[] args) {
		test.add();

	}

}
