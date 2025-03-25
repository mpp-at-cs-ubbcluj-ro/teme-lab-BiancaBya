package Domain;

import java.util.Objects;

public class Tuple<E1, E2> {

    private E1 e1;
    private E2 e2;

    public Tuple(E1 e1, E2 e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public E1 getLeft() {
        return e1;
    }

    public void setLeft(E1 e1) {
        this.e1 = e1;
    }

    public E2 getRight() {
        return e2;
    }

    public void setRight(E2 e2) {
        this.e2 = e2;
    }

    @Override
    public String toString() {
        return "" + e1 + "," + e2;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tuple<?, ?> other = (Tuple<?, ?>) obj;
        return (Objects.equals(e1, other.e1) && Objects.equals(e2, other.e2)) ||
                (Objects.equals(e1, other.e2) && Objects.equals(e2, other.e1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(e1) + Objects.hash(e2);
    }
}
