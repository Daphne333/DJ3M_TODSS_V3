package Model.domein;

public enum FunctieRol {
	CURSIST, MANAGER, BEHEERDER, DOCENT;

	public FunctieRol getFunctieRolByName(String functieRoleName) {
		for (FunctieRol functieRol : FunctieRol.values())
			if (functieRol.name().equalsIgnoreCase(functieRoleName))
				return functieRol;
		return null;
	}

	public FunctieRol getFunctieRole(String functie) {
		FunctieRol rol = null;

		if (functie.equalsIgnoreCase("CURSIST")) {
			rol = FunctieRol.CURSIST;
		} else if (functie.equalsIgnoreCase("DOCENT")) {
			rol = FunctieRol.DOCENT;
		} else if (functie.equalsIgnoreCase("BEHEERDER")) {
			rol = FunctieRol.BEHEERDER;
		} else if (functie.equalsIgnoreCase("MANAGER")) {
			rol = FunctieRol.MANAGER;
		}

		return rol;
	}
}
