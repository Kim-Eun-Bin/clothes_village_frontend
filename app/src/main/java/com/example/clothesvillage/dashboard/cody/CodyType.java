package com.example.clothesvillage.dashboard.cody;

public class CodyType {
    private String name;
    private boolean isSelected;

    public CodyType(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    @Override
    public String toString() {
        return "CodyType{" +
                "name='" + name + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}
