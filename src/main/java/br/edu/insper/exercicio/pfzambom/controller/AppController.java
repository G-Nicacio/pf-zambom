package br.edu.insper.exercicio.pfzambom.controller;

import br.edu.insper.exercicio.pfzambom.dto.CreateInvestorDto;
import br.edu.insper.exercicio.pfzambom.dto.CreateTripDto;
import br.edu.insper.exercicio.pfzambom.model.Investor;
import br.edu.insper.exercicio.pfzambom.model.Trip;
import br.edu.insper.exercicio.pfzambom.repo.InMemoryStore;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AppController {

    // --------- INVESTIDORES ----------
    @PostMapping("/investors")
    public ResponseEntity<Investor> createInvestor(@RequestBody CreateInvestorDto dto) {
        if (dto.name == null || dto.broker == null || dto.amount == null || dto.profile == null) {
            return ResponseEntity.badRequest().build();
        }
        Investor inv = new Investor(dto.name, dto.broker, dto.amount, dto.profile);
        return ResponseEntity.ok(InMemoryStore.saveInvestor(inv));
    }

    @GetMapping("/investors")
    public List<Investor> listInvestors() {
        return InMemoryStore.listInvestors();
    }

    // --------- VIAGENS ----------
    @PostMapping("/trips")
    public ResponseEntity<Trip> createTrip(@RequestBody CreateTripDto dto) {
        if (dto.destination == null || dto.startDate == null || dto.endDate == null) {
            return ResponseEntity.badRequest().build();
        }
        LocalDate ini = LocalDate.parse(dto.startDate);
        LocalDate fim = LocalDate.parse(dto.endDate);
        BigDecimal price = dto.price == null ? BigDecimal.ZERO : dto.price;
        Trip t = new Trip(dto.destination, ini, fim, price, dto.notes);
        return ResponseEntity.ok(InMemoryStore.saveTrip(t));
    }

    @GetMapping("/trips")
    public List<Trip> listTrips() {
        return InMemoryStore.listTrips();
    }

    // Somente ADMIN pode excluir
    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/trips/{id}")
    public ResponseEntity<Trip> deleteTrip(@PathVariable UUID id) {
        Trip removed = InMemoryStore.deleteTrip(id);
        return removed == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(removed);
    }
}
