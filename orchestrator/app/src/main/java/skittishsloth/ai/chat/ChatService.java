package skittishsloth.ai.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

@Value
@NonFinal
@Getter(AccessLevel.PRIVATE)
@Slf4j
@Component
public class ChatService {
    OpenAiChatModel chatModel;

    @Getter(lazy = true) ChatClient chatClient = ChatClient.builder(chatModel()).build();

    ChatService(final OpenAiChatModel chatModel) {
        this.chatModel = chatModel;

        log.info("Service starting.");
    }


    public String generate(final String prompt) {
        return chatClient().prompt()
            .user(prompt)
            .call()
            .content();
    }
}
