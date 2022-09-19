module Main where

import Data.Char
import System.IO
import SparseArray

--- Carga un fichero de test  ---
loadFile :: FilePath -> IO String
loadFile f = do { putStr ("Loading test file " ++ f ++ "\n"); -- Muestra un mensaje
                  fcontent <- (readFile f);                   -- Leemos el contenido del fichero
                  return fcontent;                            -- Devolvemos el contenido
                }

--- Ejecuta un fichero de test y devuelve la salida ---
exec :: String -> String
exec file = iExec newSparseArray (lines file)
  where iExec :: (SparseArray String) -> [String] -> String
        iExec sa []     = "\n"++(show sa)++"\n\n"
        iExec sa (x:xs) = case i of
                            "SET"    -> "SET "++show(idx)++" "++elem++"\n"++(iExec (set sa idx elem) xs)    -- Instrucción SET
                            "GET"    -> "GET "++show(idx)++": "++valueShow(get sa idx)++"\n"++(iExec sa xs) -- Instrucción GET
                            "DELETE" -> "DELETE "++show(idx)++"\n"++(iExec (delete sa idx) xs)              -- Instrucción DELETE
                            _        -> "ERROR: instrucción \""++i++"\" no definida\n"++(iExec sa xs)       -- Instrucción no definida
          where valueShow :: Show a => Value a -> String -- Muestra Null o el valor del SparseArray
                valueShow Null = "Null"
                valueShow (Value v) = show v
                i :: String                              -- Token con la instrucción
                i = map toUpper (tokens!!0)
                idx :: Int                               -- Índice donde ejecutar la instrucción
                idx = read(tokens!!1)::Int
                elem :: String                           -- Elemento a insertar
                elem = tokens!!2
                tokens :: [String]                       -- Divide la línea en tokens separados por espacios
                tokens = words x

--- Bucle Principal ---
loop :: IO ()
loop = do { putStr "Nombre del fichero de test: ";  -- Muestra un mensaje pidiendo un fichero de test
            hFlush stdout;                          -- Fuerza a que la salida se escriba
            fileName <- getLine;                    -- Lee el nombre del fichero de test
            if ( fileName /= "" )                   -- Si el nombre no es vacío...
               then do { file <- loadFile fileName;    -- Lee el fichero
                         putStr (exec file);           -- Escribe el resultado de la ejecución
                         loop;                         -- Vuelve a ejecutar el bucle principal
                       }
               else do putStr "Game Over.\n";       -- Si el nombre del fichero es vacío -> Fin del programa
          }

--- Función main ---
main :: IO ()
main = do { hSetBuffering stdin LineBuffering;      -- Permite que la entrada pueda ser editada
            loop;                                   -- Ejecuta el bucle principal
          }

