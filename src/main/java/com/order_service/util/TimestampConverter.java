package com.order_service.util;

import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TimestampConverter {
    private static final Logger log = LoggerFactory.getLogger(TimestampConverter.class);

    // Convert from ISO format (with T) to space-separated format
    public String isoToStandard(String isoTimestamp) {
        log.debug("Converting ISO timestamp: {}", isoTimestamp);
        String result = isoTimestamp.replace('T', ' ');
        log.debug("Converted to standard format: {}", result);
        return result;
    }

    // Convert from space-separated to ISO format
    public String standardToIso(String standardTimestamp) {
        log.debug("Converting standard timestamp: {}", standardTimestamp);
        String result = standardTimestamp.replace(' ', 'T');
        log.debug("Converted to ISO format: {}", result);
        return result;
    }
}
