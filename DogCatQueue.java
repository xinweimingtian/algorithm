package linked;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description DogCatQueue 对dogcat队列进行封装，标记入队序号
 * @Author whmAdmin
 * @Date 2018/4/5 11:37 2018
 */
public class DogCatQueue {
    /*猫狗队列 【题目】
    宠物、狗和猫的类如下：
    public class Pet {
        private String type;
        public Pet(String type) {
            this.type = type;
        }
        public String getPetType() {
            return this.type;
        }
    }
    public class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }
    public class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }*/
    /*实现一种狗猫队列的结构，要求如下：
    用户可以调用add方法将cat类或dog类的实例放入队列中；
    用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
    用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出；
    用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出；
    用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例；
    用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
    用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。*/

    // 为了实现方便 所以加了 static
    public static class Pet {
        private String type;
        public Pet(String type) {
            this.type = type;
        }
        public String getPetType() {
            return this.type;
        }
    }
    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }
    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }
    // 以上代码不可以改变

    // 对宠物进行 封装
    public static class PetEnterQueue{
        // 什么宠物
        private  Pet pet;
        // 第几只进入的
        private long index;

        public PetEnterQueue(Pet pet, long count){
            this.pet = pet;
            this.index = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getIndex() {
            return index;
        }
    }

    // DogCat的队列
    public static  class DogCatQueues{
        // dog队列
        private Queue<PetEnterQueue> dogQ;
        // cat队列
        private Queue<PetEnterQueue> catQ;
        // 加入次序
        private long index;

        public DogCatQueues() {
            this.dogQ = new LinkedList<>();
            this.catQ = new LinkedList<>();
            this.index = 0;
        }

        // 添加
        public void add(Pet pet){
            // 添加dog
            if(pet.getPetType().equals("dog")){
                this.dogQ.add(new PetEnterQueue(pet,this.index++));
            // 添加cat
            }else if(pet.getPetType().equals("cat")){
                this.catQ.add(new PetEnterQueue(pet, this.index++));
            }else {
                throw new RuntimeException("err, queue is empty");
            }
        }

        // 弹出全部
        public  Pet pollAll(){
            // dog队列和cat队列都不为空
            if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()){
                // 哪个队列上的大 弹出谁
                if (this.dogQ.peek().getIndex() < this.catQ.peek().getIndex()){
                    return this.dogQ.poll().getPet();
                }else {
                    return this.catQ.poll().getPet();
                }
            // dog队列不为空
            }else if(!this.isDogQueueEmpty()){
                return this.catQ.poll().getPet();
             // cat队列不为空
            }else if(!this.idCatQueueEmpty()){
                return this.dogQ.poll().getPet();
            }else {
                throw new RuntimeException("err, queue is empty");
            }
        }


        // 弹出dog队列
        public Dog pollDog(){
            if(!this.isDogQueueEmpty()){
                return (Dog) this.dogQ.poll().getPet();
            }else {
                throw new RuntimeException("err, queue is empty");
            }
        }

        // 弹出cat队列
        public Cat pollCat(){
            if(this.idCatQueueEmpty()){
                return (Cat) this.catQ.poll().getPet();
            }else {
                throw new RuntimeException("err, queue is empty");
            }
        }

        // 判断dog队列是否为空
        public boolean isDogQueueEmpty(){
            return this.dogQ.isEmpty();
        }

        // 判断cat队列是否为空
        public boolean idCatQueueEmpty(){
            return this.catQ.isEmpty();
        }


    }


}
