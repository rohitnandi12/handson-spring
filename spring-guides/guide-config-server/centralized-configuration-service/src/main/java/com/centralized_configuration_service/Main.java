package com.centralized_configuration_service;

import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("../file-system-configurations/config-reader-client/config-reader-client-dev.properties");
        if (Files.exists(path)) {
            System.out.println("File exists: " + path.toAbsolutePath());
        } else {
            System.out.println("File does not exist: " + path.toAbsolutePath());
        }
    }
}
