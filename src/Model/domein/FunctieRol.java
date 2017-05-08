package Model.domein;

public enum FunctieRol {
	CURSIST,MANAGER,BEHEERDER,DOCENT;
	
	public FunctieRol getFunctieRolByName(String functieRoleName){
		for (FunctieRol functieRol : FunctieRol.values())
			if(functieRol.name().equalsIgnoreCase(functieRoleName))
				return functieRol;
		return null;
	}
}
