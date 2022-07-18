package Main.Commands;

import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.internal.interactions.component.ButtonImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BotCommands extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        //add comands on interaction
        honkaiRotation(event);
        honkaiOldPatchRotation(event);
    }

    private void honkaiOldPatchRotation(SlashCommandInteractionEvent event) {
        HashMap<String, String> patchs = new HashMap<>();
        patchs.put("5.4", "https://imgur.com/u7kzegM" + "\n" + "https://imgur.com/jnPCsOA" + "Anee-Bronya");
        patchs.put("5.5", "https://imgur.com/FuPIbbf" + "\n" + "https://imgur.com/mc0eX8w" + "PE");
        patchs.put("5.6", "https://imgur.com/10xAOQK" + "\n" + "https://imgur.com/WAV1jAI" + "Gato");
        patchs.put("5.7", "https://imgur.com/4Tjdvpq" + "\n" + "https://imgur.com/HSPj47q" + "Eden");
        patchs.put("5.8", "https://imgur.com/QwqTkvq" + "\n" + "https://imgur.com/JInQmZo" + "Painto Girl");
        Button button54 = Button.primary("5.4", "5.4 patch info (Gato)");
        if(event.getName().equalsIgnoreCase("honkai_old_patch_info")){
            Message message = new MessageBuilder()
                    .append("Old patchs")
                    .setActionRows(ActionRow.of(button54))
                    .build();
            event.getTextChannel().sendMessage(message).queue();
        }
    }

    private void honkaiRotation(SlashCommandInteractionEvent event) {
        if(event.getName().equalsIgnoreCase("honkai_rotation")){
            event.reply("https://i.imgur.com/hiT8kvW.jpg" + "\n" + "https://i.imgur.com/aI38iPy.png" + "\n" +
                    "Patch 5.8 (Painto girl)").queue();
        }

    }

    //onGuild
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        //add commands to the bot
        commandData.add(Commands.slash("honkai_rotation", "Honkai current patch rotation"));

        //update them
        event.getGuild().updateCommands().addCommands(commandData).queue();

    }

    //global
    /*@Override
    public void onReady(@NotNull ReadyEvent event) {
        List<CommandData> commandData = new ArrayList<>();
        //add commands
        commandData.add(Commands.slash("honkai_rotation", "Honkai current patch rotation"));

        //update them
        event.getJDA().updateCommands().addCommands(commandData).queue();

    }*/

    /*@Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        super.onGuildJoin(event);
        List<CommandData> commandsData = new ArrayList<>();
        commandsData.add(Commands.slash("Testo", "testo"));
        event.getGuild().updateCommands().addCommands(commandsData).queue();
    }*/


}
