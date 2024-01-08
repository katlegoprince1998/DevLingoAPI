package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LingoDto {
    private String name;
    private String description;
    private String year_created;
    private String created_by;
    private List<String> usage;
    private String community;

    public LingoDto(String name, String community, String description, String createdBy, String yearCreated, List<String> usage) {
    }
}
