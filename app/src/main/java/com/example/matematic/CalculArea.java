package com.example.matematic;

public class CalculArea {

    private float result;

    public float getResult() {
        return this.result;
    }

    public void areaCircle(String radius) {
        float r = Float.parseFloat(radius);
        float pi = (float) 3.141592653589793;
        this.result = r * r * pi;
    }

    public void areaSquare(String side) {
        float s = Float.parseFloat(side);
        this.result = s * s;
    }

    public void areaRectangle(String length, String height) {
        float b = Float.parseFloat(length);
        float a = Float.parseFloat(height);
        this.result = b * a;
    }
}
