package yangyuc.ducksservice.model;

public enum Type {
    MALLARD, REDHEAD, RUBBER_DUCK, DECOY_DUCK;

    @Override
    public String toString() {
        return name().replace("_", " ");
    }
}
