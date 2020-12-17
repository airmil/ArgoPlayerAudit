package ddo.argonnessen.argonauts.poc;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import ddo.argonnessen.argonauts.playeraudit.Server;

/**
 * 
 */
public class PocPlayerAudit {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		URL u = new URL("https://www.playeraudit.com/api/players"); //$NON-NLS-1$
		InputStream stream = u.openStream();
		InputStreamReader isr = new InputStreamReader(stream);
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		JsonReader reader = new JsonReader(isr);
		JsonArray ja = gson.fromJson(reader, JsonArray.class);
		for (JsonElement jsonElement : ja) {
			Server server = gson.fromJson(jsonElement, Server.class);
			System.out.println(server.getName());
		}
	}
}
