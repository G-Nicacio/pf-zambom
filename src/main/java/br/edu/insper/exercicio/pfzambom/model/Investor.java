package br.edu.insper.exercicio.pfzambom.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Investor {
    private UUID id = UUID.randomUUID();
    private String name;
    private String broker;
    private BigDecimal amount;
    private String profile; // conservador | moderado | agressivo ...

    public Investor() {}
    public Investor(String name, String broker, BigDecimal amount, String profile) {
        this.name = name; this.broker = broker; this.amount = amount; this.profile = profile;
    }
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getBroker() { return broker; }
    public BigDecimal getAmount() { return amount; }
    public String getProfile() { return profile; }
    public void setName(String n){this.name=n;}
    public void setBroker(String b){this.broker=b;}
    public void setAmount(BigDecimal a){this.amount=a;}
    public void setProfile(String p){this.profile=p;}
}
