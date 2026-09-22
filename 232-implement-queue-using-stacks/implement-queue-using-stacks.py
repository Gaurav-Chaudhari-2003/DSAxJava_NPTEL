class MyQueue:

    def __init__(self):
        self.stack = []
        self.supporting_stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        for i in range(len(self.stack)):
            self.supporting_stack.append(self.stack.pop())
        
        value = self.supporting_stack.pop()

        for i in range(len(self.supporting_stack)):
            self.stack.append(self.supporting_stack.pop())
        
        return value

    def peek(self) -> int:
        for i in range(len(self.stack)):
            self.supporting_stack.append(self.stack.pop())
        
        value = self.supporting_stack.pop()
        self.supporting_stack.append(value)

        for i in range(len(self.supporting_stack)):
            self.stack.append(self.supporting_stack.pop())
        
        return value
        

    def empty(self) -> bool:
        return len(self.stack) == 0
        


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

#test if the leet and git has been linked?