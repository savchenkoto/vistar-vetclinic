package su.vistar.sample.dto.regular;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NonNull
    private Integer id;

    @NonNull
    private String type;

}
