package su.vistar.sample.dto.regular;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CardStatusDto {

    @NonNull
    private Integer id;

    @NonNull
    private String type;

}
