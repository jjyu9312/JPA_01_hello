package com.springwook.jpa_01_hello.jpa02;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Data
public class Period {

    LocalDateTime startDate;
    LocalDateTime endDate;

    public Period(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Period() {

    }
}
