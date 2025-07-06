package com.star.starry.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil implements ApplicationContextAware {

    private static MessageSource messageSource;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        messageSource = applicationContext.getBean(MessageSource.class);
    }

    public static String getMessage(String code, Locale locale) {
        return messageSource.getMessage(code, null, code, locale);
    }

    public static String getMessage(String code) {
        var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, null, code, locale);
    }
}
