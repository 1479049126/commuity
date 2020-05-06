package community.demo.dto;

import community.demo.model.Question;

public class NotificationDTO {
    int id;
    String notifier;
    String receiver;
    String outerId;
    int type;
    long gmtcreat;
    int status;
    Question question;
}
