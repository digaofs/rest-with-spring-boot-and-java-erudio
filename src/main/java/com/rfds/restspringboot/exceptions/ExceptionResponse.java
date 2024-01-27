package com.rfds.restspringboot.exceptions;

import java.io.Serializable;
import java.util.Date;

// Class used only to structure exception data
public class ExceptionResponse implements Serializable {

    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
