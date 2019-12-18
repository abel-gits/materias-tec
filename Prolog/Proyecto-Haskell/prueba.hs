
main = do
  nombre<-prueba
  print nombre
suma x y = x+y

divisible x y = if (x `mod` y) == 0
    then "si son divisibles"
    else "no son divisibles"

esMayor x y = if x > y
    then "es mayor"
    else "no es mayor"

sumaSi x  = if x > 10
 then x + 10
 else x

concatena x = x : [" and sdf sfd"]

musico l = [ x | x <- l ,  x `elem` ["hola","dsf","sfd"]]

may :: [Char] -> [Char]
may st = [ c | c <- st, c `elem` ['A'..'Z']]

factorial :: Integer -> Integer
factorial n = product [1..n]

lucky ::  Integer -> String
lucky 7 = "El siete de la suerte"
lucky x = "Lo siento, no es tu dia de suerte"


charName :: Char -> String
charName 'a' = "Albert"
charName 'b' = "Broseph"
charName 'c' = "Cecil"
charName x = "mal"


addVectors :: (Num a) => (a, a) -> (a, a) -> (a, a)
addVectors (x1, y1) (x2, y2) = (x1 + x2, y1 + y2)

first :: (a, b, c) -> a
first (x, _, _) = x

second :: (a, b, c) -> b
second (_, y, _) = y

third :: (a, b, c) -> c
third (_, _, z) = z

head' :: [a] -> a
head' [] = error "¡Hey, no puedes utilizar head con una lista vacía!"
head' (_:_:x:_) = x



prueba::  IO Int
prueba  =do
  print "Escribe tu nombre:"
  nombre =getInt::Int
  return nombre
  

--getLine :: IO String

repartir::  Integer
repartir = do
    a <- randomRIO(0, 6)
    return a

 rep:: Integer
rep = do
     a <- repartir
     return a


prueba:: IO()  
prueba = do
  print "Escribe la posicion"
  p <- getLine
  print reserva



delete:: [(Integer,Integer)] -> [(Integer,Integer)] -> [(Integer,Integer)]
delete [] l = l
delete (x:xs) l = do
  let n =elim x l 
  delete xs n


elim::(Integer,Integer) -> [(Integer,Integer)] -> [(Integer,Integer)]
elim b l = [ x |x<-l,x/=b]

rep::[(Integer,Integer)]->[(Integer,(Integer,Integer))]
rep x = zip (list x) x
  


mul::(Integer,Integer) -> Integer
mul x = fst x * snd x
       
list:: [(Integer,Integer)] -> [Integer]
list [] = []
list (x:xs) = [mul x]++list xs




deleteDuplicate :: (Eq a) => [a] -> [a]
deleteDuplicate [] = []
deleteDuplicate (x:xs) = x : deleteDuplicate (filter (/= x) xs)
