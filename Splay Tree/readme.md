# Splay Tree implementation in Java

This is a Java implementation of a Splay Tree. The implementation contains methods for inserting nodes, deleting nodes, and searching for nodes in the tree.

## How to Use

To use the Splay Tree, follow these steps:

1.  Create a new Splay object.

```java
Splay splayTree = new Splay();`
```

2.  Insert a node with a value.

```java
splayTree.insert(5);
```


3.  Delete a node with a value.


```java
splayTree.delete(5);
```

4.  Search for a node with a value.

```java
boolean found = splayTree.search(5);
```

5.  Print the tree in order.

```java
splayTree.printTree();
```


## How it Works

A Splay Tree is a self-adjusting binary search tree with the additional property that recently accessed elements are quick to access again. In this implementation, the Splay Tree is a binary tree with nodes containing values and references to left and right child nodes, as well as a reference to its parent node.

When a node is inserted, the tree is searched for the correct position for the node. Once the node is placed in the tree, the `Splay` function is called on the new node, which moves the node to the root of the tree by performing a series of rotations. This serves to re-balance the tree.

When a node is deleted, the `Splay` function is called on the node to be deleted, moving it to the root of the tree. If the node has two children, the left subtree of the node is attached to the rightmost leaf of the right subtree, and then the left subtree of the node becomes the new root. If the node has only one child, that child becomes the new root. If the node has no children, it is simply removed from the tree.

When searching for a node, the `locateNode` function is called, which performs a simple binary search on the tree for the node with the given value. If the node is found, `locateNode` returns the node. If it is not found, `null` is returned.
