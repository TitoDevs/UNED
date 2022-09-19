-- Programas como Funciones --

-- Recursion --
factorial n
  | n <= 0 = 1
  | otherwise = n * factorial (n - 1)

-- Suma --
suma3 x = x + 3

-- Funcion de orden superior --
funCuadrado f x = f x * f x

-- Evaluación Perezosa --

-- Listas potencialmente infinitas --
lista = [1..]
lista2 = 1:2:[3..] -- operando : es el encargado de añadir un nuevo elemento como cabeza de una lista --

-- Listas finitas --
lista3 = [1..3]
lista4 = 1:2:[3..10]

-- Tipos de datos predefinidos --
--   entero = Int o Integer --
--   reales = FLoat o Double --
--   aracteres = char --
--   booleanos = valores de verdad "true o false" --

-- Tipos estructurados --
-- tupla = (Int, [Char], [Bool]) --
tupla = (2, "hola", False)
lista5 = ['c','a','b']
lista6 = 'c':'a':'b':[]

-- Listas definidas por extensión --
list = [1,2,3]
list1 = [5..87]
list2 = [1,3..20]
list3 = [10..]
list4 = [1,3..]

-- Listas definidas por comprensión --
list5 = [p | p <- [1..10], mod p 2 /= 0]

-- Identificadores --
mi_identificador = "correcto"

-- Operadores --
suma a b = a + b
resta c d = c - d
division e f = e / f

-- Patrones constantes --
f 1 = True
f 2 = False

-- Patrones variable --
suma1 a b = a + b

-- Patrones anónimos --
siempre2 x = 2
siempre3 _ = 3

-- Patrones para listas --
suma2 [] = 10
suma4 (x:xs) = x + suma2 xs

-- Patrones para tuplas --
tupla1 a b c = (a, b, c)

-- Patrones con nombre --
duplicaCabeza (x:xs) = x:x:xs
duplicaCabeza1 l@(x:xs) = x:l

-- Patrones aritméticos

-- Expresiones case --

-- Funciones definidas a trozos: guardas --
abs x 
  | x >= 0 = x
  | x < 0 = -x
abs1 x
  | x >= 0 = x
  | otherwise = -x

-- Definiciones locales --
f1 x y = (a + 1) * (c - 1)
   where
      a = div (x + y) 2
      c = mod (x + y) 2

-- Funciones anónimas --
esPar x = mod x 2 == 0

-- La función error --
divide1 a 0 = error "No se puede dividir por 0"
divide2 a b = a / b

-- El tipo de las Funciones --
-- Polimorfismo --
id :: a -> a
id x = x

-- Currificación de funciones y aplicación parcial --
suma6 :: Float -> Float -> Float
suma6 x y = x + y
sum3 :: Float -> Float
sum3 x = suma 3 x
sum4 :: Float -> Float
sum4 = suma 3

-- Funciones de orden superior --
-- aplica1 f x y = f x y -- 
-- f :: a -> b -> c -- 
-- aplica1 :: x -> a -> b -> c --

-- Tipos de Datos Avanzados --
-- El valor indefinido: Bottom --
-- underfined --

-- Sinónimos de tipos: Type --
type Caracter = Char
type String = [Char]
type String2 = [Caracter]
type Complex = (Double, Double)
a :: Complex
a = (2.3, 4.5)

-- Definición de nuevos tipos de datos: data --
-- Tipos enumerados --
data Semaforo = Rojo | Amarillo | Verde
                deriving (Eq,Ord,Show,Read)

-- data Bool = False | True --
-- not :: Bool -> Bool --
-- not True = False --
-- not False = True --

-- Unión de tipos --
-- data BooleanoEntero = Booleano Bool | Entero Integer -- 
-- listaMixta :: [BooleanoEntero] --
-- listaMixta = [Entero 0, Booleano True, Booleano False, Entero -1] --

-- negacion :: BooleanoEntero -> BooleanoEntero --
-- negacion Entero x = -x --
-- negacion Booleano x = not x --

-- Producto cartesiano --
-- data Asignatura = Asig String Integer String --
-- tlp = Asig "Teoria" 2 "hola" --
-- data Asignatura = Asig { nombre :: String, curso :: Integer, web :: String} --
-- tlp = Asig {nombre = "hola", curso = 2, web = "sdf"} --

-- Tipo polimórficos --
-- data TipoMixto a b = Tipo1 a | Tipo2 b --
-- type BooleanoEnter = TipoMixto Bool Integer --
-- ejem :: BooleanoEnter --
-- ejem = False 2 --

-- PARA ÁRBOLES BINARIOS --
-- data ArbBin a = ArbolVacio | Nodo a ArbBin ArbBin --

-- Contar los elementos de una lista --
length1 [] = 0
length1 (x:xs) = 1 + length xs

-- Concatenar listas --
concat1 [] = []
concat1 (xs:yss) = xs ++ (concat yss)

-- Combinar listas --
zip1 (x:xs) (y:ys) = (x,y):(zip xs ys)
zip1 _ _ = []

-- Separar listas --
unzip xs = unzipAux xs ([],[])
  where
    unzipAux [] acumulador = acumulador
    unzipAux ((a,b):xd) (as,bs) = unzipAux xs (as++[a],bs++[b])

-- Aplicar una función a los elementos de una lista --
map1 _ [] = []
map1 f (x:xs) = (f x): (map f xs)
zipWith1 f (a:as) (b:bs) = (f a b):(zipWith f as bs)
iterate1 f x = x:(iterate f (f x))

-- Filtros sobre listas --
-- Coger --
take1 _ [] = []
take1 n (x:xs)
  |n <= 0 = []
  |otherwise = x : take (n-1) xs

-- Descartar --
drop1 _ [] = []
drop1 n (x:xs)
  |n <= 0 = (x:xs)
  | otherwise = drop (n-1) xs

-- Solo Pares --
soloPares1 [] = []
soloPares1 (x:xs)
  |mod x 2 == 0 = x : soloPares1 xs
  |otherwise = soloPares1 xs

-- Filtrar --
filter1 _ [] = []
filter1 p (x:xs)
  |p x = x : (filter1 p xs)
  |otherwise = filter1 p xs

-- Coger elemento si cumple la propiedad --
takeWhile1 _ [] = []
takeWhile1 p (x:xs)
  |p x = x : takeWhile1 p xs
  |otherwise = []

-- Descartar elemento si no cumple la propiedad --
dropWhile1 _ [] = []
dropWhile1 p ys@(x:xs)
  |p x = dropWhile1 p xs
  |otherwise = ys

-- Listas por comprensión --
divisores n = [d | d <- [1..n], mod n d == 0]
primos = [p | p <- [2..10], divisores p == [1,p]]

-- Plegado de listas --
sum1 [] = 0
sum1 (x:xs) = x + sum1 xs

foldr1 f z [] = z
foldr1 f z (x:xs) = f x (foldr f z xs)
sum2 = foldr (+) 0
conct [] = []
conct (xs: yss) = xs ++ (conct yss)

-- Ejemplo Practica --
num2bin n = num2binAux n
  where num2binAux :: Int -> [Bool]
        num2binAux 0 = []
        num2binAux n = (num2binAux (div n 2))++[(mod n 2)==1]