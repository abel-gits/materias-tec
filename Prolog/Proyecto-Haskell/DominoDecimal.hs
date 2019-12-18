--    PROYECTO HASKELL

--    INTEGRANTES :
--    
--     Astorga Ramos Alvaro
--     Ibarra Villegas Juan Luis
--     Robles Montoya Abel 
--
--       Horario : 8-9


import System.Random
todasLasFichas = [(0,0),(0,1),(0,2),(0,3),(0,4),(0,5),(0,6),(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,2),(2,3),(2,4),(2,5),(2,6),(3,3),(3,4),(3,5),(3,6),(4,4),(4,5),(4,6),(5,5),(5,6),(6,6)]
main =  do
    todas <- revolver 1 28 todasLasFichas
    fichas <- repartir 1 28 todas    
    let j1 = take 7 fichas
    let j2 = take 7 (drop 7 fichas)
    putStrLn $ "Fichas del jugador 1: "++(show j1)
    putStrLn " "    
    putStrLn $ "Fichas del jugador 2: "++(show j2)  
    let ini = multriplo5 j1 j2
    let reserva = res fichas todas    
    putStrLn " "
    putStrLn $ "Fichas de reserva: "++(show reserva)
    putStrLn " "
    putStrLn $ "Empieza el jugador :"++(show ini)     
    empezarJuego j1 j2 reserva [] ini 0 0 1
-------------------------FIN DEL MAIN------------------------------------------------------      
jugar:: [(Integer,Integer)]->[(Integer,Integer)]-> [(Integer,Integer)]-> [Integer]-> Int->Integer->Integer->Integer ->IO()
jugar [] _ _ _ _ p1 p2 _ = imprimir p1 p2
jugar _ [] _ _ _ p1 p2 _=  imprimir p1 p2
jugar _ _ [] _ _ p1 p2 _=  imprimir p1 p2
jugar j1 j2 reserva tablero inicio p1 p2 prim = do

   let escoger = escogerF prim j1 tablero
   let escogerFicha = escogerFicha1 j1 tablero reserva escoger
   putStrLn $ "El jugador "++(show inicio)++" puso la ficha: "
   print $ escogerFicha!!0 
   
   let reserva2 = res escogerFicha reserva
   let tablero2 = tableroFichas prim escogerFicha tablero
   let turno = cambiarTurno inicio
    
   putStrLn "Tablero: "
   print tablero2   

   let escoger2 = opcion2 j2 tablero2 
   let escogerFicha2 = escogerFicha1 j1 tablero2 reserva2 escoger2
   putStrLn $ "El jugador "++(show turno)++" puso la ficha: "
   print $ escogerFicha2!!0 
   
   let reserva3 = res escogerFicha2 reserva2
   let tablero3 =  tableroFichas 0 escogerFicha2 tablero2
   let turno2 = cambiarTurno inicio
   let fichasJ1 = nub (fichasJugador inicio j1 j2 escogerFicha escogerFicha2)
   let fichasJ2 = nub (fichasJugador inicio j2 j1 escogerFicha2 escogerFicha)
   let pj1 = puntos inicio p1 p2 tablero2 tablero3
   let pj2 = puntos inicio p2 p1 tablero3 tablero2
   
   putStrLn " "
   putStrLn "Tablero: "
   print tablero3
   putStrLn " "
   putStrLn "Fichas del jugador 1"
   print fichasJ1
   putStrLn "Fichas del jugador 2"
   print fichasJ2
   putStrLn " "
   putStrLn "Reserva "
   print reserva3
   putStrLn " "
   putStrLn $ "Puntos jugador 1: "++(show pj1)
   putStrLn " "
   putStrLn $ "Puntos jugador 2: "++(show pj2) 

   jugar fichasJ1 fichasJ2 reserva3 tablero3 turno2 pj1 pj2 0
   
tomarReserva:: [(Integer,Integer)]-> [Integer]-> [(Integer,Integer)]->[(Integer,Integer)]
tomarReserva _ _ [] = []
tomarReserva f t (r:rx)
 | length (opcion2 [r] t) >0 = opcion2 [r] t++f
 |otherwise = tomarReserva f t rx ++ [r]

delete:: Int->[(Integer,Integer)]->IO [(Integer,Integer)]
delete n l = do      
     return (take (n-1) l++  drop n l)

tomarElemento::Int-> [(Integer,Integer)] ->[(Integer,Integer)]
tomarElemento n  l = take 1 (drop (n-1) l)

io:: IO [(Integer,Integer)]
io = do
    return []

repartir::Int-> Int-> [(Integer,Integer)] ->IO [(Integer,Integer)]
repartir 1 14 _ = io
repartir a b num = do
     n<- randomRIO(a, b)
     let elem = tomarElemento n num
     list <-delete n num
     result<- (repartir a (b-1) list)
     return (result++elem)

multriplo5:: [(Integer,Integer)]-> [(Integer,Integer)] -> Int
multriplo5 j1 j2
     | (5,5) `elem` j1 = 1
     | (5,5) `elem` j2 = 2     
     | (4,6) `elem` j1 = 1
     | (4,6) `elem` j2 = 2     
     | (2,3) `elem` j1 = 1    
     | (2,3) `elem` j2 = 2
     | (1,4) `elem` j1 = 1
     | (1,4) `elem` j2 = 2     
     | (0,5) `elem` j1 = 1
     | (0,5) `elem` j2 = 2
     | otherwise = 1     

fr:: [(Integer,Integer)]->(Integer,Integer) 
fr j1 
     | (5,5) `elem` j1 = (5,5)     
     | (4,6) `elem` j1 = (4,6)     
     | (2,3) `elem` j1 = (2,3)   
     | (1,4) `elem` j1 = (1,4)     
     | (0,5) `elem` j1 = (0,5)
     |otherwise = j1!!0

opcion:: [(Integer,Integer)]  -> [Integer] ->[(Integer,Integer)]
opcion f [] = [fr f]
opcion [] _ = []
opcion (x:xs) t 
 | fst x `elem` t = [x]
 | snd x `elem` t = [(snd x,fst x)]
 | otherwise = opcion xs t


opcion2:: [(Integer,Integer)]  -> [Integer] ->[(Integer,Integer)]
opcion2 f [] = []
opcion2 [] _ = []
opcion2 (x:xs) t 
 | fst x `elem` t = [x]
 | snd x `elem` t = [(snd x,fst x)]
 | otherwise = opcion2 xs t

cuentaTablero:: [Integer] ->Integer
cuentaTablero t 
 | sum t `mod` 5 ==0 = sum t
 | otherwise =0 

res:: [(Integer,Integer)]-> [(Integer,Integer)]-> [(Integer,Integer)]
res _ [] = []
res a (x:xs) 
 | x `notElem` a && rev x `notElem`a = [x]++res a xs
 | otherwise = res a xs 

res2:: [Integer]-> [Integer]-> [Integer]
res2 _ [] = []
res2 a (x:xs) 
 |x `notElem` a = [x]++res2 a xs
 |otherwise = xs


rev:: (Integer,Integer) -> (Integer,Integer)
rev x = (snd x,fst x)

nub :: (Eq a) => [a] -> [a]
nub [] = []
nub (x:xs) = x : nub (filter (/= x) xs)

revolver::Int-> Int-> [(Integer,Integer)] ->IO [(Integer,Integer)]
revolver 1 0 _ = io
revolver a b num = do
     n<- randomRIO(a, b)
     let elem = tomarElemento n num
     list <-delete n num
     result<- (revolver a (b-1) list)
     return (result++elem)

empezarJuego:: [(Integer,Integer)]-> [(Integer,Integer)] ->[(Integer,Integer)]->[Integer]->Int->Integer->Integer-> Integer ->IO()
empezarJuego j1 j2 reserva [] 1 _ _ _ = jugar j1 j2 reserva [] 1 0 0 1
empezarJuego j2 j1 reserva [] 2 _ _ _ = jugar j2 j1 reserva [] 2 0 0 1


escogerF:: Integer -> [(Integer,Integer)] -> [Integer] ->[(Integer,Integer)]
escogerF prim j1 tablero
 | prim == 1  = opcion j1 tablero
 | otherwise = opcion2 j1 tablero


escogerFicha1::[(Integer,Integer)] -> [Integer] ->[(Integer,Integer)]->[(Integer,Integer)]->[(Integer,Integer)]
escogerFicha1 j1 tablero reserva escoger
 | length escoger==0 = tomarReserva j1 tablero reserva
 | otherwise = escoger


tableroFichas:: Integer -> [(Integer,Integer)] -> [Integer] ->[Integer]
tableroFichas prim escogerFicha tablero
 | prim==1&&escogerFicha!!0==(5,5) =[5,5,5,5]
 | prim==1 = [fst (escogerFicha!!0)]++[snd (escogerFicha!!0)]
 | opcion2 [escogerFicha!!0] tablero==[] = tablero
 | otherwise = (res2 [fst (escogerFicha!!0)] tablero )++[snd (escogerFicha!!0)]

puntos:: Int -> Integer -> Integer -> [Integer] -> [Integer] -> Integer
puntos inicio p1 p2 tablero2 tablero3
 | inicio==1 = p1+cuentaTablero tablero2 
 | otherwise = p2+cuentaTablero tablero3


fichasJugador:: Int -> [(Integer,Integer)]-> [(Integer,Integer)]-> [(Integer,Integer)] -> [(Integer,Integer)]-> [(Integer,Integer)]
fichasJugador inicio j1 j2 escogerFicha escogerFicha2 
 | inicio==1 = res [escogerFicha!!0 ] (j1++escogerFicha)
 | otherwise = res [escogerFicha2!!0 ] (j2++escogerFicha2)

cambiarTurno:: Int -> Int
cambiarTurno inicio 
 | inicio==1 = 2
 | otherwise = 1


imprimir:: Integer -> Integer -> IO()
imprimir p1 p2
 | p1>p2 = putStrLn "Gana el jugador 1"
 | p1<p2 = putStrLn "Gana el jugador 2"
 |otherwise  = putStrLn "Es un empate"
-------------------------------------------------------------------------------------------
 



