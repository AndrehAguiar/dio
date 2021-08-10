package one.digital.innovation;

public class BinaryTree<T extends Comparable<T>> {

    private BinNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(T content) {
        BinNode<T> newNode = new BinNode<T>(content);
        root = insert(root, newNode);
    }

    private BinNode<T> insert(BinNode<T> currentNode, BinNode<T> newNode) {
        /**
         * @params nó raiz/atual, novo nó
         * Se a árvore estiver vazia retorna o novo nó setando-o como nó raiz/atual
         * Se o novo nó for maior que o raiz/atual, o define como próximo nó à direita
         * Se o novo nó for menor que o raiz/atual, o define como próximo nó à esquerda
         * @return nó atual
         **/
        if (currentNode == null) {
            return newNode;

        } else if (newNode.getContent().compareTo(currentNode.getContent()) < 0) {
            currentNode.setLeftNode(
                    insert(currentNode.getLeftNode(), newNode)
            );
        } else {
            currentNode.setRightNode(
                    insert(currentNode.getRightNode(), newNode)
            );
        }
        return currentNode;
    }

    public void showInOrder() {
        System.out.println("\n Showing in order");
        showInOrder(this.root);
    }

    public void showInOrder(BinNode<T> currentNode) {
        if (currentNode != null) {
            showInOrder(currentNode.getLeftNode());
            System.out.print(currentNode.getContent() + ", ");
            showInOrder(currentNode.getRightNode());
        }
    }

    public void showPosOrder() {
        System.out.println("\n Showing pos order");
        showPosOrder(this.root);
    }

    public void showPosOrder(BinNode<T> currentNode) {
        if (currentNode != null) {
            showPosOrder(currentNode.getLeftNode());
            showPosOrder(currentNode.getRightNode());
            System.out.print(currentNode.getContent() + ", ");
        }
    }

    public void showPreOrder() {
        System.out.println("\n Showing pre order");
        showPreOrder(this.root);
    }

    public void showPreOrder(BinNode<T> currentNode) {
        if (currentNode != null) {
            System.out.print(currentNode.getContent() + ", ");
            showPreOrder(currentNode.getLeftNode());
            showPreOrder(currentNode.getRightNode());
        }
    }

    public void remove(T content) {
        try {
            BinNode<T> currentNode = this.root;
            BinNode<T> parentNode = null;
            BinNode<T> childrenNode = null;
            BinNode<T> tempNode = null;

            /**
             * @params conteúdo a ser removido da árvore
             * Percorre a árvore enquanto o nó raiz/atual for:
             * 1 - diferente de nulo
             * 2 - diferente do conteúdo a ser removido
             * ##########################################
             * Se o conteúdo a ser removido for maior que o atual, segue para o nó à direita
             * Senão segue para o nó à esquerda
             */
            while (currentNode != null && !currentNode.getContent().equals(content)) {
                parentNode = currentNode;

                if (content.compareTo(currentNode.getContent()) < 0) {
                    currentNode = currentNode.getLeftNode();

                } else {
                    currentNode = currentNode.getRightNode();
                }
            }

            if ((currentNode == null)) {
                System.out.println("Content not found. Try block");
            }

            if (parentNode == null) {
                if (currentNode.getRightNode() == null) {
                    this.root = currentNode.getLeftNode();

                } else if (currentNode.getLeftNode() == null) {
                    this.root = currentNode.getRightNode();

                } else {
                    for (
                            tempNode = currentNode, childrenNode = currentNode.getLeftNode();
                            childrenNode.getRightNode() != null;
                            tempNode = childrenNode, childrenNode.getLeftNode()
                    ) {
                        if (childrenNode != currentNode.getLeftNode()) {
                            tempNode.setRightNode(childrenNode.getLeftNode());
                            tempNode.setLeftNode(root.getLeftNode());
                        }
                    }
                    childrenNode.setRightNode(root.getRightNode());
                    root = childrenNode;
                }

            } else if (currentNode.getRightNode() == null) {
                if (parentNode.getLeftNode() == currentNode) {
                    parentNode.setLeftNode(currentNode.getLeftNode());

                } else {
                    parentNode.setRightNode(currentNode.getLeftNode());

                }
            } else if (currentNode.getLeftNode() == null) {
                if (parentNode.getLeftNode() == currentNode) {
                    parentNode.setLeftNode(currentNode.getRightNode());

                } else {
                    parentNode.setRightNode(currentNode.getRightNode());

                }
            } else {
                for (
                        tempNode = currentNode, childrenNode = currentNode.getLeftNode();
                        childrenNode.getRightNode() != null;
                        tempNode = childrenNode, childrenNode.getRightNode()
                ) {
                    if (childrenNode != currentNode.getLeftNode()) {
                        tempNode.setRightNode(childrenNode.getLeftNode());
                        childrenNode.setLeftNode(currentNode.getLeftNode());

                    }
                    childrenNode.setRightNode(currentNode.getRightNode());

                    if (parentNode.getLeftNode() == currentNode) {
                        parentNode.setLeftNode(childrenNode);

                    } else {
                        parentNode.setRightNode(childrenNode);
                    }

                }
            }

        } catch (NullPointerException err) {
            System.out.println("Content not found. Catch block");
        }
    }
}
