
package com.nordic.demo.demo.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "imageUri"
})
public class Source {

    @JsonProperty("imageUri")
    private String imageUri;

    @JsonProperty("imageUri")
    public String getImageUri() {
        return imageUri;
    }

    @JsonProperty("imageUri")
    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

}
