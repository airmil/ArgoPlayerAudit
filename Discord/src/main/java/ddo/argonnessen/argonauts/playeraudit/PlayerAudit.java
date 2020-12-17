package ddo.argonnessen.argonauts.playeraudit;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import ddo.argonnessen.argonauts.playeraudit.exception.PlayerAuditException;

/**
 * bean to communicate with PlayerAudit
 */
public class PlayerAudit {

	/**
	 * API URL
	 */
	private static final String URL = "https://www.playeraudit.com/api/players"; //$NON-NLS-1$
	/**
	 * servers
	 */
	Map<String, Server> servers = new HashMap<String, Server>();

	/**
	 * constructor
	 * 
	 * @throws PlayerAuditException
	 */
	public PlayerAudit() throws PlayerAuditException {
		URL u;
		try {
			u = new URL(URL);
		} catch (MalformedURLException e) {
			throw new PlayerAuditException(e);
		}
		InputStream stream;
		try {
			stream = u.openStream();
		} catch (IOException e) {
			throw new PlayerAuditException(e);
		}
		InputStreamReader isr = new InputStreamReader(stream);
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
		JsonReader reader = new JsonReader(isr);
		JsonArray ja = gson.fromJson(reader, JsonArray.class);
		for (JsonElement jsonElement : ja) {
			Server server = gson.fromJson(jsonElement, Server.class);
			servers.put(server.getName(), server);
		}
	}

	/**
	 * @param name
	 * @return server based on name
	 */
	public Server getServer(String name) {
		return servers.get(name);
	}
}
