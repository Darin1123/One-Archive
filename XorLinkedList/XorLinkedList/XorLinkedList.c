#include <stdio.h>
#include <stdlib.h>
#define INDEXERROR -1

struct Node {
    int key;
    intptr_t xorptrval;
};

typedef struct Node *NodePtr;

unsigned int *intp2ptr(intptr_t intp) {
    return (unsigned int *) intp;
}

intptr_t xor(intptr_t a, intptr_t b) { return a^b; }

NodePtr createNodePtr(int key) {
    NodePtr node = (NodePtr) malloc(sizeof(struct Node));
    node->key = key;
    node->xorptrval = 0;
    return node;
}

NodePtr add(NodePtr root, const NodePtr z) {
    if (root == NULL) {
        root = z;
        return root;
    }
    
    int count = 1;
    NodePtr current = root;
    NodePtr old = root;
    intptr_t currentVal = current->xorptrval;
    while (currentVal!=0 && currentVal!=(intptr_t) old) {
        NodePtr temp = current;
        if (count) {
            current = intp2ptr(currentVal);
            count=0;
        } else {
            intptr_t nextintp = ((intptr_t)old) ^ currentVal;
            current = intp2ptr(nextintp);
        }
        old = temp;
        currentVal = current->xorptrval;
    }
    current->xorptrval = (current->xorptrval) ^ (intptr_t)z;
    z->xorptrval = (intptr_t) current;
    return root;
}

int get(NodePtr root, int index) {
    int flag = 1;
    NodePtr current = root;
    NodePtr old = root;
    intptr_t currentVal = current->xorptrval;
    while (index>0 && currentVal!=0 && currentVal!=(intptr_t) old) {
        NodePtr temp = current;
        if (flag) {
            current = intp2ptr(currentVal);
            flag=0;
        } else {
            intptr_t nextintp = ((intptr_t)old) ^ currentVal;
            current = intp2ptr(nextintp);
        }
        old = temp;
        currentVal = current->xorptrval;
        index--;
    }
    if (index!=0)
        printf("Error: Index out of range.\n");
    exit(INDEXERROR);
    return current->key;
}

void iterate(NodePtr root) {
    if (root==NULL) {
        printf("Empty List. \n");
        return;
    }
    NodePtr current = root;
    NodePtr old = root;
    int count=1;
    intptr_t currentVal = current->xorptrval;
    while (currentVal!=(intptr_t) old) {
        printf("%d ", current->key);
        NodePtr temp = current;
        if (count) {
            current = intp2ptr(currentVal);
            count=0;
        } else {
            intptr_t nextintp = ((intptr_t)old) ^ currentVal;
            current = intp2ptr(nextintp);
        }
        old = temp;
        currentVal = current->xorptrval;
    }
    
    printf("%d\n", current->key);
}

int main(int argc, char const *argv[])
{
    NodePtr root = NULL;
    
    NodePtr node1 = createNodePtr(1);
    root = add(root, node1);
    
    NodePtr node2 = createNodePtr(3);
    root = add(root, node2);
    
    NodePtr node3 = createNodePtr(2);
    root = add(root, node3);
    
    NodePtr node4 = createNodePtr(4);
    root = add(root, node4);
    
    NodePtr node5 = createNodePtr(5);
    root = add(root, node5);
    
    iterate(root);
    
    printf("%d\n", get(root, -1));
    return 0;
}

/*
 root (node1)               node2                node3                  node4
 ----------------------------------------------------------------------------------
 null                          -                    -                          -            add 1
 1,(intp) 0            2,     0                      -                        -            add 2
 1,(intp) *node2       2,(intp) *node1       3,     0                           -            add 3
 1,(intp) *node2       2,  n1 ^ n3             3, (intp) *node2     4,      0            add 4
 1,(intp) *node2       2,  n1 ^ n3             3,  n2 ^ n4            4, (intp) *node3
 
 */
