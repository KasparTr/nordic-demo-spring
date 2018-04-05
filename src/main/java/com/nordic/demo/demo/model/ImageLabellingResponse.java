package com.nordic.demo.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageLabellingResponse {

    @JsonProperty("response")
    public GoogleLabelResponse response = null;

    @JsonProperty("errorMsg")
    public String error = null;

    @JsonProperty("details")
    public String details;

    @JsonProperty("code")
    public Integer responseCode;

    public ImageLabellingResponse(GoogleLabelResponse response){
        this.response = response;
        this.details = "success";
        this.responseCode = 200;
    }

    public ImageLabellingResponse(String error, String details, Integer code){
        this.error = error;
        this.details = details;
        this.responseCode = code;
    }
}
