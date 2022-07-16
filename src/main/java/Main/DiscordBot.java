package Main;

import Main.Commands.BotCommands;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class DiscordBot extends ListenerAdapter {
    private final ShardManager shardManager;
    //private final Dotenv config;


    public DiscordBot() throws LoginException{
        /*config = Dotenv.configure().load();
        String token = config.get("TOKEN");*
         */
        String token = "OTk3ODcyMTA4MDkwNjk1ODIx.G06Sd-.H6pSxC-NTaqv2krdAY1rU1wLfF_j2Ri_R41tSY";
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setActivity(Activity.playing("Honkai"));
        shardManager = builder.build();
        shardManager.addEventListener(new BotListener());
        shardManager.addEventListener(new BotCommands());
    }

    public ShardManager getShardManager(){
        return shardManager;
    }



    public static void main(String[] args) {
        System.out.println("actually working");
        try {
            DiscordBot discordBot = new DiscordBot();
        } catch (LoginException e) {
            e.printStackTrace();
        }


        /*JDA jda = JDABuilder.createDefault("OTk3ODcyMTA4MDkwNjk1ODIx.G06Sd-.H6pSxC-NTaqv2krdAY1rU1wLfF_j2Ri_R41tSY")
                .setActivity(Activity.playing("Honkai"))
                .addEventListeners(new BotCommands())
                .build();/*

        /*Guild guild = jda.getGuildById("286988491160551424");
        if(guild != null) {
            guild.upsertCommand("test1", "test").queue();*/

    }
}
