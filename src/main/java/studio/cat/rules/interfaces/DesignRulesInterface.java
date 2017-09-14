package studio.cat.rules.interfaces;

import org.json.simple.JSONObject;

public interface DesignRulesInterface {
	
	/**
	 * M�thode permettant de v�rifier si le tableau des pages alternatives est vide
	 * @param innerObjectInPage le tableau JSON d'une page
	 * @return true si le tableau des pages alternative est vide, false si non
	 */
	Boolean isPageAlternativeEmpty(JSONObject innerObjectInPage);

}
