package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBadgesDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @Autowired
    @JsonProperty("badges")
    private TrelloBadgesDto badgesDto;

    @JsonProperty("shortUrl")
    private String shortUrl;
}
