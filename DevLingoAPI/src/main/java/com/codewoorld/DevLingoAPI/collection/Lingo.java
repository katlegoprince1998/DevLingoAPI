package com.codewoorld.DevLingoAPI.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "lingo")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Lingo {
    @Id
    private String id;
    private String name;
    private String description;
    private Integer year_created;
    private String created_by;
    private List<String> usage;
    private String community;
    private LingoType lingoType;


}
