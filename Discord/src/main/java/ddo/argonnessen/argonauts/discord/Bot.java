package ddo.argonnessen.argonauts.discord;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;

/**
 * main bot class
 */
public class Bot {

	/**
	 * deployment info
	 */
	static final BotBean deploymentInfo = new BotBean();
	/**
	 * 
	 */
	private static final String DEFAULT_PROPERTIES = "/Bot.properties"; //$NON-NLS-1$

	/**
	 * register commands
	 * 
	 * @param c
	 * @param client
	 */
	static void registerCommand(Command c, GatewayDiscordClient client) {
		String command = c.toString();
		client.getEventDispatcher().on(MessageCreateEvent.class).map(MessageCreateEvent::getMessage)
				.filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
				.filter(message -> message.getContent().equalsIgnoreCase(command)).flatMap(Message::getChannel)
				.flatMap(channel -> channel.createMessage(c.reply())).subscribe();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initBean(args);
		GatewayDiscordClient client = DiscordClientBuilder.create(deploymentInfo.getToken()).build().login().block();
		client.getEventDispatcher().on(ReadyEvent.class).subscribe(event -> {
			User self = event.getSelf();
			System.out.println(String.format("Logged in as %s#%s", self.getUsername(), self.getDiscriminator())); //$NON-NLS-1$
		});
		for (Command c : Command.values()) {
			registerCommand(c, client);
		}
		client.onDisconnect().block();
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	@SuppressWarnings("nls")
	private static void initBean(String[] args) {
		Properties p = new Properties();
		if (args.length == 0) {
			loadDefaultProperties(p);
		} else {
			try {
				p.load(new FileInputStream(args[0]));
			} catch (IOException e) {
				loadDefaultProperties(p);
			}
		}
		deploymentInfo.guild = p.getProperty("guild");
		deploymentInfo.server = p.getProperty("server");
		deploymentInfo.token = p.getProperty("token");
	}

	/**
	 * @param p
	 * @throws IOException
	 */
	private static void loadDefaultProperties(Properties p) {
		try {
			p.load(Bot.class.getResourceAsStream(DEFAULT_PROPERTIES));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
