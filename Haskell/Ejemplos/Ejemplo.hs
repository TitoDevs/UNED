module Ejemplo where

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

arbol = Nodo Null (Nodo (Value "S") Vacio Vacio) Vacio

arbol1 = Nodo Null Vacio Vacio

newSparse = Nodo Null Vacio Vacio

ejemplo index = tail(num2bin(index))

ejemplo2 ind = length(num2bin(ind))

ejemplo3 i = tail(num2bin(i))

set :: Eq a => SparseArray a -> Int -> a -> SparseArray a
set Vacio index elem = set (Nodo Null Vacio Vacio) index elem
set (Nodo n iz de) index elem
 | index < 0 = Nodo n iz de
 | length(num2bin(index)) == 0 = Nodo (Value elem) (iz) (de)
 | head(num2bin(index)) == False = Nodo (n) (setL (iz) (tail(num2bin(index))) (elem)) (de)
 | head(num2bin(index)) == True = Nodo (n) (iz) (setL (de) (tail(num2bin(index))) (elem)) 
 where setL :: Eq a => SparseArray a -> [Bool] -> a -> SparseArray a 
       setL Vacio index elem = setL (Nodo Null Vacio Vacio) index elem
       setL (Nodo n iz de) index elem
        | length(index) < 0 = Nodo n iz de
        | length(index) == 0 = Nodo (Value elem) (iz) (de)
        | head(index) == False && (iz == Vacio) = Nodo (Null) (setL (Nodo n iz de) (tail(index)) (elem)) (de)
        | head(index) == True && (de == Vacio) = Nodo (Null) (iz) (setL (Nodo n iz de) (tail(index)) (elem)) 
        | head(index) == False = Nodo (n) (setL (iz) (tail(index)) (elem)) (de)
        | head(index) == True = Nodo (n) (iz) (setL (de) (tail(index)) (elem)) 

--get :: Eq a => SparseArray a -> Int -> (Value a)
--get Vacio index = Nodo (Value elem) (Vacio) (Vacio)
