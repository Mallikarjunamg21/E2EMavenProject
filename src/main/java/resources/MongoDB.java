package resources;

import static com.mongodb.client.model.Filters.eq;


import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {

	public static void main(String[] args) {

		MongoDB.getCredentials();
	}

	public static String[] getCredentials() {
		String uri = "mongodb+srv://SaaRthiConnecTor:PfLsjTcRnOYNZXvK@shabda.nlsde.mongodb.net/accounts";
		MongoClient mongoClient = MongoClients.create(uri);
	{
		MongoDatabase database = mongoClient.getDatabase("accounts");
		MongoCollection<Document> collection1= database.getCollection("users");
	//	Document document = collection1.find().map("name","Shabda Annotator");
		Document document = new Document("name", "Shabda Annotator");
        String db_username = (String) document.get("userName");
        String db_password = (String) document.get("password");
        System.out.println("Logging using : " + db_username);
        return new String[] {db_username, db_password};
	
	}
	}
}
