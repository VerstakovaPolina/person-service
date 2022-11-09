package liga.medical.personservice.core.queuelistener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitRouterListener {

    private final RabbitRouterServiceImpl rabbitRouterService;

    public RabbitRouterListener(RabbitRouterServiceImpl rabbitRouterService) {
        this.rabbitRouterService = rabbitRouterService;
    }

    @RabbitListener(queues = QueueNames.DAILY_QUEUE_NAME)
    public void receiveAndRedirectDailyMessage(String message) {
        rabbitRouterService.routeMessage(message);
    }

    @RabbitListener(queues = QueueNames.ALERT_QUEUE_NAME)
    public void receiveAndRedirectAlertMessage(String message) {
        rabbitRouterService.routeMessage(message);
    }

}
