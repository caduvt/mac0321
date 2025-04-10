from numpy import sqrt

class Poligono:
    def __init__(self, lados):
        self.lados = []
        self.name
        for lado in lados:
            self.lados.append(lado)
        Poligono.qtdPoligonos += 1

    def perimetro(self):
        print ("Meu perímetro é " + str(sum(self.lados)))
    
    def print(self):
        print("Olá! Eu sou um polígono de " + str(len(self.lados)) + " lados: ", str(self.lados))

class Quadrado(Poligono):
    def __init__(self, lado):
        self.name = "Quadrado"
        self.lados = []
        for _ in range(4):
            self.lados.append(lado)

    def area(self):
        print("Minha área é " + str(self.lados[0]**2) + "u")

class Retangulo(Poligono):
    def __init__(self, base, altura):
        self.lados = [base, altura, base, altura]
        self.name = "Retângulo"

    def area(self):
        print("Minha área é " + str(self.lados[0]*self.lados[1]) + "u")
        
class Triangulo(Poligono):
    def __init__(self, l1, l2, l3):
        self.lados = [l1, l2, l3]
        self.name = "Triângulo"

    def area(self):
        s = (self.l1 + self.l2 + self.l3)/2
        print("Minha área é " +
            str(sqrt(s*(s-self.l1)*(s-self.l2)*(s-self.l3)))
        )
    
class TrianguloRetangulo(Triangulo):
    def __init__(self, base, altura):
        self.lados = [base, altura, sqrt(base**2 + altura**2)]
        self.name = "Triângulo Retângulo"
