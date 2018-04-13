package com.nordic.demo.demo;

import com.google.gson.Gson;
import com.nordic.demo.demo.exception.ImageLabellingException;
import com.nordic.demo.demo.model.*;
import com.squareup.okhttp.*;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class ImageController {
    private int counter = 0;
    private String googleVisionUri = "https://vision.googleapis.com/v1/images:annotate?key=";
    private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private Gson gson = new Gson();

    @CrossOrigin()
    @RequestMapping("/image")
    public ImageLabellingResponse doImageLable(@RequestParam(name="imgUri") String imgUri,
                                            @RequestParam(name="key", defaultValue="wrong") String key) {
        try{
            validateRequest(key, counter, imgUri);

            GoogleLabelResponse googleResponse = getGoogleVisionResponse(imgUri);
            return new ImageLabellingResponse(googleResponse);

        }catch(ImageLabellingException ile){
            return new ImageLabellingResponse(ile.getMessage(), ile.details, 404);
        }catch (Exception e){
            return new ImageLabellingResponse(e.getLocalizedMessage(), e.getMessage(), 404);
        }

    }

    private GoogleLabelResponse getGoogleVisionResponse(String imgUri) throws ImageLabellingException{
        try {
            com.nordic.demo.demo.model.Feature feature = new com.nordic.demo.demo.model.Feature();
            feature.setType("LABEL_DETECTION");

            List features = new ArrayList<com.nordic.demo.demo.model.Feature>();
            features.add(feature);

            Image image = new Image();
            Source source = new Source();
            source.setImageUri(imgUri);
            image.setSource(source);

            com.nordic.demo.demo.model.Request request = new com.nordic.demo.demo.model.Request();
            request.setFeatures(features);
            request.setImage(image);

            List requests = new ArrayList<com.nordic.demo.demo.model.Request>();
            requests.add(request);

            GoogleLabelRequest labelRequest= new GoogleLabelRequest();
            labelRequest.setRequests(requests);

            RequestBody body = RequestBody.create(JSON, gson.toJson(labelRequest));

            Request requestFinal = new Request.Builder()
                    .url(googleVisionUri+Keys.googleVisionApiKey)
                    .post(body)
                    .build();
            Response response = client.newCall(requestFinal).execute();
            String responseString = response.body().string();
            if(responseString.contains("error")){
                throw new ImageLabellingException("GoogleVision reqest failed", "unknown error");
            }
            return gson.fromJson(responseString, GoogleLabelResponse.class);
        } catch (IOException e) {
            throw new ImageLabellingException("GoogleVision reqest failed", e.getMessage());
        }
    }


    private void validateRequest(String key, int counter, String imgUri) throws ImageLabellingException{
        int limit = 500;
        int minUriCharLength = 10;
        String correctLocalApiKey = "ASsdtD34sd23daWedas84f3aHe";

        if(!key.equals(correctLocalApiKey))
            throw new ImageLabellingException("Incorrect API key", "contact admin@nordic.id");

        if(counter++ >= limit)
            throw new ImageLabellingException("No of requests over limit", "Limit is" + limit);

        if(imgUri.length() < minUriCharLength){
            throw new ImageLabellingException("Not valid image URI" ,"Good example: http://mydoggy.rocks/wp-content/uploads/2015/02/French-Bulldog-puppy-wallpaper-3.jpg");
        }

    }



}
