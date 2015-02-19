package com.bazlur.datastructure.tree;

/**
 * @author Bazlur Rahman Rokon
 * @date 2/19/15.
 */
public class BinaryTree<Type extends Comparable<Type>> {

    private Node<Type> head;
    private int size;

    public void add(Type value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            addTo(head, value);
        }
        size++;
    }

    private void addTo(Node<Type> node, Type value) {
        // case 1: value is less then the current value
        if (value.compareTo(node.getValue()) < 0) {
            if (node.left == null) {
                node.left = new Node<>(value);
            } else {
                addTo(node.left, value);
            }
        } else {
            //case 2: value is equal to or greater than the current value
            if (node.right == null) {
                node.right = new Node<>(value);
            } else {
                addTo(node.right, value);
            }
        }
    }

    public boolean contain(Type value) {
        Node<Type> parent = null;

        return findWithParent(value, parent) != null;
    }

    private Node<Type> findWithParent(Type value, Node<Type> parent) {

        Node<Type> current = head;

        //while we don't have match
        while (current != null) {
            int result = current.compareTo(value);

            if (result > 0) {
                // if the value is less thant the current, go left
                parent = current;
                current = current.left;
            } else if (result < 0) {
                // if the value is more than current, go right
                parent = current;
                current = current.right;
            } else {
                //we have a match 
                break;
            }
        }

        return current;
    }

    public boolean remove(Type value) {
        Node<Type> current, parent = null;
        current = findWithParent(value, parent);

        if (current == null) return false;

        //case 1: if current has no right child, then current's left replace current
        if (current.right == null) {
            if (parent == null) {
                head = current.left;
            } else {
                int result = parent.compareTo(current.value);

                if (result > 0) {
                    // if parent value is greater the current value,
                    // make the current left child a right of parent
                    parent.right = current.left;
                } else if (result < 0) {
                    parent.right = current.left;
                }
            }

        }

        // case 2: if current's right child has no left child, then current's right child replace current
        else if (current.right.left == null) {
            current.right.left = current.left;
            if (parent == null) {
                head = current.right;
            } else {
                int result = parent.compareTo(current.value);
                if (result > 0) {
                    // if parent value is greater than current value
                    // mak ethe current right child a left child of parent
                    parent.right = current.right;
                } else if (result < 0) {
                    // if parent value is less than current value
                    // make the current right child a right child of parent
                    parent.right = current.right;
                }
            }
            // case 3: if current's right child has a left child, replace current with current's right child's left-mos
        } else {
            Node<Type> leftMost = current.right.left;
            Node<Type> leftMostParent = current.right;

            while (leftMost.left != null) {
                leftMostParent = leftMost;
                leftMost = leftMost.left;
            }

            // the parent's left subtree becomes the leftmost's right subtree
            leftMostParent.left = leftMost.right;

            //assign leftmost's left and right to current left and right children
            leftMost.left = current.left;
            leftMost.right = current.right;

            if (parent == null) {
                head = leftMost;
            } else {
                int result = parent.compareTo(current.value);

                if (result > 0) {
                    // parent value is greater than current value
                    // make leftmost the parent's left child 
                    parent.left = leftMost;
                } else if (result < 0) {
                    // parent value is less than current value
                    // make leftmost the parent's right child
                    parent.right = leftMost;
                }
            }
        }

        size--;
        return true;
    }

    class Node<Type extends Comparable<Type>> implements Comparable<Type> {
        private Type value;
        private Node<Type> left;
        private Node<Type> right;

        public Node(Type value) {
            this.value = value;
        }

        public Type getValue() {
            return value;
        }

        public void setValue(Type value) {
            this.value = value;
        }

        public Node<Type> getLeft() {
            return left;
        }

        public void setLeft(Node<Type> left) {
            this.left = left;
        }

        public Node<Type> getRight() {
            return right;
        }

        public void setRight(Node<Type> right) {
            this.right = right;
        }

        @Override
        public int compareTo(Type o) {
            return value.compareTo(o);
        }
    }
}
