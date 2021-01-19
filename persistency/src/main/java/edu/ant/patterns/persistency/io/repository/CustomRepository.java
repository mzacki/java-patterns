package edu.ant.patterns.persistency.io.repository;

import edu.ant.patterns.utils.files.FileReader;
import edu.ant.patterns.utils.logger.LoggingService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class CustomRepository<T extends Entity> {

    private final List<T> entities;

    CustomRepository() {
        entities = streamSource()
                .map(this::parseEntry)
                .collect(Collectors.toList());
    }

    private Stream<String> streamSource() {
        try {
            return FileReader.stream(getSourceFile());
        } catch (IOException e) {
            LoggingService.logError(e);
        }
        return Stream.empty();
    }

    List<T> getEntities() {
        return entities;
    }

    T getById(long id) {
        return entities.stream()
                .filter(e -> e.getId() == id)
                .findFirst().map(this::copy)
                .orElseThrow(() -> new NoSuchElementException("Entity with given id not found: " + id));
    }

    private long getNextId() {
        return entities.stream()
                .mapToLong(Entity::getId)
                .max()
                .orElse(0) + 1;
    }

    void insert(T entity) {
        entity.setId(getNextId());
        entities.add(copy(entity));
        save();
    }

    private void save() {
        List<String> entries = entities.stream()
                .map(this::createEntry)
                .collect(Collectors.toList());
        try {
            Files.write(Paths.get(getSourceFile()), entries);
        } catch (IOException e) {
            LoggingService.logError(e);
        }
    }

    void deleteById(long id) {
        entities.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .ifPresent(e -> {
                    entities.remove(e);
                    save();
                });
    }

    void update(T entity) {
        entities.stream()
                .filter(e -> e.getId() == entity.getId())
                .findFirst()
                .ifPresent(e -> {
                    entities.remove(e);
                    entities.add(copy(entity));
                    save();
                });
    }

    abstract String createEntry(T entity);

    abstract T copy(T entity);

    abstract T parseEntry(String entry);

    abstract String getSourceFile();
}
