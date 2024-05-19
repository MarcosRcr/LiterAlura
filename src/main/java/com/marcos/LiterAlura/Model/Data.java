package com.marcos.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record Data(
        @JsonAlias("count")Integer total,
        @JsonAlias("results")List<DataBook> books
) {
}
