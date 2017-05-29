package Controller.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Service.BedrijfService;
import Model.domein.Bedrijf;
import Model.domein.Cursus;

public class BedrijfAanmakenServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{		
		
		 String bedrijfsNaam = req.getParameter("setBedrijfsNaam");
		 String vestigingStraat = req.getParameter("setVestigingStraat");
		 String vestigingHuisnummerStr = req.getParameter("setVestigingHuisnummer");
		 int vestigingHuisnummer = Integer.parseInt(vestigingHuisnummerStr);
		 String vestigingToevoeging = req.getParameter("setVestigingToevoeging");
		 String vestigingPostcode = req.getParameter("setVestigingPostcode");
		 String vestigingPlaats = req.getParameter("setVestigingPlaats");
		 String vestigingPostbusStr = req.getParameter("setVestigingPostbus");
		 int vestigingPostbus = Integer.parseInt(vestigingPostbusStr);
		 String postadresStraat = req.getParameter("setPostadresStraat");
		 String postadresHuisnummerStr = req.getParameter("setPostadresHuisnummer");
		 int postadresHuisnummer = Integer.parseInt(postadresHuisnummerStr);
		 String postadresToevoeging = req.getParameter("setPostadresToevoeging");
		 String postadresPostcode = req.getParameter("setPostadresPostcode");
		 String postadresPlaats = req.getParameter("setPostadresPlaats");
		 String postadresPostbusStr = req.getParameter("setPostadresPostbus");
		 int postadresPostbus = Integer.parseInt(postadresPostbusStr);
		 String telefoonnummer = req.getParameter("setTelefoonnummer");
		 String kvknummerStr = req.getParameter("setKvknummer");
		 int kvknummer = Integer.parseInt(kvknummerStr);
		 
		 RequestDispatcher rd = null;
		 BedrijfService bedrijfService = new BedrijfService();
		 
		if (bedrijfsNaam != null && vestigingStraat != null && vestigingHuisnummerStr != null && vestigingPostcode != null && vestigingPlaats != null && telefoonnummer != null && kvknummerStr != null){
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
			
			bedrijfService.maakBedrijfAan(bedrijf);
			rd = req.getRequestDispatcher("/Beheerder_BedrijfAanmaken.jsp");
			} 
		rd.forward(req, resp);
		} 

}
