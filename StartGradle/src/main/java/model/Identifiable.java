package model;

public interface Identifiable<Tid> {
    void setId(Integer id);

    Integer getId();

    Tid getID();
    void setID(Tid id);
}
