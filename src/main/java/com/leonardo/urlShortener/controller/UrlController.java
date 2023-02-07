package com.leonardo.urlShortener.controller;


import com.leonardo.urlShortener.model.RequestUrlModel;
import com.leonardo.urlShortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    @Autowired
    private UrlService _urlService;

    @PostMapping("/getUrl")
    RequestUrlModel getUrl(@RequestBody RequestUrlModel url){
        return this._urlService.generateShortenedUrl(url.url);
    }

    @GetMapping("/{url}")
    RequestUrlModel getUrl(@PathVariable String url){
        return this._urlService.getOriginalUrl(url);
    }
}
