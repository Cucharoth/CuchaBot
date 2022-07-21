package Main;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.internal.interactions.component.ButtonImpl;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ButtonListener extends ListenerAdapter {
    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        String response = "";
        HashMap<String, String> patchs = new HashMap<>();
        patchs.put("5.4", "https://imgur.com/u7kzegM" + "\n" + "https://imgur.com/jnPCsOA" + "\n" + "Anee-Bronya");
        patchs.put("5.5", "https://imgur.com/FuPIbbf" + "\n" + "https://imgur.com/mc0eX8w" + "\n" + "PE");
        patchs.put("5.6", "https://imgur.com/10xAOQK" + "\n" + "https://imgur.com/WAV1jAI" + "\n" + "Gato");
        patchs.put("5.7", "https://imgur.com/4Tjdvpq" + "\n" + "https://imgur.com/HSPj47q" + "\n" + "Eden");
        patchs.put("5.8", "https://imgur.com/QwqTkvq" + "\n" + "https://imgur.com/JInQmZo" + "\n" + "Painto Girl");
        if(event.getButton().getId() != null) {
            switch (event.getButton().getId()) {
                case "5.4": response = patchs.get("5.4");
                    break;
                case "5.5": response = patchs.get("5.5");
                    break;
                case "5.6": response = patchs.get("5.6");
                    break;
                case "5.7": response = patchs.get("5.7");
                    break;
                case "5.8": response = patchs.get("5.8");
                    break;
            }
        }
        event.reply(response).setEphemeral(true).queue();
    }
}
