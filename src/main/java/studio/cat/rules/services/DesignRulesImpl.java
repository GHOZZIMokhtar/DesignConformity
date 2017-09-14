package studio.cat.rules.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import studio.cat.rules.interfaces.DesignRulesInterface;

public class DesignRulesImpl implements DesignRulesInterface {

	@Override
	public Boolean isPageAlternativeEmpty(JSONObject innerObjectInPage) {
		if(((JSONArray)innerObjectInPage.get("alt_pages")).size()==0) {
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}

}
