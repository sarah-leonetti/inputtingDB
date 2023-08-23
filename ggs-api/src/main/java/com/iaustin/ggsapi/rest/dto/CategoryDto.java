package com.iaustin.ggsapi.rest.dto;

public record CategoryDto(Long id, String name, Long parent_id, int rank) {}
