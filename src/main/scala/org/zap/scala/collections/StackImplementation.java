package org.zap.scala.collections;

public class StackImplementation {

    int[] stackContainer;
    int size;
    int capacity;

    public StackImplementation(int capacity){
     this.stackContainer = new int[capacity];
     this.capacity = capacity;
     this.size = 0;
    }

    void push(int data){
        if(size == capacity){
            throw new RuntimeException("Stack is Full");
        }
        stackContainer[size] = data;
        size++;
    }

    int pop(){
        if(size == 0){
            throw new RuntimeException("Stack is full");
        }
        int data = stackContainer[size - 1];
        size--;
        return data;
    }

    int peek(){
        return stackContainer[size];
    }

    void sort(StackImplementation stack){
        // Can use one more stack
        StackImplementation newStack = new StackImplementation(stack.size);

        while(stack.size != 0){

        }
        newStack.push(stack.pop());
        if(newStack.size != 0){
            if(newStack.peek() < stack.peek()){
                while (newStack.size == 0){
                    stack.push(newStack.pop());
                }
                newStack.push(stack.pop());
            }
        }

    }

    public static void main(String[] args){
        StackImplementation stack = new StackImplementation(5);
        stack.push(3);
        stack.push(10);

        System.out.println();
        stack.push(5);
        stack.push(30);
        stack.push(20);


//        while (stack.size != 0){
//            System.out.print(stack.pop() + " ");
//        }

        stack.sort(stack);

        while (stack.size != 0){
            System.out.print(stack.pop() + " ");
        }
    }

    //
}
