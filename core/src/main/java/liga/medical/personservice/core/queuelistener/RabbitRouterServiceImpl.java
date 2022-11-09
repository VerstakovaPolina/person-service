package liga.medical.personservice.core.queuelistener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitRouterServiceImpl {

    private final ObjectMapper objectMapper;

    private final MessageMapper messageMapper;

    private final RabbitTemplate rabbitTemplate;

    public RabbitRouterServiceImpl(ObjectMapper objectMapper, MessageMapper messageMapper, RabbitTemplate rabbitTemplate) {
        this.objectMapper = objectMapper;
        this.messageMapper = messageMapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void routeMessage(String message) {
        Signal signal = null;
        try {
            signal = objectMapper.readValue(message, Signal.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }finally {
            String messageType = signal.getType();
            String content = signal.getDescription();
            Long id = signal.getId();
            messageMapper.addMessage(new Signal(id,messageType,content));
        }
    }
}