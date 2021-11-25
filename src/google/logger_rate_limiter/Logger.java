package logger_rate_limiter;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/logger-rate-limiter/submissions/
 */
public class Logger {

    private Map<String, Integer> map = new HashMap<>();

    public Logger() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer fromMap = map.get(message);
        if (fromMap == null) {
            map.put(message, timestamp);
            return true;
        } else if (fromMap + 10 > timestamp) {
            return false;
        } else {
            map.put(message, timestamp);
            return true;
        }
    }

}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */