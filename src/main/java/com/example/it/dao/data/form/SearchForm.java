package com.example.it.dao.data.form;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchForm {

    private Integer id;
    private String name;
    private String email;
    private String typeMusic;

}
