
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
    "mid",
    "description",
    "score",
    "topicality"
})
public class LabelAnnotation {

    @JsonProperty("mid")
    private String mid;
    @JsonProperty("description")
    private String description;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("topicality")
    private Double topicality;

    @JsonProperty("mid")
    public String getMid() {
        return mid;
    }

    @JsonProperty("mid")
    public void setMid(String mid) {
        this.mid = mid;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    @JsonProperty("topicality")
    public Double getTopicality() {
        return topicality;
    }

    @JsonProperty("topicality")
    public void setTopicality(Double topicality) {
        this.topicality = topicality;
    }

}
