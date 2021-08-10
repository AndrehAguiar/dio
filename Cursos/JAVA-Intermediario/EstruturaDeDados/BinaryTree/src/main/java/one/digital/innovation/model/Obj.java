package one.digital.innovation.model;

import java.util.Objects;

public class Obj extends TreeObject<Obj> {

    Integer myValue;

    public Obj(Integer myValue){
        this.myValue = myValue;
    }

    @Override
    public boolean equals(Obj o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(myValue, o.myValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(myValue);
    }

    public int compareTo(Obj other) {
        int i = 0;

        if(this.myValue > other.myValue){
            i = 1;

        }else if(this.myValue < other.myValue){
            i = -1;

        }
        return i;
    }

    public String toString() {
        return myValue.toString();
    }
}
