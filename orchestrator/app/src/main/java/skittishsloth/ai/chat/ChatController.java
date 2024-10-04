package skittishsloth.ai.chat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

@Value
@NonFinal
@Slf4j
@Getter(AccessLevel.PRIVATE)
@RestController
public class ChatController {
    ChatService chatService;

    ChatController(final ChatService chatService) {
        this.chatService = chatService;

        log.info("Controller starting");
    }


    @PostMapping("/chat")
    public String generate(@RequestBody final String prompt) {
        return chatService().generate(prompt);
    }
}
