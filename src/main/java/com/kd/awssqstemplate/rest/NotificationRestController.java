package com.kd.awssqstemplate.rest;

import com.kd.awssqstemplate.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationRestController {

    private final NotificationService notificationService;

    @GetMapping("/{uid}")
    public Mono<?> findNotificationByUid(@PathVariable String uid) {
         return notificationService.findNotificationByUid(uid);
    }

    @GetMapping("/full/{uid}")
    public Mono<?> findNotificationWithRecipientByUid(@PathVariable String uid) {
        return notificationService.findNotificationWithRecipientByUid(uid);
    }
}
