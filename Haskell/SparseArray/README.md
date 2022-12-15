# Práctica Haskell

La práctica consiste en elaborar un programa en Haskell que permita al usuario usar arrays
dispersos y mostrar que se puede acceder y modificar sus elementos en un tiempo logarítmico con
respecto al índice utilizado. Consideraremos que los índices son valores enteros mayores o iguales a
cero.

Se implementarán tres operaciones para trabajar con los arrays dispersos:

1. set: que recibirá un array disperso a, un índice i y un elemento e y devolverá el array
disperso resultado de insertar en a el elemento e bajo el índice i. Si antes de la inserción
hubiera un elemento en a indexado bajo ese mismo índice i, entonces el elemento anterior
se perdería, siendo substituido por e.

2. get: que recibirá un array disperso a y un índice i y devolverá el elemento de a que esté
indexado bajo el índice i. Si no existe, devolverá un valor Null (ver apartado de
implementación).

3. delete: que recibirá un array disperso a y un índice i y devolverá el array disperso
resultado de eliminar de a el elemento indexado bajo el índice i. Si no existiera un elemento
indexado bajo ese índice, se devolverá el array disperso a sin ninguna modificación.
Estos arrays se van a implementar mediante un árbol binario en el que cada nodo (salvo la raíz)
estará asociado a un número entero desde el 0 en adelante. 

Para localizar el nodo correspondiente a un número n, se realiza el siguiente proceso:

  1. Comenzamos el recorrido en el nodo raíz del árbol binario.  
  2. Se recorre la secuencia de dígitos de la representación binaria de la posición buscada, desde el dígito más significativo al menos significativo.
  
    a. Si el dígito es un 0, se desciende por el hijo izquierdo del nodo actual.  
    b. Si el dígito es un 1, se desciende por el hijo derecho del nodo actual.
    
  3. El nodo buscado es el nodo donde termina el camino al haber recorrido todos los dígitos de la secuencia.  

Por ejemplo, si buscamos el nodo número 25, los pasos anteriores serían las siguientes, que se
corresponden con el recorrido gráfico que se puede ver a la derecha:

  1. Comenzamos el recorrido en el nodo raíz del árbol binario y recorremos la secuencia de dígitos de la representación binaria de 25, que es 11001:

    a. Tenemos un 1, descendemos por el hijo derecho.  
    b. Tenemos un 1, descendemos por el hijo derecho.  
    c. Tenemos un 0, descendemos por el hijo izquierdo.  
    d. Tenemos un 0, descendemos por el hijo izquierdo.  
    e. Tenemos un 1, descendemos por el hijo derecho.  

  2. Hemos llegado al nodo buscado.

Para que esto funcione correctamente, la operación set deberá encargarse de añadir tantos nodos como sean necesarios para completar el recorrido desde la raíz al nodo que contendrá el elemento a insertar.
De igual manera, la operación delete se encargará de borrar todos los nodos que ya no sean necesarios tras eliminar el nodo que contenía el elemento borrado.
