package fb.meeting_rooms_2;

import java.awt.desktop.PreferencesEvent;
import java.util.*;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<PriorityQueue<I>> rooms = new ArrayList<>();

        for(int[] t : intervals) {
            boolean added = false;
            for (PriorityQueue<I> r:rooms) {
                if (addInSchedule(t, r)) {
                    added = true;
                    break;
                }
            }
            if (!added) {
                PriorityQueue<I> room = new PriorityQueue<I>(Comparator.comparingInt(o -> o.start));
                room.add(new I(t[0], t[1]));
                rooms.add(room);
            }
        }
        return rooms.size();
    }

    private boolean addInSchedule(int[] t, PriorityQueue<I> list) {
        I last = null;
        for(I s: list) {
            if ( (last == null || last.stop <= t[0])
                    && t[1] <= s.start) {
                list.add(new I(t[0], t[1]));
                return true;
            }
            last = s;
        }
        if (last.stop <= t[0]) {
            list.add(new I(t[0], t[1]));
            return true;
        }
        return false;
    }

    static class I {
        int start, stop;

        public I(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
        System.out.println(new Solution().minMeetingRooms(new int[][]{{13,15},{1,13}}));
    }
}
