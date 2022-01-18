package com.example.it.dao.data.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FormRequest {

    @ApiModelProperty(value = "nombre del usuario", required = true, position = 1)
    @NotBlank(message = "El nombre no puede ser vacío")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    String name;

    @ApiModelProperty(value = "Email del usurio", required = true, position = 2)
    @Email(message = "El campo debe ser un email valido")
    @Size(min = 1, max = 50, message = "El email debe tener entre 1 y 50 caracteres")
    String email;

    @ApiModelProperty(value = "tipo de musica", required = true, position = 3)
    @NotBlank(message = "El tipo de musica no puede ser vacío")
    @Size(min = 1, max = 50, message = "El tipo de musica debe tener entre 1 y 50 caracteres")
    String musicType;
}
