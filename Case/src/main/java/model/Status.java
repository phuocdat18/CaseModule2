package model;

public enum Status {
    SOLD("SOLD"), AVAILABLE("AVAILABLE");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Status getValue1(String value){
        for (Status status:values()) {
            if (status.getValue().equals(value))
                return status;
        }
        throw new IllegalArgumentException("invalid");
    }
}
