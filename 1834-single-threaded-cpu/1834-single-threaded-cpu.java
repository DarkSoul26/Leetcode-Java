class Task {
    boolean done = false;

    int index;
    int enqueueTime;
    int processTime;
    Task(int index, int enqueueTime, int processTime) {
        this.index = index;
        this.enqueueTime = enqueueTime;
        this.processTime = processTime;
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        int len = tasks.length;
        PriorityQueue<Task> heap = new PriorityQueue<Task>(len, new Comparator<Task>() {
            public int compare(Task a, Task b) {
                if (a.processTime != b.processTime)
                    return a.processTime - b.processTime;
                    
                return a.index - b.index;
            }
        });
        
        
        Task[] taskList = new Task[len];
        for (int i = 0; i < len; i++) {
            int[] taskArr = tasks[i];
            int enqueueTime = taskArr[0];
            int processTime = taskArr[1];
            Task task = new Task(i, enqueueTime, processTime);
            taskList[i] = task;
        }
        Arrays.sort(taskList, new Comparator<Task>() {
            public int compare(Task a, Task b) {
                return a.enqueueTime - b.enqueueTime;
            }
        });
        
        
        int now = 0;
        int[] result = new int[len];
        int resultIndex = 0;
        
        int taskIndex = 0;
        while (taskIndex < len) {
            if (heap.size() > 0) {
                Task top = heap.poll();
                top.done = true;
                result[resultIndex++] = top.index;
                now += top.processTime;
            }
        
            if (taskList[taskIndex].enqueueTime <= now) {
                for (; taskIndex < len && taskList[taskIndex].enqueueTime <= now; taskIndex++) {
                    Task task = taskList[taskIndex];
                    if (task.done)  continue;
                    
                    heap.offer(task);
                }
            } else {
                if (heap.size() == 0) {
                    now = taskList[taskIndex].enqueueTime;
                }
            }
        }
        while (heap.size() > 0) {
            Task top = heap.poll();
            result[resultIndex++] = top.index;
            top.done = true;
        }
        
        
        return result;
    }
}