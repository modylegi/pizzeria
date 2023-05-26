package ru.itis.semesterwork.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class CartProductDto  {
    List<ProductDto> list;
}
