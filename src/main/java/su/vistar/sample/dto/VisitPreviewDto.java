package su.vistar.sample.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class VisitPreviewDto {

    @NonNull
    private Integer id;

    @NonNull
    private Date date;

    @NonNull
    private Timestamp updatedAt;

    @NonNull
    private Integer petId;

    @NonNull
    private String petName;

}
