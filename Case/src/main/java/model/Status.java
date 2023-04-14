package model;

public enum Status {
    NOTSOLD("NOTSOLD"), SOLD("SOLD");

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
}
