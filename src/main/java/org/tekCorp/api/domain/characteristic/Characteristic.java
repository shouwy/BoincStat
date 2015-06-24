package org.tekCorp.api.domain.characteristic;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Created by Inspiron on 15/06/2015.
 */
@Entity
public class Characteristic {

    @EmbeddedId
    private CharacteristicKey id;
    private String value;

    protected Characteristic(){}
    public Characteristic(CharacteristicKey characteristicKey, String value){
        this.id = characteristicKey;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("characteristic[ computerId=%d , element='%s', value='%s' ]", id.getComputerId(), id.getElement(), value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Characteristic)) return false;

        Characteristic that = (Characteristic) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
