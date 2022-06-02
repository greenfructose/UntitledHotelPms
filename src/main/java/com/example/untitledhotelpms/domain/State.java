package com.example.untitledhotelpms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "states")
public class State extends BaseEntity{

    private String name;

    public State(Long id, String name) {
        super(id);
        this.name = name;
    }
}
