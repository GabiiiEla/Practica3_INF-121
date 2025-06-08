'''1. Crea una clase genérica Caja&lt;T&gt; para guardar algún tipo de objeto
a) Agrega métodos guardar() y obtener()
b) Crea dos instancias de la caja y almacena 2 datos de diferente tipo
c) Muestra el contenido de las cajas'''

from typing import TypeVar, Generic
T = TypeVar('T')

class Caja(Generic[T]):
    
    def __init__(self, contenido: T = None):
        self._contenido: T = contenido 

    def guardar(self, item: T) -> None:
        self._contenido = item

    def obtener(self) -> T:
        return self._contenido

    def __str__(self) -> str:
        return f"Caja(contenido={self._contenido}, tipo={type(self._contenido).__name__})"
    
if __name__ == "__main__":
    
    caja_de_texto = Caja[str]() 
    caja_de_texto.guardar("Muchos Libross")
    caja_de_numero = Caja[int]() 
    caja_de_numero.guardar(42) 
    caja_de_lista = Caja[list]()
    caja_de_lista.guardar([1, 2, 3, "a", True]) 
    print(f"Contenido de la primera caja: {caja_de_texto.obtener()}")
    print(f"Detalle de la primera caja: {caja_de_texto}") 
    print(" ")

    print(f"Contenido de la segunda caja: {caja_de_numero.obtener()}")
    print(f"Detalle de la segunda caja: {caja_de_numero}")
    print(" ")

    print(f"Contenido de la tercera caja: {caja_de_lista.obtener()}")
    print(f"Detalle de la tercera caja: {caja_de_lista}")
    print(" ")

    print("\n Intentando guardar un tipo incorrecto (analizado por MyPy) ---")
    caja_de_texto.guardar(100) 
    print(f"Contenido de la primera caja después de guardar un número: {caja_de_texto.obtener()}")

