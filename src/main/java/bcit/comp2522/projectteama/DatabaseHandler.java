package bcit.comp2522.projectteama;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseHandler {

    MongoDatabase database;
    String myCollection;
    private Window window;

    public DatabaseHandler(String username, String password, Window window) {
        this.window = window;
        ConnectionString connectionString = new ConnectionString("mongodb+srv://spaceShoot:spaceshoot@2522project.dtdwv6c.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase("Player");
        //this.database = mongoClient.getDatabase("Enemy");
        this.myCollection = "Player_Score";
        try {
            this.database.createCollection(this.myCollection);
        } catch (Exception e){
            System.out.println("Collection already exists.");
        }

    }
    public void put(String key) {
        Document document = new Document();
        document.append(key, this.window.getCurrentScore());
        new Thread (() -> database.getCollection(myCollection).insertOne(document)).start();
    }






}
