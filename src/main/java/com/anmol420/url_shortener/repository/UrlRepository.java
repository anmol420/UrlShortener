package com.anmol420.url_shortener.repository;

import com.anmol420.url_shortener.domain.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UrlRepository extends JpaRepository<UUID, Url> {
}
