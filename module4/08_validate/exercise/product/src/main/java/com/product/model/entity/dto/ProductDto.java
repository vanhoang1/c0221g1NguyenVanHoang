package com.product.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    Integer id;
    @Pattern(regexp = "^SP-[0-9]{4}")
    String name;
    @Min(value = 0,message = "{product.startsWith}")
    Double price;
    @Min(0)
    Integer amount;
    @NotBlank
    String description;
}
