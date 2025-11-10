package br.edu.insper.exercicio.pfzambom.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Trip {
    private UUID id = UUID.randomUUID();
    private String destination;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal price = BigDecimal.ZERO;
    private String notes = "";

    public Trip() {}
    public Trip(String destination, LocalDate startDate, LocalDate endDate, BigDecimal price, String notes) {
        this.destination = destination; this.startDate = startDate; this.endDate = endDate;
        if (price != null) this.price = price;
        if (notes != null) this.notes = notes;
    }
    public UUID getId(){return id;}
    public String getDestination(){return destination;}
    public LocalDate getStartDate(){return startDate;}
    public LocalDate getEndDate(){return endDate;}
    public BigDecimal getPrice(){return price;}
    public String getNotes(){return notes;}
    public void setDestination(String d){this.destination=d;}
    public void setStartDate(LocalDate d){this.startDate=d;}
    public void setEndDate(LocalDate d){this.endDate=d;}
    public void setPrice(BigDecimal p){this.price=p;}
    public void setNotes(String n){this.notes=n;}
}
