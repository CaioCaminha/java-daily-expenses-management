package com.caiocaminha.javadailyexpenses.core.application.gateway.controller.admin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
public record OpenAICategoryDto(
        Set<String> description
) {
}
