package edu.iu.habahram.ducksservice.model;

public record DuckData(int id, String type) implements Comparable<DuckData{

    @Override
    public int compareTo(DuckData other) {
        DuckType thisType = DuckType.toEnum(this.type().toLowerCase());
        DuckType otherType = DuckType.toEnum(other.type().toLowerCase());
        if (thisType != null && otherType != null) {
            return thisType.compareTo(otherType);
        }
        return 0;
    }

    public String toLine() {
        return String.format("%1$s,%2$s", id(), type());
    }

    public static DuckData fromLine(String line) {
        String[] tokens = line.split(",");
        return new DuckData(Integer.parseInt(tokens[0]), tokens[1]);
    }

}
