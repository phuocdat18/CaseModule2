package model;

public enum PType {
    EUROPE("EUROPE"), ASIA("ASIA"), AMERICA("AMERICA"), AFRICA("AFRICA");
    ;
    private String value;

    PType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static boolean fromValue(String value) {
        PType[] values = values();
        for (PType type : values) {
            if (type.value.equals(value))
                return true;
        }

        return false;
    }

    public String contains(String type) {
        return type;
    }
    public boolean equalsIgnoreCase(String other) {
        return this.toString().equalsIgnoreCase(other);
    }
    public static PType fromValue1(String value){
        for (PType pType : values()) {
            if (pType.getValue().equals(value))
                return pType;
        }
        throw new IllegalArgumentException("invalid");
    }


}
