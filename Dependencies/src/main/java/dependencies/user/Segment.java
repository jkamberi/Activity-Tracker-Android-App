package dependencies.user;

import dependencies.fileprocessing.gpx.WaypointImpl;

import java.util.ArrayList;

public class Segment {
    public int segmentId;
    public String segmentName;
    public ArrayList<SegmentLeaderboardEntry> leaderboard;
    public ArrayList<WaypointImpl> waypoints;


}