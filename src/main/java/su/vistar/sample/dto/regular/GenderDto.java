package su.vistar.sample.dto.regular;

import lombok.*;
import su.vistar.sample.domain.GenderEntity;

import java.text.CollationElementIterator;
import java.util.Collection;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class GenderDto {

    @NonNull
    private Integer id;

    @NonNull
    private String type;

}
