package com.codewoorld.DevLingoAPI.collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class LingoType {
    private String lingoType;
    private String description;
}
