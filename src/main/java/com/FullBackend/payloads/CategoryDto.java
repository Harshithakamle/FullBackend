package com.FullBackend.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {


     private long categoryId;
     @NotEmpty
     @Size(min=4,message="must contain atleast 4 charecters")
     private String categoryTitle;
    @NotEmpty
    @Size(min=10,message="must contain atleast 10 charecters")
     private String categoryDesciption;
}
