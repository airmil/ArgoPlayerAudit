package ddo.argonnessen.argonauts.discord;

import ddo.argonnessen.argonauts.playeraudit.Player;
import ddo.argonnessen.argonauts.playeraudit.PlayerAudit;
import ddo.argonnessen.argonauts.playeraudit.Server;
import ddo.argonnessen.argonauts.playeraudit.exception.PlayerAuditException;

/**
 * discord commands
 */
public enum Command {

	/**
	 * total online on server
	 */
	COUNT {

		@SuppressWarnings("nls")
		@Override
		public String reply() {
			PlayerAudit audit = get();
			Server server = audit.getServer(Bot.deploymentInfo.getServer());
			return new StringBuilder().append("Total of ").append(server.getPlayers().size()).append(" players in ")
					.append(Bot.deploymentInfo.getServer())
					.append(" are online").toString();
		}
	},
	/**
	 * total guildies online
	 */
	GCOUNT {

		@SuppressWarnings("nls")
		@Override
		public String reply() {
			PlayerAudit audit = get();
			Server server = audit.getServer(Bot.deploymentInfo.getServer());
			int count = 0;
			for (Player p : server.getPlayers()) {
				if (Bot.deploymentInfo.getGuild().equalsIgnoreCase(p.getGuild())) {
					count++;
				}
			}
			return new StringBuilder().append("Total of ").append(count).append(" guildies (").append(Bot.deploymentInfo.getGuild())
					.append(") are online in ")
					.append(Bot.deploymentInfo.getServer()).toString();
		}
	},
	/**
	 * online guildies
	 */
	GWHO {

		@SuppressWarnings("nls")
		@Override
		public String reply() {
			PlayerAudit audit = get();
			Server server = audit.getServer(Bot.deploymentInfo.getServer());
			StringBuilder sb = new StringBuilder().append("{");
			boolean first = true;
			for (Player p : server.getPlayers()) {
				if (Bot.deploymentInfo.getGuild().equalsIgnoreCase(p.getGuild())) {
					if (!first) {
						sb.append(",");
					}
					sb.append(p.getName());
					first = false;
				}
			}
			sb.append("}");
			return sb.toString();
		}
	};

	/**
	 * @return bot message
	 */
	public abstract String reply();

	/**
	 * @return
	 */
	private static synchronized PlayerAudit get() {
		PlayerAudit audit;
		try {
			audit = new PlayerAudit();
		} catch (PlayerAuditException e) {
			throw new RuntimeException(e);
		}
		return audit;
	}
}
