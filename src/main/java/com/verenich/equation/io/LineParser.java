package com.verenich.equation.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class LineParser {
    private static final Logger logger = LogManager.getLogger(LineParser.class);
    private static final int EXPECTED_PARTS = 3;
    private static final String DELIMITER = "\\s+";

    public Optional<double[]> parseLine(String line) {
        Optional<double[]> result = Optional.empty();

        // Проверка негативных случаев
        if (line == null || line.trim().isEmpty()) {
            logger.warn("Line is null or empty");
            return result;
        }

        String[] parts = line.trim().split(DELIMITER);
        if (parts.length < EXPECTED_PARTS) {
            logger.warn("Invalid line format, expected at least {} parts, got {}: '{}'",
                    EXPECTED_PARTS, parts.length, line);
            return result;
        }

        if (parts.length >= EXPECTED_PARTS) {
            try {
                double a = Double.parseDouble(parts[0]);
                double b = Double.parseDouble(parts[1]);
                double c = Double.parseDouble(parts[2]);
                result = Optional.of(new double[]{a, b, c});
                return result;
            } catch (NumberFormatException e) {
                logger.error("Failed to parse numbers in line '{}'", line, e);
                return result;
            }
        }

        return result; // Этот return фактически не достигается из-за условий выше
    }
}