// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.digitaltwins.core.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHelper {

    /**
     * Loads all json file contents in a path.
     * @param path Path to the target directory.
     * @return List of all file names and their content in map format.
     * @throws IOException If an I/O error is thrown when accessing the starting file.
     */
    public static <T> Map<String, T> loadAllFilesInPath(Path path, Class<T> clazz) throws IOException {
        Map<String, T> fileContents = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Stream<Path> paths = Files.walk(path);
        paths
            .filter(filePath -> filePath.toFile().getName().endsWith(".json"))
            .forEach(filePath -> {
                try {
                    Stream<String> lines = Files.lines(filePath);
                    String fileAsString = lines.collect(Collectors.joining());
                    lines.close();

                    if (clazz == String.class) {
                        // don't deserialize into a type
                        fileContents.put(getFileNameFromPath(filePath), (T) cleanupJsonString(fileAsString));
                    }
                    else {
                        fileContents.put(getFileNameFromPath(filePath), mapper.readValue(cleanupJsonString(fileAsString), clazz));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        return fileContents;
    }

    private static String cleanupJsonString(String jsonString) {
        // Remove newline characters, empty spaces and unwanted unicode characters
        return jsonString.replaceAll("([\\r\\n\\s+\\uFEFF-\\uFFFF])", "");
    }

    private static String getFileNameFromPath(Path path) {
        String fileName = path.getFileName().toString();
        if (fileName.indexOf(".") > 0) {
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
        }

        return fileName;
    }

}
