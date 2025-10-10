package com.ananthudev.EasyCart.service.notification;

import com.ananthudev.EasyCart.dto.notification.CreateNotificationDTO;
import com.ananthudev.EasyCart.dto.notification.ResponseNotificationDTO;
import com.ananthudev.EasyCart.dto.notification.UpdateNotificationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService implements INotificationService {
    @Override
    public List<ResponseNotificationDTO> getAllNotifications() {
        return List.of();
    }

    @Override
    public ResponseNotificationDTO getNotificationById(Long id) {
        return null;
    }

    @Override
    public ResponseNotificationDTO getNotificationByCustomerId(Long customerId) {
        return null;
    }

    @Override
    public ResponseNotificationDTO sendNotification(CreateNotificationDTO createNotificationDTO) {
        return null;
    }

    @Override
    public ResponseNotificationDTO updateNotification(Long id, UpdateNotificationDTO updateNotificationDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteNotificationById(Long id) {
        return null;
    }
}
