package com.ananthudev.EasyCart.controller;

import com.ananthudev.EasyCart.dto.notification.CreateNotificationDTO;
import com.ananthudev.EasyCart.dto.notification.ResponseNotificationDTO;
import com.ananthudev.EasyCart.dto.notification.UpdateNotificationDTO;
import com.ananthudev.EasyCart.service.notification.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public List<ResponseNotificationDTO> getAllNotifications(){
        return notificationService.getAllNotifications();
    }


    @GetMapping("/notifications/{id}")
    public ResponseNotificationDTO getNotificationById(@PathVariable Long id){
        return notificationService.getNotificationById(id);
    }


    @GetMapping("/notifications/customer/{customerId}")
    public ResponseNotificationDTO getNotificationByCustomerId(@PathVariable Long customerId){
        return notificationService.getNotificationByCustomerId(customerId);
    }


    @PostMapping("/notifications")
    public ResponseNotificationDTO sendNotifications(CreateNotificationDTO createNotificationDTO){
        return notificationService.sendNotification(createNotificationDTO);
    }


    @PutMapping("/notifications/{id}")
    public ResponseNotificationDTO updateNotification(Long id,UpdateNotificationDTO updateNotificationDTO){
        return notificationService.updateNotification(id,updateNotificationDTO);
    }

    @DeleteMapping("/notifications/{id}")
    public ResponseEntity<String> deleteNotificationById(Long id){
        return notificationService.deleteNotificationById(id);
    }
}
