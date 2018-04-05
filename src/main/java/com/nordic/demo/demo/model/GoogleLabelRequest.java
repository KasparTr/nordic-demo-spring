
package com.nordic.demo.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "requests"
})
public class GoogleLabelRequest {

    @JsonProperty("requests")
    private List<Request> requests = null;

    @JsonProperty("requests")
    public List<Request> getRequests() {
        return requests;
    }

    @JsonProperty("requests")
    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }



}
