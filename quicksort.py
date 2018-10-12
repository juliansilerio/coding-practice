def quicksort(arr):
    if len(arr) == 1:
        return arr
    pivot = int(len(arr)/2)
    arr[0], arr[pivot] = arr[pivot], arr[0]

    right_bound = 1

    for i in range(1,len(arr)):
        if arr[i] < arr[0]:
            arr[i], arr[right_bound] = arr[right_bound], arr[i]
            right_bound += 1

    arr[0], arr[right_bound-1] = arr[right_bound-1], arr[0]

    #print(arr[:right_bound])
    #print(arr[right_bound:])

    #if len(arr)
    if bool(arr[:right_bound-1]):
        arr[:right_bound-1] = quicksort(arr[:right_bound-1])

    if bool(arr[right_bound:]):
        arr[right_bound:] = quicksort(arr[right_bound:])

    #print(arr)
    return arr

def check(arr):
    print(arr)
    print('Checking array')
    for n in range(1,len(arr)):
        if arr[n] < arr[n-1]:
            print('Array not sorted!')
            return False
    print('Array sorted!')
    return True


arr1 = [3,1,4,1,5,9,2,6,5,3]
quicksort(arr1)
check(arr1)

arr2 = [15,14,13,12,11,10,9,8,7,6,5,4,3,2,1]
quicksort(arr2)
check(arr2)
