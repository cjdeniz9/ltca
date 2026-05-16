package com.pluralsight.data;

import com.pluralsight.models.Contract;
import com.pluralsight.models.SalesContract;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ContractFileManager {

    private static final Path CONTRACTS_PATH = Path.of("workshop", "dealership", "src", "main", "resources", "contracts.csv");

    public void saveContract(Contract contract) {
        ensureFileExists();

        try (BufferedWriter writer = Files.newBufferedWriter(CONTRACTS_PATH,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            if (contract instanceof SalesContract salesContract) {
                writer.write(salesContract.toCsvLine());
            } else {
                throw new IllegalStateException("Unknown contract type: " + contract.getClass().getName());
            }

            writer.newLine();

        } catch (IOException e) {
            throw new IllegalStateException("Could not save contract to file: " + CONTRACTS_PATH, e);
        }
    }

    private void ensureFileExists() {
        if (!Files.exists(CONTRACTS_PATH)) {
            throw new IllegalStateException("Contracts file not found at: " + CONTRACTS_PATH.toAbsolutePath());
        }
    }
}