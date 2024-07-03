package com.sosaco.orderfast.enums;

public enum ButtonColor {
    RED ("#E26D5C"),
    GREEN ("#C9CBA3"),
    YELLOW ("#FFE1A8"),
    BROWN ("#754F44"),
    MUSTARD ("#FFCF56"),
    MINT ("#86BAA1");

    private final String rgbColor;

    ButtonColor(String rgbColor) {
        this.rgbColor = rgbColor;
    }

    public String getRgbColor() {
        return rgbColor;
    }
}
