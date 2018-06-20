package hello;

import com.faunadb.client.FaunaClient;
import com.faunadb.client.query.Language;
import com.faunadb.client.types.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static com.faunadb.client.query.Language.*;

@Component
public class MyFaunaClient {

    private FaunaConfig faunaConfig;

    private com.faunadb.client.FaunaClient client;

    public FaunaClient getClient() {
        return client;
    }

    @Autowired
    public MyFaunaClient(FaunaConfig faunaConfig) {
        this.faunaConfig = faunaConfig;
        System.out.println("faunaConfig = " + faunaConfig);
    }

    @PostConstruct
    public void createFaunaClient() throws Exception {

        System.out.println("Connecting with config of = " + faunaConfig);
        /*
         * Create an admin connection to FaunaDB.
         *
         * If you are using the FaunaDB-Cloud version:
         *  - remove the 'withEndpoint' line below
         *  - substitute "secret" for your authentication key's secret
         */
        com.faunadb.client.FaunaClient adminClient = com.faunadb.client.FaunaClient.builder()
            .withEndpoint(faunaConfig.getEndpoint())
            .withSecret(faunaConfig.getSecret())
            .build();

        System.out.println("Successfully connected to FaunaDB as Admin\n");

        /*
         * Create a database
         */

        String ledgerdb_name = faunaConfig.getLedgerdb_name();

        Value dbResults = adminClient.query(
            Do(
                If(
                    Exists(Database(ledgerdb_name)),
                    Delete(Database(ledgerdb_name)),
                    Language.Value(true)
                ),
                CreateDatabase(Obj("name", Language.Value(ledgerdb_name)))
            )
        ).get();

        System.out.println("Successfully created database: " + dbResults.at("name").to(String.class).get() + "\n" + dbResults + "\n");

        /*
         *  Create a client connection to the demo database
         */
        Value keyResults = adminClient.query(
            CreateKey(Obj("database", Database(Language.Value(ledgerdb_name)), "role", Language.Value("server")))
        ).get();

        String key = keyResults.at("secret").to(String.class).get();

        client = adminClient.newSessionClient(key);

        adminClient.close();
    }


    @PreDestroy
    public void deleteDB() throws Exception {

        client.close();

        System.out.println("Disconnected from FaunaDB as Admin!");
    }
}
