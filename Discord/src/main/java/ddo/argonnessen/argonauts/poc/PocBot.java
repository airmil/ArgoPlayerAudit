package ddo.argonnessen.argonauts.poc;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.lifecycle.ReadyEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;

/**
 * 
 */
public class PocBot {

	/**
	 * token
	 */
	private static final String TOKEN = ""; //$NON-NLS-1$

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GatewayDiscordClient client = DiscordClientBuilder.create(TOKEN).build().login().block();
		client.getEventDispatcher().on(ReadyEvent.class).subscribe(event -> {
			User self = event.getSelf();
			System.out.println(String.format("Logged in as %s#%s", self.getUsername(), self.getDiscriminator())); //$NON-NLS-1$
		});
		client.getEventDispatcher().on(MessageCreateEvent.class).map(MessageCreateEvent::getMessage)
				.filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
				.filter(message -> message.getContent().equalsIgnoreCase("!ping")) //$NON-NLS-1$
				.flatMap(Message::getChannel)
				.flatMap(channel -> channel.createMessage("Pong!")).subscribe(); //$NON-NLS-1$
		client.onDisconnect().block();
	}
}
