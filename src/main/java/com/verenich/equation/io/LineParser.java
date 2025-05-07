package com.verenich.equation.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class LineParser {
    private static final Logger logger = LogManager.getLogger(LineParser.class);
    private static final int EXPECTED_PARTS = 3;
    private static final String DELIMITER = "\\s+";

    public Optional<double[]> parseLine(String line) {
        String[] parts = line.trim().split(DELIMITER);

        if (parts.length >= EXPECTED_PARTS) {
            try {
                double a = Double.parseDouble(parts[0]);
                double b = Double.parseDouble(parts[1]);
                double c = Double.parseDouble(parts[2]);
                return Optional.of(new double[]{a, b, c});
            } catch (NumberFormatException e) {
                logger.error("Failed to parse numbers in line '{}'", line, e);
            }
        } else {
            logger.warn("Invalid line format: '{}'", line);
        }

        return Optional.empty();
    }
}
