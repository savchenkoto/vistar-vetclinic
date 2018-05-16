package su.vistar.sample.dto.regular;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
public class AnimalDto {

    private Integer id;

    @NotNull
    @NotEmpty
    private String type;

    public AnimalDto(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

}
