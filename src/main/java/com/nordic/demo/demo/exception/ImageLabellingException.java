package com.nordic.demo.demo.exception;

public class ImageLabellingException extends Exception {
    public final String details;

    public ImageLabellingException(String message, String details) {
        super(message);
        this.details = details;
    }


}
