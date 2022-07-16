package Main;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class BotListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(!event.getAuthor().isBot()) {
            //add actions
            takoTuesday(event);
        }
    }

    private void takoTuesday(MessageReceivedEvent event){
        String messageSend = event.getMessage().getContentRaw();
        if(messageSend.contains("martes") || messageSend.contains("tuesday")){
            event.getTextChannel().sendMessage("https://i.imgur.com/kf7WnWY.png").queue();
        }
    }


}
