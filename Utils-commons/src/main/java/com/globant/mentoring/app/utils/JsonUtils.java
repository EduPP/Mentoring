package com.globant.mentoring.app.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public class JsonUtils {

    public static String printInformation(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if(object == null){
            return "Empty";
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    /**
     * Convert object to string using gson library
     * @param object
     * @param onlyExposed, true if only consider attributes with @Expose annotation, false in other case
     * @return JSON String
     * @throws JsonProcessingException
     */
    public static String convertObjectToJSON(Object object, boolean onlyExposed) throws JsonProcessingException {
        Gson gson;
        if (onlyExposed) {
            gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        } else {
            gson = new Gson();
        }
        return gson.toJson(object);
    }

    /**
     * Convert string to object using gson library
     * @param json
     * @param className, class to object convert
     * @return Object in case json string is correct, null in case json parameter is null
     * @throws IOException
     */
    public static Object convertJSONToObject(String json, Class className) throws IOException {
        if(json == null){
            return null;
        }
        Gson gson = new Gson();
        return gson.fromJson(json, className);
    }

}
