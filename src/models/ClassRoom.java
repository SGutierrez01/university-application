package models;

public class ClassRoom {
    private int classRoomId;
    private String classRoomLocation;

    public ClassRoom(int classRoomId, String classRoomLocation) {
        this.classRoomId = classRoomId;
        this.classRoomLocation = classRoomLocation;
    }

    public int getClassRoomId() {
        return classRoomId;
    }

    public String getClassRoomLocation() {
        return classRoomLocation;
    }
}

