package br.edu.insper.exercicio.pfzambom.dto;

import java.math.BigDecimal;

public class CreateTripDto {
    public String destination;
    public String startDate; // ISO yyyy-MM-dd
    public String endDate;   // ISO yyyy-MM-dd
    public BigDecimal price;
    public String notes;
}
