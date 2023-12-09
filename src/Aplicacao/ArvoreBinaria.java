package Aplicacao;

import java.util.Stack;

public class ArvoreBinaria {

    int info;
    ArvoreBinaria direita = null;
    ArvoreBinaria esquerda = null;

    public static void Imp_Ordem(ArvoreBinaria tree) {
        if (tree == null) {
            return;
        }

        Stack<ArvoreBinaria> stack = new Stack<>();
        ArvoreBinaria current = tree;

        // traverse the tree
        while (current != null || !stack.isEmpty()) {
            // reach the left most Node of the current Node
            while (current != null) {
                // place pointer to a tree node on the stack before traversing the node's left subtree
                stack.push(current);
                current = current.esquerda;
            }

            // backTrack from the empty subtree and visit the node at the top of the stack;
            // however, if the stack is empty you are done
            current = stack.pop();
            System.out.println(current.info);

            // we have visited the node and its left subtree. Now, it's right subtree's turn
            current = current.direita;
        }
    }

    public static void Imp_Pos(ArvoreBinaria tree) {
        if(tree != null) {
            Imp_Pos(tree.direita);
            Imp_Pos(tree.esquerda);
            System.out.println(tree.info);
        }
    }

    public static void Imp_Pre(ArvoreBinaria tree) {
        if(tree != null) {
            System.out.println(tree.info);
            Imp_Pre(tree.esquerda);
            Imp_Pre(tree.direita);
        }
    }

    public static ArvoreBinaria Busca(ArvoreBinaria tree, int valor) {
        if(tree == null) {
            return null; //Chegou numa folha e não tem subarcos abaixo, ultimo elemento
        } else if(tree.info > valor) {
            return(Busca(tree.esquerda, valor));
        } else if(tree.info < valor) {
            return(Busca(tree.direita, valor));
        } else {
            return(tree);
        }
    }

    public static boolean BuscaValor(ArvoreBinaria tree, int valor) {
        if(tree == null) {
            return false; //Chegou numa folha e não tem subarcos abaixo, ultimo elemento
        } else if(tree.info > valor) {
            return(BuscaValor(tree.esquerda, valor));
        } else if(tree.info < valor) {
            return(BuscaValor(tree.direita, valor));
        } else {
            return true;
        }
    }

    public static ArvoreBinaria VerificaVazio(ArvoreBinaria tree) {
        if(tree == null) {
            return null;
        } else {
            return(tree);
        }
    }

    public static ArvoreBinaria InsereRaiz(ArvoreBinaria tree, int valor) { //Arvóre vazia
        tree.info = valor;
        tree.direita = null;
        tree.esquerda = null;
        return(tree);
    }

    public static ArvoreBinaria Insere(ArvoreBinaria tree, int valor) {
        ArvoreBinaria newNode = new ArvoreBinaria();
        newNode.info = valor;
        newNode.direita = null;
        newNode.esquerda = null;

        if (tree == null) {
            tree = newNode;
        } else {
            ArvoreBinaria current = tree;
            ArvoreBinaria parent;
            while (true) {
                parent = current;
                if (valor < current.info) {
                    current = current.esquerda;
                    if (current == null) {
                        parent.esquerda = newNode;
                        break;
                    }
                } else {
                    current = current.direita;
                    if (current == null) {
                        parent.direita = newNode;
                        break;
                    }
                }
            }
        }

        return tree;
    }

    public static ArvoreBinaria Retira(ArvoreBinaria tree, int valor) {
        if(tree == null) {
            System.out.println("Elemento não encontrado: " + valor);
            return(null);
        } else if(tree.info > valor) {
            tree.esquerda = Retira(tree.esquerda, valor);
        } else if(tree.info < valor) {
            tree.direita = Retira(tree.direita, valor);
        } else {
            //Nó sem filhos
            if((tree.esquerda == null) && (tree.direita == null)) {
                tree = null;
            } else if(tree.esquerda == null) {
                //Nó só tem filho a direita
                ArvoreBinaria novo = tree;
                tree = tree.direita;
            } else if(tree.direita == null) {
                //Só tem filho a esquerda
                ArvoreBinaria novo = tree; //Novo receber o endereço da árvore
                tree = tree.esquerda; //Arvore recebe o elemento da esquerda
            } else {
                //Nó tem dois filhos
                //Logica do predecessor
                ArvoreBinaria novo = tree.esquerda;//primeira esquerda
                while(novo.direita != null) { //Depois toda a direita
                    novo = novo.direita;
                }
                tree.info = novo.info; //Troca as informações de lugar de lugar
                novo.info = valor;// retira a referencia
            }
        }

        return(tree);
    }

}