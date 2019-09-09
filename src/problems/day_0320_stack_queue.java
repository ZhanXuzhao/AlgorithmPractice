package problems;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class day_0320_stack_queue {

    @Test
    public void testMyStack() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    @Test
    public void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    class MyStack<E> {
        private Queue<E> mQ1 = new LinkedList<>();
        private Queue<E> mQ2 = new LinkedList<>();

        private Queue<E> getQueueFrom() {
            return !mQ1.isEmpty() ? mQ1 : mQ2;
        }

        private Queue<E> getQueueTo() {
            return mQ1.isEmpty() ? mQ1 : mQ2;
        }

        public void push(E data) {
            getQueueFrom().add(data);
        }

        public E pop() {
            E last = null;
            Queue<E> qFrom = getQueueFrom();
            Queue<E> qTO = getQueueTo();
            while (!qFrom.isEmpty()) {
                E poll = qFrom.poll();
                if (!qFrom.isEmpty()) {
                    qTO.add(poll);
                } else {
                    last = poll;
                }
            }
            return last;
        }

        public E peek() {
            return null;
        }
    }

    class MyQueue<E> {
        private Stack<E> mStack1 = new Stack<>();
        private Stack<E> mStack2 = new Stack<>();

        public void push(E data) {
            mStack1.add(data);
        }

        public E pop() {
            if (mStack2.isEmpty()) {
                while (!mStack1.isEmpty()) {
                    mStack2.push(mStack1.pop());
                }
            }
            return mStack2.pop();
        }
    }
}
