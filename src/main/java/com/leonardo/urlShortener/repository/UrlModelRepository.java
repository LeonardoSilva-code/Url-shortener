package com.leonardo.urlShortener.repository;

import com.leonardo.urlShortener.model.urlModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UrlModelRepository extends CrudRepository<urlModel, UUID> {
    urlModel findByShortenedUrl(String shortenedUrl);
}
