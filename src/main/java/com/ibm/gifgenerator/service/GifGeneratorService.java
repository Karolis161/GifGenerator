package com.ibm.gifgenerator.service;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.gifgenerator.entities.Gif;
import com.ibm.gifgenerator.repository.GifGeneratorRepository;
import com.ibm.watson.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.natural_language_understanding.v1.model.Features;
import com.ibm.watson.natural_language_understanding.v1.model.KeywordsOptions;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
public class GifGeneratorService {

    private final GifGeneratorRepository gifGeneratorRepository;

    public GifGeneratorService(GifGeneratorRepository gifGeneratorRepository) {
        this.gifGeneratorRepository = gifGeneratorRepository;
    }

    public List<Gif> getGifs() {
        return gifGeneratorRepository.findAll();
    }

    public Gif generateGif(String inputText, Gif gif) throws Exception {

        Gif gifs = new Gif();
        IamAuthenticator authenticator = new IamAuthenticator("iSz20ix-x-vQbFYetW3g8qv36dJhDgCFGWm2dBXg5FML");
        NaturalLanguageUnderstanding naturalLanguageUnderstanding = new NaturalLanguageUnderstanding("2022-04-07",
                authenticator);
        naturalLanguageUnderstanding.setServiceUrl(
                "https://api.eu-gb.natural-language-understanding.watson.cloud.ibm.com/instances/19fb483c-cd5a-4d63-a578-d4df28eabeaf");

        KeywordsOptions keywords = new KeywordsOptions.Builder()
                .sentiment(true)
                .emotion(true)
                .limit(1)
                .build();

        Features features = new Features.Builder()
                .keywords(keywords)
                .build();

        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(inputText)
                .features(features)
                .language("en")
                .build();

        AnalysisResults response = naturalLanguageUnderstanding
                .analyze(parameters)
                .execute()
                .getResult();

        String relevantKeyword = response.getKeywords().get(0).getText();
        Giphy giphy = new Giphy("VLbzTTd6XSO8Qh67SXhKzYiVIPLxg3l4");
        SearchFeed feed = giphy.search(relevantKeyword, 1, 0);
        URL gifUrl = new URL(feed.getDataList().get(0).getImages().getOriginal().getUrl());

        gifs.setText(relevantKeyword);
        gifs.setGifUrl(gifUrl.toString());

        return gifGeneratorRepository.save(gifs);
    }
}
