package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
import studio.cat.rules.services.DesignRulesImpl;

public class MainDesignConformity {
 
	private static final String filePath = "D:\\input\\designInput.json";
	private static final String fileOutputPath = "C:\\Users\\mghozzi\\eclipse-workspace\\DesignConformity\\target\\resultat.txt";
	
	public static void main(String[] args) {

		try {
			
			// read the json file
			FileReader reader = new FileReader(filePath); // Récupération du fichier JSON à manipuler lors de l'exécution du JAR

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

			// get a design name from the JSON object
			String firstName = (String) jsonObject.get("name");
			System.out.println("The design name is: " + firstName);

			// get design id from the JSON object
			String id =  (String) jsonObject.get("id");
			System.out.println("The design id is: " + id);
 
			// get an array from the JSON object
			JSONArray lang= (JSONArray) jsonObject.get("pages"); 
			System.out.println("The number of page in this design is : "+lang.size());
			Iterator<?> iterateur = lang.iterator();
			File reportFile=new File(fileOutputPath); // récupérer le chemin du fichier de sortie à partir des paramètres passées à l'éxécution du JAR
			reportFile.createNewFile();
			FileWriter fileWriter=new FileWriter(reportFile);
			// take each value from the json array separately
			while (iterateur.hasNext()) {
				JSONObject innerObj = (JSONObject) iterateur.next();
				System.out.println("page id "+ innerObj.get("id") + ", page name "+ innerObj.get("name") +  ", alternative pages "+ innerObj.get("alt_pages") + 
						", page backgroung color " + innerObj.get("bgcolor"));
				fileWriter.write("page id "+ innerObj.get("id") + ", page name "+ innerObj.get("name") +  ", alternative pages "+ innerObj.get("alt_pages") + 
						", page backgroung color " + innerObj.get("bgcolor")+"\n");  // écrire une ligne dans le fichier resultat.txt 
				fileWriter.write("\n"); // forcer le passage à la ligne
				System.out.println(new DesignRulesImpl().isPageAlternativeEmpty(innerObj));
			}
			fileWriter.close(); // fermer le fichier à la fin des traitements
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}