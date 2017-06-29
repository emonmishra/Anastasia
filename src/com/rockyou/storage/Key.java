package com.rockyou.storage;

import java.io.Serializable;

public class Key implements StorableEntity, Serializable {

    private static final long serialVersionUID = 7526471155622776147L;

    @Override
    public int hashCode() {

        //TODO: logic for hashcode

        return 1;
    }

    @Override
    public boolean equals(Object o) {

        //TODO: logic to compare, probably at bytes/string

        return true;
    }

    public String encode() {

        return null;
    }

    public String decode() {

        return null;
    }
}
