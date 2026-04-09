package com.qaprosoft.carina.core.foundation.api;

import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractApiMethodV2 {

    private final Map<String, String> urlPlaceholders = new HashMap<>();

    protected void replaceUrlPlaceholder(String key, String value) {
        urlPlaceholders.put(key, value);
    }

    public Response callAPIExpectSuccess() {
        Response response = callAPI();
        SuccessfulHttpStatus annotation = this.getClass().getAnnotation(SuccessfulHttpStatus.class);
        if (annotation != null && response.statusCode() != annotation.status()) {
            throw new AssertionError(
                "Expected HTTP status " + annotation.status() + " but got " + response.statusCode()
                + "\nBody: " + response.asString()
            );
        }
        return response;
    }

    public Response callAPI() {
        Endpoint endpoint = this.getClass().getAnnotation(Endpoint.class);
        if (endpoint == null) {
            throw new RuntimeException("@Endpoint annotation missing on " + this.getClass().getName());
        }

        String url = endpoint.url();
        for (Map.Entry<String, String> entry : urlPlaceholders.entrySet()) {
            url = url.replace("${" + entry.getKey() + "}", entry.getValue());
        }

        RequestSpecification request = RestAssured.given();

        RequestTemplatePath reqTemplate = this.getClass().getAnnotation(RequestTemplatePath.class);
        if (reqTemplate != null) {
            try (InputStream is = getClass().getClassLoader().getResourceAsStream(reqTemplate.path())) {
                if (is != null) {
                    String body = new String(is.readAllBytes());
                    request.contentType("application/json").body(body);
                }
            } catch (IOException e) {
                throw new RuntimeException("Failed to load request template: " + reqTemplate.path(), e);
            }
        }

        HttpMethodType method = endpoint.methodType();
        return switch (method) {
            case GET    -> request.get(url);
            case POST   -> request.post(url);
            case PUT    -> request.put(url);
            case PATCH  -> request.patch(url);
            case DELETE -> request.delete(url);
            case HEAD   -> request.head(url);
            default     -> throw new RuntimeException("Unsupported HTTP method: " + method);
        };
    }
}
