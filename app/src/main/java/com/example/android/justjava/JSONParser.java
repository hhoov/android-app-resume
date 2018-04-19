package com.example.android.justjava;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JSONParser {

    public List<MovieData> readJsonStream(InputStream is) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        // Read from file
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(is, new TypeReference<List<MovieData>>(){});
    }
}
