package com.ananthudev.EasyCart.service.notification;

import com.ananthudev.EasyCart.dto.notification.CreateNotificationDTO;
import com.ananthudev.EasyCart.dto.notification.ResponseNotificationDTO;
import com.ananthudev.EasyCart.dto.notification.UpdateNotificationDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface INotificationService {
    List<ResponseNotificationDTO> getAllNotifications();
    ResponseNotificationDTO getNotificationById(Long id);
    ResponseNotificationDTO getNotificationByCustomerId(Long customerId);
    ResponseNotificationDTO sendNotification(CreateNotificationDTO createNotificationDTO);
    ResponseNotificationDTO updateNotification(Long id,UpdateNotificationDTO updateNotificationDTO);
    ResponseEntity<String> deleteNotificationById(Long id);
}
