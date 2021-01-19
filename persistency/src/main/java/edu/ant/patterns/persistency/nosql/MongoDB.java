package edu.ant.patterns.persistency.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.ant.patterns.persistency.io.json.AlertLoader;
import edu.ant.patterns.utils.logger.LoggingService;
import org.bson.Document;

public class MongoDB {

    public static void main( String[] args ) {

        try (MongoClient client = new MongoClient()) {
            MongoDatabase db = client.getDatabase("weather_data");
            MongoCollection<Document> collection = db.getCollection("alert");
            // convert json to bson object and insert
            AlertLoader.asAlertsInBulk("src/main/resources/io/bulk_alert.json").stream()
                    .map(DocumentConverter::fromAlert)
                    .forEach(collection::insertOne);
            LoggingService.logMsg(collection.count());

            FindIterable<Document> documents = collection.find();

            for (Document document : documents) {
                LoggingService.logMsg(document.toString());
            }

            client.close();

        }

    }

}
