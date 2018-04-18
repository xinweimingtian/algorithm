package linked;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description TwoQueuesStack 队列实现栈结构
 * @Author whmAdmin
 * @Date 2018/4/2 21:11 2018
 */
public class TwoQueuesStack {

    //思路：1.两个队列来回倒，每次弹出的时候把队列最后一个值留下弹出。
//            加入的时候直接加入

    private Queue<Integer> queue;
    private Queue<Integer> help;

    public TwoQueuesStack(){
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int pushInt){
        queue.add(pushInt);
    }

    public int peek(){
        if(queue.isEmpty()) {
            throw new RuntimeException("Stack is emptu!");
        }
        while (queue.size() != 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        help.add(res);
        swap();
        return res;
    }

    public int pop(){
        if(queue.isEmpty()){
            throw new RuntimeException("Stack is emptu!");
        }
        while (queue.size() > 1) {
            help.add(queue.poll());
        }
        int res = queue.poll();
        swap();
        return res;
    }

    public void swap(){
        Queue<Integer> temp = queue;
        queue = help;
        queue = temp;
    }

}
