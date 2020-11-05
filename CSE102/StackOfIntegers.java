package CSE102;

public class StackOfIntegers {
    public static void main(String[] args) {
        IntegersStack stack = new IntegersStack();

        for (int i = 0; i < 10; i++)
            stack.push(i);

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }
    static class IntegersStack{
        private int[] elements;
        private int size = 0;
        public IntegersStack(){
            elements = new int[16];
        }
        public IntegersStack(int capacity){
            elements = new int[capacity];
        }
        public boolean empty(){
            return (size == 0);
        }
        public int peek(){
            return elements[size];
        }
        public int push(int value){
            elements[size] = value;
            size++;
            return value;
        }
        public int pop(){
            int temp = elements[size-1];
            elements[size-1] = 0;
            size--;
            return temp;
        }
        public int getSize() {
            return size;
        }
    }
}
