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
	private PersoonService personalService = ServiceProvider.getPersoon();

	private BedrijfService bedrijfService = ServiceProvider.getBedrijf();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{		
	
		 String bedrijfsNaam = req.getParameter("setBedrijfsNaam");
		 String vestigingStraat = req.getParameter("setVestigingStraat");
		 String vestigingHuisnummerStr = req.getParameter("setVestigingHuisnummer");
		 int vestigingHuisnummer = 0;
		 if(!vestigingHuisnummerStr.equals("")){
			vestigingHuisnummer = Integer.parseInt(vestigingHuisnummerStr);
		 }
		 String vestigingToevoeging = req.getParameter("setVestigingToevoeging");
		 String vestigingPostcode = req.getParameter("setVestigingPostcode");
		 String vestigingPlaats = req.getParameter("setVestigingPlaats");
		 String vestigingPostbusStr = req.getParameter("setVestigingPostbus");
		 int vestigingPostbus =0;
		 if(!vestigingPostbusStr.equals("")){
			vestigingPostbus = Integer.parseInt(vestigingPostbusStr);
		 }
		 String postadresStraat = req.getParameter("setPostadresStraat");
		 String postadresHuisnummerStr = req.getParameter("setPostadresHuisnummer");
		 int postadresHuisnummer =0;
		 if(!postadresHuisnummerStr.equals("")){
			postadresHuisnummer = Integer.parseInt(postadresHuisnummerStr);
		 }
		 String postadresToevoeging = req.getParameter("setPostadresToevoeging");
		 String postadresPostcode = req.getParameter("setPostadresPostcode");
		 String postadresPlaats = req.getParameter("setPostadresPlaats");
		 String postadresPostbusStr = req.getParameter("setPostadresPostbus");
		 int postadresPostbus = 0;
		 if(!postadresPostbusStr.equals("")){
			postadresPostbus = Integer.parseInt(postadresPostbusStr);
		 }
		 String telefoonnummer = req.getParameter("setTelefoonnummer");
		 String kvknummerStr = req.getParameter("setKvknummer");
		 int kvknummer = 0;
		 if(!kvknummerStr.equals("")){
			kvknummer = Integer.parseInt(kvknummerStr);
		 }
		 String email = req.getParameter("setEmail");
		 
		 RequestDispatcher rd = null;
		 /*System.out.println(bedrijfsNaam + " " + vestigingStraat+ " " +vestigingHuisnummerStr+ " " +vestigingToevoeging+ " " +vestigingPostcode+ " " +vestigingPlaats+ " " +vestigingPostbusStr+ " " +postadresStraat+ " " +
				 postadresHuisnummerStr + " " + postadresToevoeging + " " + postadresPostcode + " " + postadresPlaats + " " + postadresPostbusStr + " " + telefoonnummer + " " + kvknummerStr);
		*/ 
		if (bedrijfsNaam != null && vestigingStraat != null && vestigingHuisnummerStr != null && vestigingPostcode != null && vestigingPlaats != null && telefoonnummer != null && kvknummerStr != null && email != null){
			System.out.println("Hij komt door de check heen");
			
			Bedrijf bedrijf = new Bedrijf();
			bedrijf.setBedrijfsnaam(bedrijfsNaam);
			bedrijf.setVestiging_straat(vestigingStraat);
			bedrijf.setVestiging_huisnummer(vestigingHuisnummer);
			bedrijf.setVestiging_toevoeging(vestigingToevoeging);
			bedrijf.setVestiging_postcode(vestigingPostcode);
			bedrijf.setVestiging_plaats(vestigingPlaats);
			bedrijf.setVestiging_postbus(vestigingPostbus);
			bedrijf.setPostadres_straat(postadresStraat);
			bedrijf.setPostadres_huisnummer(postadresHuisnummer);
			bedrijf.setPostadres_toevoeging(postadresToevoeging);
			bedrijf.setPostadres_postcode(postadresPostcode);
			bedrijf.setPostadres_plaats(postadresPlaats);
			bedrijf.setPostadres_postbus(postadresPostbus);
			bedrijf.setTelefoonnummer(telefoonnummer);
			bedrijf.setKvknummer(kvknummer);
			bedrijf.setEmail(email);
			
			bedrijfService.maakBedrijfAan(bedrijf);
			rd = req.getRequestDispatcher("/Beheerder/Beheerder_Home.jsp");
			} else {
				System.out.println("Hij komt niet voorbij check 1");
			}
		
		
		rd.forward(req, resp);
		} 
}