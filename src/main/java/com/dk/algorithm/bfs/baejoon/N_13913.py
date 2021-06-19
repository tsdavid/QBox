from collections import deque
import sys
MAX = 200000
sys.setrecursionlimit(MAX)
"""
    Set the maximum depth of the Python interpreter stack to n.
    
    This limit prevents infinite recursion from causing an overflow of the C
    stack and crashing Python.  The highest possible limit is platform-
    dependent.
    """