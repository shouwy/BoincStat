package org.tekCorp.api.domain.characteristic;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Inspiron on 16/06/2015.
 */
@Embeddable
public class CharacteristicKey implements Serializable{

    @Column(nullable = false)
    private String element;
    @Column(nullable = false)
    private Integer computerId;

    protected CharacteristicKey(){}
    public CharacteristicKey(String element, Integer computerId) {
        this.element = element;
        this.computerId = computerId;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Integer getComputerId() {
        return computerId;
    }

    public void setComputerId(Integer computerId) {
        this.computerId = computerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CharacteristicKey)) return false;

        CharacteristicKey that = (CharacteristicKey) o;

        if (!element.equals(that.element)) return false;
        return computerId.equals(that.computerId);
    }

    @Override
    public int hashCode() {
        int result = element.hashCode();
        result = 31 * result + computerId.hashCode();
        return result;
    }
}
