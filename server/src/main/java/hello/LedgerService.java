package hello;

import com.faunadb.client.FaunaClient;
import com.faunadb.client.query.Expr;
import com.faunadb.client.types.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.Collection;

import static com.faunadb.client.query.Language.*;

@Service
public class LedgerService {

    private String LEDGER_CLASS = "main_ledger_class";
    private String INDEX_LEDGER_BY_CLIENT_ID = "ledger_index_client_id";


    private FaunaClient faunaClient;
    private FaunaConfig faunaConfig;

    @Autowired
    public LedgerService(MyFaunaClient faunaClient, FaunaConfig faunaConfig) {
        this.faunaClient = faunaClient.getClient();
        this.faunaConfig = faunaConfig;
        System.out.println("faunaClient = " + faunaClient);
        System.out.println("faunaConfig = " + faunaConfig);
    }

    void addEntry(LedgerEntry ledgerEntry) throws Exception {
        Expr entryValue = Value(ledgerEntry);

        Value result = faunaClient.query(
            Create(
                Class(Value(LEDGER_CLASS)),
                Obj("data", entryValue)
            )
        ).get();
        System.out.println("Stored entry:\n " + result + "\n");
    }

    Collection<LedgerEntry> all(int clientId) throws Exception {

        System.out.println("reading LedgerService all for clientId: " + clientId);

        //Lambda Variable for each ledger entry ref
        String REF_ENTRY_ID = "NXT_ENTRY";

        Value results = faunaClient.query(
            SelectAll(Path("data", "data"),
                Map(
                    Paginate(
                        Match(Index(Value(INDEX_LEDGER_BY_CLIENT_ID)), Value(clientId))
                    ),
                    Lambda(Arr(Value("counter"), Value(REF_ENTRY_ID)), Get(Var(REF_ENTRY_ID))))
            )
        ).get();

        System.out.println("results = " + results);

        Collection<LedgerEntry> allEntries = results.asCollectionOf(LedgerEntry.class).get();
        System.out.println("read " + allEntries.size() + " entries:");

        // if you want to debug easily, convert stream to string and print out
        // String entriesString = allEntries.stream().map(LedgerEntry::toString).reduce("", String::concat);
        // System.out.println("read entries = " + entriesString);

        return allEntries;

    }

    LedgerEntry lastEntry(int clientId) throws Exception {
        Value result = faunaClient.query(
            Select(Value("data"),
                Get(
                    Select(
                        Arr(Value(0), Value(1)),
                        Paginate(
                            Match(Index(Value(INDEX_LEDGER_BY_CLIENT_ID)), Value(clientId))
                        )
                    )
                )
            )
        ).get();

        LedgerEntry ledgerEntry = result.to(LedgerEntry.class).get();
        System.out.println("last ledger entry = " + ledgerEntry);
        return ledgerEntry;
    }

    @PostConstruct
    private void initLedger() throws Exception {
        /*
         * Create the ledger class and index
         */
        Value classResults = faunaClient.query(
            CreateClass(
                Obj("name", Value(LEDGER_CLASS))
            )
        ).get();
        System.out.println("Create Class for " + faunaConfig.getLedgerdb_name() + ":\n " + classResults + "\n");


        Value uniqueConstraintIndex = faunaClient.query(
            CreateIndex(
                Obj(
                    "name", Value("UNIQUE_ENTRY_CONSTRAINT"),
                    "source", Class(Value(LEDGER_CLASS)),
                    "terms", Arr(Obj("field", Arr(Value("data"), Value("clientId")))),
                    "values", Arr(
                        Obj("field", Arr(Value("data"), Value("counter")))),
                    "unique", Value(true)
                )
            )
        ).get();
        System.out.println("Created unique constraint index for " + faunaConfig.getLedgerdb_name() + ":\n " + uniqueConstraintIndex + "\n");


        Value indexResults = faunaClient.query(
            CreateIndex(
                Obj(
                    "name", Value(INDEX_LEDGER_BY_CLIENT_ID),
                    "source", Class(Value(LEDGER_CLASS)),
                    "terms", Arr(Obj("field", Arr(Value("data"), Value("clientId")))),
                    "values", Arr(
                        Obj("field", Arr(Value("data"), Value("counter")), "reverse", Value(true)),
                        Obj("field", Arr(Value("ref"))))
                )
            )
        ).get();
        System.out.println("Created Index for " + faunaConfig.getLedgerdb_name() + ":\n " + indexResults + "\n");

    }
}
