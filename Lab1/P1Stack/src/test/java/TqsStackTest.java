import javax.naming.LimitExceededException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TqsStackTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
     void isEmpty() {
        TqsStack<String> stack = new TqsStack<>();

        assertTrue( stack.isEmpty(), "Empty stack should be empty");
    }

    @org.junit.jupiter.api.Test
    void sizeOnConstriction() {
        TqsStack<String> stack = new TqsStack<>();

        assertEquals(0, stack.size());
    }

    @org.junit.jupiter.api.Test
    void sizeAfterNPushes() {
        TqsStack<String> stack = new TqsStack<>();
        stack.push("Aveiro");
        stack.push("Porto");
        stack.push("Lisboa");
        stack.push("Coimbra");
        assertEquals(4, stack.size());
        assertFalse(stack.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void theValuePoped() {
        TqsStack<String> stack = new TqsStack<>();

        stack.push("Aveiro");
        assertEquals("Aveiro",stack.pop());
    }

    @org.junit.jupiter.api.Test
    void pushingandpeeking() {
        TqsStack<String> stack = new TqsStack<>();
        stack.push("Aveiro");
        int tam = stack.size();
        assertEquals("Aveiro",stack.peek());
        assertEquals(tam,stack.size());
    }

    @org.junit.jupiter.api.Test
    void afterNPops() {
        TqsStack<String> stack = new TqsStack<>();

        stack.push("Aveiro");
        stack.push("Porto");
        stack.push("Lisboa");
        stack.push("Coimbra");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(0,stack.size());
        assertTrue(stack.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void poppingEmptyStack() {
        TqsStack<String> stack = new TqsStack<>();

        assertThrows(NoSuchElementException.class, () -> {stack.pop();});
    }

    @org.junit.jupiter.api.Test
    void peekingFromEmptyStack() {
        TqsStack<String> stack = new TqsStack<>();

        assertThrows(NoSuchElementException.class, () -> {stack.peek();});
    }

    @org.junit.jupiter.api.Test
    void boundedStack() {
        TqsStack<String> stack = new TqsStack<>(2);

        stack.push("Aveiro");
        stack.push("Porto");

        assertThrows(IllegalStateException.class, () -> {stack.push("Não dá");});

    }

}