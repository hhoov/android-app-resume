package com.example.android.justjava;

import android.content.res.Resources;
import android.util.JsonReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {

    public List<MovieData> readJsonStream(String json) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        // Read from file
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, new TypeReference<List<MovieData>>(){});
    }
}
