package com.example.weatherfx;

public class Wrapper {
    public Current current;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return current.toString();
    }
}
