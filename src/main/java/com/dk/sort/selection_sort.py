# Selection Sort
def selection_sort(A):
    n = len(A)  # length
    for i in range(n - 1):
        least = i  # temporary value for saving index.
        for j in range(i + 1, n):  # inner for loop. to compare with i and other index.
            if A[j] < A[least]:  # comparator
                least = j  # Update least variable.

        # Change Index and Values
        A[i], A[least] = A[least], A[i]
        printStep(A, i + 1)


def printStep(arr, val):
    print("   Step  %2d = " % val, end='')
    print(arr)


if __name__ == '__main__':
    # Test Code.
    a = [1, 3, 5]
    print(a)
    a[1], a[2] = a[2], a[1]
    print(a)

    data = [5, 3, 8, 4, 9, 1, 6, 2, 7]
    print("Original : ", data)
    selection_sort(data)
    print("Selction Sort : ", data)
