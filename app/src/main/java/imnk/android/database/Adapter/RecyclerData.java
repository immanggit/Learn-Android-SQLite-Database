package imnk.android.database.Adapter;

public class RecyclerData {

    private String id, summary, description, status;

    public RecyclerData() {
    }

    public RecyclerData(String id, String summary, String description, String status) {
        this.id = id;
        this.description = description;
        this.summary = summary;
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
