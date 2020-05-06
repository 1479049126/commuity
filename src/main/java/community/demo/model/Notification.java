package community.demo.model;

import lombok.Data;

@Data
public class Notification {
    int id;
    String notifier;
    String receiver;
    String outerId;
    int type;
    long gmtcreat;
    int status;
    String description;
    int questionparentid;
}

