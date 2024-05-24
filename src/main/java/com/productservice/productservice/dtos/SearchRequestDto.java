package com.productservice.productservice.dtos;

import com.productservice.productservice.models.SortParam;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchRequestDto {
    private String query;
    private int pageNumber;
    private int itemPerPage;
    private List<SortParam> sortParams;
}
