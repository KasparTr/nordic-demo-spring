
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
    "responses"
})
public class GoogleLabelResponse {

    @JsonProperty("responses")
    private List<Response> responses = null;

    @JsonProperty("responses")
    public List<Response> getResponses() {
        return responses;
    }

    @JsonProperty("responses")
    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

}
