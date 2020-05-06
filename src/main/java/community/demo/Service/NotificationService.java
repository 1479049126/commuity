package community.demo.Service;

import community.demo.mapper.NotificMapper;
import community.demo.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    NotificMapper notificMapper;
    public List<Notification> findthenotification(String receiver){
        List<Notification> Noti = notificMapper.findthenotification(receiver);
        for (Notification notification:Noti){
            notificMapper.updatestatus(notification.getId());
        }//更新已读状态
        return Noti;
    }

    public void insert(Notification notification) {
        notificMapper.insert(notification);
    }

    public int countreplies(String accountId) {
        return notificMapper.countreplies(accountId);
    }
}
