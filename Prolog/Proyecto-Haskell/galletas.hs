main = do
    putStrLn "Escribe tu nombre"
    name <- getLine
    putStrLn $ primera name 




galletas:: Int -> [(String,Int)] -> String
galletas a (_:b:_) = fst b

primera:: String -> String
primera s = "Hola "++s

bmiTell :: (RealFloat a) => a -> a -> String
bmiTell weight height
    | bmi <= skinny = "Tienes infrapeso ¿Eres emo?"
    | bmi <= normal = "Supuestamente eres normal... Espero que seas feo."
    | bmi <= fat    = "¡Estás gordo! Pierde algo de peso gordito."
    | otherwise     = "¡Enhorabuena, eres una ballena!"
    where bmi = weight / height ^ 2
          skinny = 18.5
          normal = 25.0
          fat = 30.0

initials :: String -> String -> String
initials firstname lastname = [f] ++ ". " ++ [l] ++ "."
    where (f:_) = firstname
          (l:_) = lastname

calcBmis :: (RealFloat a) => [(a, a)] -> [a]
calcBmis xs = [bmi w h | (w, h) <- xs]
    where bmi weight height = weight / height ^ 2


cylinder :: (RealFloat a) => a -> a -> a
cylinder r h =
    let sideArea = 2 * pi * r * h
        topArea = pi * r ^2
    in  sideArea + 2 * topArea   
    

cy :: (RealFloat a) => (a, a) -> a
cy  x =
    let bmi =  snd x ^ 2        
    in  fst x/bmi

sumaDos :: Integer -> [(Integer,Integer)]
sumaDos n = [(x,y) | x <- [1,2..1000],y <- [1,2..1000], x^2 + y^2 == n,x>=y]

maximum' :: (Ord a) => [a] -> a
maximum' [] = error "Máximo de una lista vacía"
maximum' [x] = x
maximum' (x:xs)
    | x > maxTail = x
    | otherwise   = maxTail
    where maxTail = maximum' xs

rep:: Integer -> Integer -> [Integer]
rep a b
 | a <= 0  = []
 | otherwise = [b]++rep (a-1) b

take' :: (Num i, Ord i) => i -> [a] -> [a]
take' 0 _ = []
take' _ [] = []
take' t (x:xs) = x : take' (t-1) xs

rev:: [a] -> [a]
rev [] =[]
rev (x:xs) = rev xs++[x]

zip' :: [a] -> [b] -> [(a,b)]
zip' _ [] = []
zip' [] _ = []
zip' (x:xs) (y:ys) = (x,y):zip' xs ys

elem' :: (Eq a) => a -> [a] -> Bool
elem' _ [] = False
elem' e (x:xs) 
 | e==x = True
 | otherwise = elem' e xs