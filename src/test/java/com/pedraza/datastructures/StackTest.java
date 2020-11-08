package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class StackTest extends TestBase {
    
    Stack<Integer> stack;

    @Test
    public void sizeShouldBeZeroWhenNew() {
        stack = new Stack<Integer>();
        assertEquals(0, stack.size());
    }

    @Test
    public void sizeShouldBeUpdatedWhenPushing() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
    }

    @Test
    public void sizeShouldBeUpdatedWhenPopping() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void sizeShouldBeUpdatedWhenPushingAndPopping() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.push(6);
        assertEquals(2, stack.size());
    }

    @Test
    public void tailShouldBeUpdatedWhenPushing() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        Integer tail = getTailValue();
        assertEquals((Integer)2, tail);
    }

    @Test
    public void tailShouldBeUpdatedWhenPopping() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        Integer tail = getTailValue();
        assertEquals((Integer)1, tail);
    }

    @Test
    public void popShouldReturnRemovedValue() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        Integer value = stack.pop();
        assertEquals((Integer)2, value);
    }

    @Test
    public void peekShouldReturnTailValue() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        Integer value = stack.peek();
        Integer tail = getTailValue();
        assertEquals(value, tail);
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoItems() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenItems() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void sizeShouldReturnNodeCount() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
    }

    @Test
    public void sizeShouldBeZeroWhenNoItems() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void sizeShouldBeNotZeroWhenItems() {
        stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertEquals(1, stack.size());
    }

    private Integer getTailValue() {
        Object tail = (Object) getField(stack, "tail");
        Integer value = (Integer) getField(tail, "value");
        return value;
    }
}
