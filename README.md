# JAVA_DSA_LeetCode

# Java Collections and Algorithms Cheat Sheet
## Collections Framework

# List
## ArrayList
```
List<Integer> list = new ArrayList<>();
```
Use For: When you need fast random access.

## LinkedList
```
List<Integer> list = new LinkedList<>();
```
Use For: When you need to add/remove elements frequently.

# Set
## HashSet
```
Set<Integer> set = new HashSet<>();
```
Use For: When you need a collection with no duplicates and fast access.

## TreeSet
```
Set<Integer> set = new TreeSet<>();
```
Use For: When you need a sorted set.

# Map
## HashMap
```
Map<Integer, String> map = new HashMap<>();
```
Use For: When you need key-value pairs with fast access.

## TreeMap
```
Map<Integer, String> map = new TreeMap<>();
```
Use For: When you need sorted key-value pairs.

# Sorting Algorithms
## Bubble Sort
```
void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}
```
Use For: Educational purposes, very inefficient for large arrays.

## QuickSort
```
void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi-1);
        quickSort(arr, pi+1, high);
    }
}

int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = (low-1);
    for (int j = low; j <= high-1; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    int temp = arr[i+1];
    arr[i+1] = arr[high];
    arr[high] = temp;
    return (i+1);
}
```
Use For: Large datasets, fast and efficient average-case performance.

## Merge Sort
```
void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }
}

void merge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i=0; i<n1; ++i)
        L[i] = arr[l + i];
    for (int j=0; j<n2; ++j)
        R[j] = arr[m + 1+ j];

    int i = 0, j = 0;
    int k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
```
Use For: Stable sort, good for linked lists and large arrays.

# Searching Algorithms
## Binary Search
```
int binarySearch(int[] arr, int x) {
    int l = 0, r = arr.length - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        if (arr[m] == x)
            return m;
        if (arr[m] < x)
            l = m + 1;
        else
            r = m - 1;
    }
    return -1;
}
```
Use For: Sorted arrays, fast search.

# Algorithms
## Greedy Algorithm
Example: Activity Selection
```
public int maxActivities(int[] start, int[] end) {
    int n = start.length;
    int[][] activities = new int[n][2];
    for (int i = 0; i < n; i++) {
        activities[i][0] = start[i];
        activities[i][1] = end[i];
    }
    Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));
    
    int count = 1;
    int lastEnd = activities[0][1];
    for (int i = 1; i < n; i++) {
        if (activities[i][0] >= lastEnd) {
            count++;
            lastEnd = activities[i][1];
        }
    }
    return count;
}
```
Use For: Problems where local optimal choices lead to a global optimum, like interval scheduling.

## Dynamic Programming
Example: Knapsack Problem
```
public int knapsack(int[] weight, int[] value, int W) {
    int n = weight.length;
    int[][] dp = new int[n + 1][W + 1];
    for (int i = 1; i <= n; i++) {
        for (int w = 0; w <= W; w++) {
            if (weight[i - 1] <= w)
                dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
            else
                dp[i][w] = dp[i - 1][w];
        }
    }
    return dp[n][W];
}
```
Use For: Problems that can be broken down into subproblems with overlapping solutions, like knapsack or matrix chain multiplication.

## Sliding Window
Example: Maximum Sum Subarray of Size K
```
public int maxSumSubarray(int[] arr, int k) {
    int n = arr.length;
    int maxSum = 0;
    int windowSum = 0;
    for (int i = 0; i < k; i++)
        windowSum += arr[i];
    maxSum = windowSum;
    for (int i = k; i < n; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;
}
```
Use For: Problems that involve subarrays or substrings, like finding the maximum sum subarray.

# Graph Algorithms
## BFS and DFS
```
void BFS(int start, List<List<Integer>> adjList) {
    boolean[] visited = new boolean[adjList.size()];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
        int node = queue.poll();
        System.out.print(node + " ");
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                queue.add(neighbor);
                visited[neighbor] = true;
            }
        }
    }
}

void DFS(int node, boolean[] visited, List<List<Integer>> adjList) {
    visited[node] = true;
    System.out.print(node + " ");
    for (int neighbor : adjList.get(node)) {
        if (!visited[neighbor])
            DFS(neighbor, visited, adjList);
    }
```
