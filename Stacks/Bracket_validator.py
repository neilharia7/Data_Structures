def is_valid(code):
    brackets = {'(' : ')', '{' : '}', '[' : ']'}
    open = frozenset(brackets.keys())
    close = frozenset(brackets.values())
    
    stack = []
    for char in code:
        if char in open:
            stack.append(char)
        elif char in close:
            if not in stack:
                return False
            else:
                 last_bracket = stack.pop()
                 
                 if not open[last_bracket] == char:
                    return False
             
    return stack == []  
    
if __name__ == '__main__':
    code = str(input())
    if is_valid(code):
        print("Success")
