package edu.ant.patterns.persistency.nosql;

import edu.ant.patterns.persistency.io.repository.Alert;
import org.bson.Document;

public class DocumentConverter extends Document {

    public static Document fromAlert(Alert alert) {
        return new Document("_id", alert.getId())
                .append("level", alert.getLevel())
                .append("area", alert.getArea())
                .append("type", alert.getType())
                .append("probability", alert.getProbability());
    }

}
