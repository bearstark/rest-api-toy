package me.jordy.toy.schedular.vo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SiteDto {

    @NotEmpty
    String name;

    @NotEmpty
    String url;


    String elements;
}
