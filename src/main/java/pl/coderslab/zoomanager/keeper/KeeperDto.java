package pl.coderslab.zoomanager.keeper;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class KeeperDto {

    @Schema(description = "Keeper id", example = "1")
    private Long id;
    @Schema(description = "Keeper name", example = "Joanna", required = true)
    @NotBlank
    private String name;
    @Schema(description = "Keeper surname", example = "Łukaszewska", required = true)
    @NotBlank
    private String surname;
    @Schema(description = "Keeper address", example = "Grudziądzka 4a/14 Gdańśk", required = true)
    @NotBlank
    private String address;
    @Schema(description = "Keeper phone", example = "510181980", required = true)
    @Range(min = 9, max = 9)
    private int phone;
    @Schema(description = "Keeper email", example = "lukaszewska.asia@gmail.com", required = true)
    @NotBlank
    private String email;
    @Schema(description = "Keeper password", example = "coderslab", required = true)
    @NotBlank
    private String password;
    @Schema(description = "Keeper username", example = "joanna93", required = true)
    @NotBlank
    private String username;

}
