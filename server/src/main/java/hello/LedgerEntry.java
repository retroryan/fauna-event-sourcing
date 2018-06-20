package hello;

import com.faunadb.client.types.FaunaConstructor;
import com.faunadb.client.types.FaunaField;


public class LedgerEntry {

    @FaunaField
    private int clientId;
    @FaunaField
    private int counter;
    @FaunaField
    private String type;
    @FaunaField
    private String description;
    @FaunaField
    private Double amount;

    @FaunaConstructor
    public LedgerEntry(@FaunaField("clientId") int clientId, @FaunaField("counter") int counter, @FaunaField("type") String type, @FaunaField("description") String description, @FaunaField("amount") Double amount) {
        this.clientId = clientId;
        this.counter = counter;
        this.type = type;
        this.description = description;
        this.amount = amount;
    }

    public int getClientId() {
        return clientId;
    }

    public int getCounter() {
        return counter;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }


    @Override
    public String toString() {
        return "LedgerEntry{" +
            "clientId='" + clientId + '\'' +
            ", counter=" + counter +
            ", type='" + type + '\'' +
            ", description='" + description + '\'' +
            ", amount=" + amount +
            '}';
    }
}
