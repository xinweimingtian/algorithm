package linked;

import java.util.Stack;

/**
 * @Description TwoStacksQueue 栈实现队列结构
 * @Author whmAdmin
 * @Date 2018/4/2 22:23 2018
 */
public class TwoStacksQueue {

    //思路：1.要设计两个栈来项目倒东西，入栈是push，倒数栈是pop，从pop栈弹出元素
//         2.push栈给pop导入，一定要倒完，不要剩余
//         3.pop栈不为空，不要导入。

    private Stack<Integer> push;
    private Stack<Integer> pop;

    public TwoStacksQueue(){
        push = new Stack<>();
        pop = new Stack<>();
    }

    private void goTo(){
        if(pop.isEmpty()) {
            while (!push.empty()) {
                pop.push(push.pop());
            }
        }
    }

    public void push(int pushInt){
        push.push(pushInt);
        goTo();
    }

    public int poll(){
        if(pop.empty() && push.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        goTo();
        return pop.peek();
    }

}
