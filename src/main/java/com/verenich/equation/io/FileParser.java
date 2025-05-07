package com.verenich.equation.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileParser {
    private static final Logger logger = LogManager.getLogger(FileParser.class);

    public List<String> readLinesFromFile(String filename) {
        Path path = Path.of(filename);
        try {
            return Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.error("Error reading file: {}", filename, e);
            return Collections.emptyList();
        }
    }
}
