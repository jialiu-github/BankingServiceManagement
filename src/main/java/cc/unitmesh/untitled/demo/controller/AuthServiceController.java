package cc.unitmesh.untitled.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class AuthServiceController {
    private static final String USER_ID_FIELD_NAME = "userId";
    private static final String ACCESS_TOKEN_FIELD_NAME = "accessToken";

    @PostMapping(value = "/generateSessionTokenForUser", produces = "application/json;charset=utf-8")
    CompletableFuture<ResponseEntity<String>> generateSessionTokenForUser(
            final HttpEntity<String> httpEntity) throws JSONException {
        String jsonStr = httpEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode bodyJson = null;
        try {
            bodyJson = mapper.readTree(jsonStr);
        } catch (JsonProcessingException e) {
            return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        if (bodyJson == null) {
            return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        /*
         * Extract userId field
         */
        JsonNode userId = bodyJson.get(USER_ID_FIELD_NAME);
        if (userId == null) {
            return CompletableFuture.completedFuture(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }

        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        return new ResponseEntity<>(buildTokenResponse("token"), HttpStatus.OK);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    private String buildTokenResponse(final String token) throws JSONException {
        JSONObject json = new JSONObject();
        json.put(ACCESS_TOKEN_FIELD_NAME, token);
        return json.toString();
    }
}
