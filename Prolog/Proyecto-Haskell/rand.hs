import System.Random

-- main :: IO()
main = do
    -- Generamos los numeros aleatorios
    a <- randomRIO(1, 6) :: IO Int
    b <- randomRIO(1, 6) :: IO Int
    c <- randomRIO(1, 6)
    d <- randomRIO(1, 6)

    -- los guardamos en una lista
    let numbers = a:[ b, c, d]
    print numbers
