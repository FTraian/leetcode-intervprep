package medium.task_scheduler;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

public class Solution {

    public int leastInterval(char[] tasks, int n) {
        LinkedList<Task> taskList = new LinkedList<>();
        for (char c:tasks) {
            taskList.stream()
                    .filter(task -> task.c == c)
                    .findFirst()
                    .ifPresentOrElse(task -> task.size++, () -> taskList.add(new Task(c, 1, 0)));
        }

        int runnedTasks = 0, steps = 0;
        while(runnedTasks < tasks.length) {
            Optional<Task> t = taskList.stream()
                    .filter(task -> task.cooldown <= 0)
                    .filter(task -> task.size > 0)
                    .max((o1, o2) -> o1.size - o2.size);

            if (t.isPresent()) {
                t.get().size--;
                t.get().cooldown = n + 1;
                runnedTasks++;
            } else {
            }
            for (Task t1:taskList) {
                t1.cooldown--;
            }
            steps++;
        }
        return steps;
    }

    class Task{
        char c;
        int size;
        int cooldown;

        Task(char c, int size, int cooldown) {
            this.c = c;
            this.size = size;
            this.cooldown = cooldown;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

}
