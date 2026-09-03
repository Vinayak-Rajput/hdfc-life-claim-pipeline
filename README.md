# HDFC Life Claim Pipeline

A Java application demonstrating custom data structures, graph traversal algorithms, concurrent processing, and thread safety for managing HDFC Life claims.

## Compilation and Execution Instructions

### Prerequisites
- Java Development Kit (JDK 8 or higher) installed and configured in system PATH.

### Compile and Run via CLI (Plain Java)

```bash
# Navigate to the project root directory
cd hdfclife-claim-pipeline

# Create the bin directory for compiled class files
mkdir -p bin

# Compile all Java source files
javac -d bin $(find src -name "*.java")

# Run the application
java -cp bin com.hdfclife.Main
```

## Complexity Summary Table

| Feature | Time Complexity | Space Complexity |
|---|---|---|
| Linked List insertAt / deleteAt | O(n) | O(1) |
| List Reverse (Iterative) | O(n) | O(1) |
| List Reverse (Recursive) | O(n) | O(n) |
| Cycle Detection & Cycle Start | O(n) | O(1) |
| Middle Node Finding (Slow / Fast) | O(n) | O(1) |
| Add Two Numbers | O(max(m, n)) | O(max(m, n)) |
| Stack push / pop | O(1) | O(1) |
| Circular Queue enqueue / dequeue | O(1) | O(1) |
| Branch Breadth-First Search (BFS) | O(V + E) | O(V) |

___

## Queue Architecture Analysis: Linked List vs. Fixed Array
A claim queue should be stored in a linked list when processing unbounded or highly volatile traffic volumes, as it expands dynamically without requiring upfront allocation or risking buffer overflow exceptions. Linked lists allow continuous heap utilization and avoid expensive array resizing operations during peak workloads. Conversely, a fixed array is preferred when strict memory bounds are enforced to prevent system out-of-memory errors, when per-node object overhead (pointers and JVM object headers) must be eliminated, or when maximum hardware cache locality and throughput are required for processing millions of high-frequency claims.