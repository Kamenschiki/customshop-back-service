package com.customshop.back.model.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ResourcesUtils {

    public static String getResourceFile(String path) {
        try {
            return IOUtils.toString(new ClassPathResource(path).getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Can't read file", e);
        }
    }

}