package com.example.matematic;

public class CalculArea {

    public float areaCircle(String radius) {
        float r = Float.parseFloat(radius);
        float result = 0;
        float pi = (float) 3.141592653589793;
        result = r * r * pi;
        return result;
    }

    public float areaSquare(String side) {
        float s = Float.parseFloat(side);
        float result = 0;
        result = s * s;
        return result;
    }
}
