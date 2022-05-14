package com.example.tcexample;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("todos")
public record Todo (@Id Long id, String task, String status){}

