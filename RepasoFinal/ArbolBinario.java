


public class ArbolBinario{

    private class Nodo{

        Integer dato;
        ArbolBinario izq;
        ArbolBinario der;


        public Nodo(Integer dato){

            this.dato = dato;
            izq = new ArbolBinario();
            der = new ArbolBinario();
        }
    }


    Nodo root;

    public Nodo getRoot() {
    return root;
    }


    public void add(Integer dato){

        if(root == null){

            root = new Nodo(dato);
        
        }else if(root.dato < dato){

            root.der.add(dato);
        
        }else if(root.dato > dato){

            root.izq.add(dato);
        }
    }


    public void InOrderTraversal(){

        if(root != null){

            root.izq.InOrderTraversal();

            System.out.println(root.dato +", ");

            root.der.InOrderTraversal();
        }
    }


    public void PreOrderTraversal(){

        if(root != null){

            System.out.println(root.dato +", ");

            root.izq.PreOrderTraversal();

            root.der.PreOrderTraversal();
        }
    }

    
    public void PostOrderTraversal(){

        if(root != null){

            root.izq.PostOrderTraversal();

            root.der.PostOrderTraversal();

            System.out.println(root.dato +", ");
        }
    }


    public boolean borrar(Integer dato){    //PRIMERO BUSCAMOS LUEGO ELIMINAMOS

        if(root == null){
            
            return false;
        }else if(root.dato < dato){

            return root.der.borrar(dato);
        }else if(root.dato > dato){

            return root.izq.borrar(dato);
        }else{

            if(root.der.root == null && root.izq.root == null){ //SI EL QUE QUIERO ELIMINAR NO TIENE HIJOS SIMPLEMENTE LO BORRO

                root = null;
            }else if(root.der.root == null){ //SI TIENE UN HIJO A IZQ O DER SUBO AL HIJO

                root = root.izq.root;
            }else if(root.izq.root == null){

                root = root.der.root;
            } else{                   //SI TIENE DOS HIJOS DEBO ENCONTRAR EL MAYOR ELEMENTO DE LA IZQ O MENOR DE LA DERECHA PARA PONER

                Nodo aux = root.der.root;   //ARBOL DERECHO

                while(aux.izq.root != null){   //SU MINIMO

                    aux = root.izq.root;
                }

                root.dato = aux.dato;   //EL NUEVO VALOR ES ESTE MINIMO

                root.der.borrar(aux.dato);  //BORRO ESE VALOR QUE ACABO DE SUBIR
            }
            return true;
        }
    }




    //A PARTIR DE AQUI SON METODOS PARA TRABAJAR CON EL ARBOL YA QUE ROOT ES PRIVADO, SOLO SON NECESARIOS PARA EL RECORRIDO EN ANCHURA


    public boolean esNulo(){

        if(root == null){
            return true;
        }
        return false;
    }

    public Integer getDato(){

        return root.dato;
    }

    public ArbolBinario getDer(){

        return root.der;
    }

    public ArbolBinario getIzq(){

        return root.izq;
    }


}