package org.techtown.playlist;

public class PlayListItem {
    String name;
    int resId;

    // Generate > Constructor
    public PlayListItem(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    // Generate > Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

}
