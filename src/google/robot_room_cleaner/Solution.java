package robot_room_cleaner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    Set<Integer> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        clean(robot, 0, 0);
    }

    boolean clean(Robot robot, int pos, int heading) {
        visited.add(pos);
        robot.clean();

        for (int i = 0; i < 4; i++) {
            int nextPos = switch (heading) {
                case 0 -> pos - 1;
                case 1 -> pos + 1000;
                case 2 -> pos + 1;
                case 3 -> pos - 1000;
                default -> -1;
            };
            if (!visited.contains(nextPos) && robot.move()) {
                clean(robot, nextPos, heading);

            }
            robot.turnRight();
            heading++;
            heading = heading % 4;
        }

        goBack(robot);
        return true;
    }

    public void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

}
