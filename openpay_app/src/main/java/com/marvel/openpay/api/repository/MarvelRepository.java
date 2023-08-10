package com.marvel.openpay.api.repository;

import com.marvel.openpay.api.model.MarvelTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarvelRepository extends JpaRepository<MarvelTable, Long>{//
    //List<MarvelTable> findByPublished(boolean published);

    List<MarvelTable> findByTitleContainingIgnoreCase(String title);
}
