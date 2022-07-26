module SparseArray where

data Value a = Null | Value a
  deriving (Eq,Read,Show)
data SparseArray a = Vacio | Nodo (Value a) (SparseArray a) (SparseArray a)
  deriving (Eq,Read,Show)

-- Función num2bin: recibe un Int y devuelve una lista con los dígitos de su representación en binario --
num2bin :: Int -> [Bool]
num2bin 0 = [False]
num2bin n = num2binAux n
  where num2binAux :: Int -> [Bool]
        num2binAux 0 = []
        num2binAux n = (num2binAux (div n 2))++[(mod n 2)==1]

-- Función newSparseArray: devuelve un SparseArray vacío --
newSparseArray :: Eq a => SparseArray a
newSparseArray = Vacio

-- Función set: recibe un SparseArray, una posición y un elemento y cambia el valor del SparseArray de dicha posición --
set :: Eq a => SparseArray a -> Int -> a -> SparseArray a
set tree index elem = setL tree (num2bin index) elem

setL :: Eq a => SparseArray a -> [Bool] -> a -> SparseArray a 
setL (Nodo n left right) index elem
 | length(index) == 0 = Nodo (Value elem) (left) (right)
 | head(index) == False = Nodo (n) ( setL (left) (tail(index)) (elem) ) (right)
 | head(index) == True = Nodo (n) (left) ( setL (right) (tail(index)) (elem) ) 

setL Vacio index elem 
 | length(index) == 0 = (Nodo (Value elem) Vacio Vacio)
 | head(index) == False = Nodo (Null) ( setL (Vacio) (tail(index)) (elem) ) (Vacio)
 | head(index) == True = Nodo (Null) (Vacio) ( setL (Vacio) (tail(index)) (elem) )

-- Función get: recibe un SparseArray y una posición y devuelve el elemento del SparseArray en dicha posición --
get :: Eq a => SparseArray a -> Int -> (Value a)
get tree index = getL tree (num2bin index)

getL :: Eq a => SparseArray a -> [Bool]-> Value a
getL Vacio index = getL (Nodo Null Vacio Vacio) index
getL (Nodo n left right) index
 | length(index) == 0 = n
 | head(index) == False = (getL (left) (tail(index)))
 | head(index) == True = (getL (right) (tail(index)))

-- Función delete: recibe un SparseArray y una posición y devuelve el SparseArray resultado de eliminar dicha posición --
--                 También elimina todos los nodos vacíos que resulten de la eliminación                               --
delete :: Eq a => SparseArray a -> Int -> SparseArray a
delete sparse index = deleteL sparse (num2bin index)

deleteL :: Eq a => SparseArray a -> [Bool]-> SparseArray a 
deleteL Vacio index = Vacio
deleteL (Nodo n left right) index
 | length(index) == 0 = deleteAux (Nodo Null left right)
 | head(index) == False = deleteAux( Nodo (n) (deleteL (left) (tail(index))) (right)  )
 | head(index) == True  = deleteAux( Nodo (n) (left) (deleteL (right) (tail(index)))  )

deleteAux :: Eq a => SparseArray a -> SparseArray a
deleteAux Vacio = Vacio
deleteAux (Nodo n left right) 
 | Nodo n left right == Nodo Null Vacio Vacio = Vacio
 | otherwise = Nodo n left right