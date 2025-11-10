package br.edu.insper.exercicio.pfzambom.repo;

import br.edu.insper.exercicio.pfzambom.model.Investor;
import br.edu.insper.exercicio.pfzambom.model.Trip;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryStore {
    private static final Map<UUID, Investor> INVESTORS = new ConcurrentHashMap<>();
    private static final Map<UUID, Trip> TRIPS = new ConcurrentHashMap<>();

    public static Investor saveInvestor(Investor i){ INVESTORS.put(i.getId(), i); return i; }
    public static List<Investor> listInvestors(){ return new ArrayList<>(INVESTORS.values()); }

    public static Trip saveTrip(Trip t){ TRIPS.put(t.getId(), t); return t; }
    public static List<Trip> listTrips(){ return new ArrayList<>(TRIPS.values()); }
    public static Trip deleteTrip(UUID id){ return TRIPS.remove(id); }
}
