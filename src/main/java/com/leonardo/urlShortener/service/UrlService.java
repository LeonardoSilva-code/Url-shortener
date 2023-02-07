package com.leonardo.urlShortener.service;


import com.leonardo.urlShortener.model.RequestUrlModel;
import com.leonardo.urlShortener.model.urlModel;
import com.leonardo.urlShortener.repository.UrlModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlModelRepository _urlModelRepository;
    private static int cont = 1;
    private final String URL_PREFIX = "http://localhost:8080/";

    private String base62converter(int n){
        char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuffer shorturl = new StringBuffer();
        while (n > 0){
            shorturl.append(map[n % 62]);
            n = n / 62;
        }
        return shorturl.reverse().toString();
    }

    public RequestUrlModel generateShortenedUrl(String url){
        String shortenedUrl = this.base62converter(cont);
        cont++;
        urlModel urlModelToSave = new urlModel();
        urlModelToSave.setShortenedUrl(shortenedUrl);
        urlModelToSave.setOriginalUrl(url);
        this._urlModelRepository.save(urlModelToSave);
        return new RequestUrlModel((URL_PREFIX + shortenedUrl));
    }

    public RequestUrlModel getOriginalUrl(String shortenedUrl){
        urlModel originalUrl = this._urlModelRepository.findByShortenedUrl(shortenedUrl);
        if (originalUrl == null)  return new RequestUrlModel("no url found");
        return new RequestUrlModel(originalUrl.getOriginalUrl());
    }


}
