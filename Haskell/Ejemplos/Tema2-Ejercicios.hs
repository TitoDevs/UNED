-- Ejercicio 1 --

-- Lista de los múltiplos de 5 mayores que 7 --
multiplos5a = [p | p <- [7..], mod p 5 == 0]

multiplos5b [] = []
multiplos5b (x:xs)
  |mod x 5 == 0 && x > 7 = x : multiplos5b xs
  |otherwise = multiplos5b xs

-- Lista de los números primos entre 15 y 135 --
numerosPrimosA = [15, 17..135]

numerosPrimosB = [p | p <- [15..135], mod p 2 /= 0]

-- Lista de todos los posibles valores del tipo Bool --
valoresBoolA = [True, False]

-- Lista de todos los cuadrados perfectos --
cuadradosPerfectosA = [1..100]
cuadradosPerfectos = [p | p <- [1..15], p * p /= 0]

-- Lista de los divisores de un número a --
divisores a = [p | p <- a, mod p 2 == 0]

-- Ejercicio 2 --
-- Tipo Enumerado Mes que almacena meses del año --

-- Funciones tiene31dias y tiene30dias con patrones constantes --

-- Funciones tiene31dias y tiene30dias con patrones variables --

-- Ejercicio 5 --
-- Función listapolidivisibles que genere la lista de los números polidivisibles (finita) --

-- Función genera que, dado un número n y una longitud l, genere una lista con números en [10*n..10*n+9] que son divisibles por l --

-- Función siguiente que, dada una lista con los números polidivisibles de n cifras, genere la lista de números polidivisibles de (n + 1) cifras. --
-- Utilice, para ello la función genera. --

-- Una función listapolidivisibles que devuleva la lista de todos los números polidivisibles. Utilice, para ello, la función siguiente. --