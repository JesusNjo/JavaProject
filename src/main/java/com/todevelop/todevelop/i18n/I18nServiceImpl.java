package com.todevelop.todevelop.i18n;


import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
class I18nServiceImpl implements I18nService {
    private static final Logger log = LoggerFactory.getLogger(I18nServiceImpl.class);
    private final MessageSource messageSource;

    public String getMessage(String messageKey, Object... messageArgs) {
        Locale locale = LocaleContextHolder.getLocale();
        log.info("Getting message with Key: {} using Locale: {} with arguments: {}", new Object[]{messageKey, locale.getLanguage(), messageArgs});

        try {
            return this.messageSource.getMessage(messageKey, messageArgs, "No Message", locale);
        } catch (Exception var5) {
            Exception e = var5;
            log.error(e.toString(), e);
            return "No Message";
        }
    }

    public I18nServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
