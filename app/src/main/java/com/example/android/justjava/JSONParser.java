package com.example.android.justjava;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JSONParser {

    public List<MovieData> readJsonStream(String response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        // Read from file
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(response, new TypeReference<List<MovieData>>(){});
    }
}
