package com.kd.awssqstemplate.rest;

import com.kd.awssqstemplate.service.RecipientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipients")
public class RecipientRestController {

    private final RecipientService recipientService;

    @GetMapping("/{uid}")
    public Mono<?> findRecipientByUid(@PathVariable String uid) {
         return recipientService.findRecipientWithNotificationsByUid(uid);
    }
}
