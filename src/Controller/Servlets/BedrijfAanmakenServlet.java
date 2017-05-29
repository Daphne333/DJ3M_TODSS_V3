package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Service.BedrijfService;
import Model.Service.PersoonService;
import Model.Service.ServiceProvider;
import Model.domein.Bedrijf;

@WebServlet("/BedrijfAanmaken")
public class BedrijfAanmakenServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PersoonService personalService = ServiceProvider.getPersoonService();

	private BedrijfService bedrijfService = ServiceProvider.getBedrijf();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{		
		System.out.println("Hier zijn de lala mensjes");
		 String bedrijfsNaam = req.getParameter("setBedrijfsNaam");
		 String vestigingStraat = req.getParameter("setVestigingStraat");
		 String vestigingHuisnummerStr = req.getParameter("setVestigingHuisnummer");
		 if(vestigingHuisnummerStr != null){
			int vestigingHuisnummer = Integer.parseInt(vestigingHuisnummerStr);
		 }
		 String vestigingToevoeging = req.getParameter("setVestigingToevoeging");
		 String vestigingPostcode = req.getParameter("setVestigingPostcode");
		 String vestigingPlaats = req.getParameter("setVestigingPlaats");
		 String vestigingPostbusStr = req.getParameter("setVestigingPostbus");
		 if(vestigingPostbusStr != null){
			int vestigingPostbus = Integer.parseInt(vestigingPostbusStr);
		 }
		 String postadresStraat = req.getParameter("setPostadresStraat");
		 String postadresHuisnummerStr = req.getParameter("setPostadresHuisnummer");
		 if(postadresHuisnummerStr != null){
			int postadresHuisnummer = Integer.parseInt(postadresHuisnummerStr);
		 }
		 String postadresToevoeging = req.getParameter("setPostadresToevoeging");
		 String postadresPostcode = req.getParameter("setPostadresPostcode");
		 String postadresPlaats = req.getParameter("setPostadresPlaats");
		 String postadresPostbusStr = req.getParameter("setPostadresPostbus");
		 if(postadresPostbusStr != null){
			int postadresPostbus = Integer.parseInt(postadresPostbusStr);
		 }
		 String telefoonnummer = req.getParameter("setTelefoonnummer");
		 String kvknummerStr = req.getParameter("setKvknummer");
		 if(kvknummerStr != null){
			int kvknummer = Integer.parseInt(kvknummerStr);
		 }
		 
		 RequestDispatcher rd = null;
		 System.out.println(bedrijfsNaam + " " + vestigingStraat+ " " +vestigingHuisnummerStr+ " " +vestigingToevoeging+ " " +vestigingPostcode+ " " +vestigingPlaats+ " " +vestigingPostbusStr+ " " +postadresStraat+ " " +
				 postadresHuisnummerStr + " " + postadresToevoeging + " " + postadresPostcode + " " + postadresPlaats + " " + postadresPostbusStr + " " + telefoonnummer + " " + kvknummerStr);
		 System.out.println("Hallo hier is pino");
		 
		if (bedrijfsNaam != null && vestigingStraat != null && vestigingHuisnummerStr != null && vestigingPostcode != null && vestigingPlaats != null && telefoonnummer != null && kvknummerStr != null){
			System.out.println("Hij komt door de check heen");
			
			Bedrijf bedrijf = new Bedrijf();
			bedrijf.setBedrijfsnaam(bedrijfsNaam);
			bedrijf.setVestiging_straat(vestigingStraat);
			bedrijf.setVestiging_huisnummer(23);
			bedrijf.setVestiging_toevoeging(vestigingToevoeging);
			bedrijf.setVestiging_postcode(vestigingPostcode);
			bedrijf.setVestiging_plaats(vestigingPlaats);
			bedrijf.setVestiging_postbus(234234);
			bedrijf.setPostadres_straat(postadresStraat);
			bedrijf.setPostadres_huisnummer(324324);
			bedrijf.setPostadres_toevoeging(postadresToevoeging);
			bedrijf.setPostadres_postcode(postadresPostcode);
			bedrijf.setPostadres_plaats(postadresPlaats);
			bedrijf.setPostadres_postbus(234234);
			bedrijf.setTelefoonnummer(telefoonnummer);
			bedrijf.setKvknummer(2324);
			
			bedrijfService.maakBedrijfAan(bedrijf);
			rd = req.getRequestDispatcher("/Beheerder/Beheerder_Home.jsp");
			} else {
				System.out.println("Hij komt niet voorbij check 1");
			}
		
		
		rd.forward(req, resp);
		} 
}