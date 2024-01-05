package com.k2.kafka.cashbackpersistence.service;


import com.k2.kafka.cashbackpersistence.domain.Notification;

public interface NotificationService {

    void publishNotification(Notification notification);
}
