from numpy import sqrt

class Poligono:
    qtdPoligonos = 0

    def __init__(self, lados):
        self.lados = []
        Poligono.qtdPoligonos += 1
        self.name = "Polígono " + str(Poligono.qtdPoligonos)
        for lado in lados:
            self.lados.append(lado)

    def perimetro(self):
        print("Meu perímetro é " + str(sum(self.lados)))
    
    # Uma outra forma de fazer isso é usando __str__ e retornando uma string.
    # Isso faz com que print(Poligono) retorne essa string.
    def print(self):
        print("Olá! Eu sou " + self.name + ", de " + str(len(self.lados)) + " lados: ", str(self.lados))

class Quadrado(Poligono):
    def __init__(self, lado):
        Poligono.qtdPoligonos += 1
        self.name = "Quadrado"
        self.lados = []
        for _ in range(4):
            self.lados.append(lado)

    def area(self):
        print("Minha área é " + str(self.lados[0]**2) + "u")

class Retangulo(Poligono):
    def __init__(self, base, altura):
        Poligono.qtdPoligonos += 1
        self.lados = [base, altura, base, altura]
        self.name = "Retângulo"

    def area(self):
        print("Minha área é " + str(self.lados[0]*self.lados[1]) + "u")
        
class Triangulo(Poligono):
    def __init__(self, l1, l2, l3):
        Poligono.qtdPoligonos += 1
        self.lados = [l1, l2, l3]
        self.name = "Triângulo"

    def area(self):
        s = (self.lados[0] + self.lados[1] + self.lados[2])/2
        print("Minha área é " +
            str(sqrt(s*(s-self.lados[0])*(s-self.lados[1])*(s-self.lados[2])))
        )
    
class TrianguloRetangulo(Triangulo):
    def __init__(self, base, altura):
        Poligono.qtdPoligonos += 1
        self.lados = [base, altura, sqrt(base**2 + altura**2)]
        self.name = "Triângulo Retângulo"

if __name__ == "__main__":
    p1 = Poligono([3,3,3,3,3])
    p1.name = p1.name + " (Pent.)"
    p2 = Poligono([3,4,5])
    p2.name = p2.name + " (Tr. Ret.)"
    p3 = Poligono([3,4,3,4])
    p3.name = p3.name + " (Ret.)"
    p4 = Poligono([4,4,4,4])
    p4.name = p4.name + " (Quadrado.)"
    p5 = Retangulo(3,4)
    p6 = Quadrado(4)
    p7 = Triangulo(6,5,5)
    p8 = Triangulo(3,4,5)
    p9 = TrianguloRetangulo(3,4)

    for p in [p1, p2, p3, p4, p5, p6, p7, p8, p9]:
        p.print()
        p.perimetro()
        if isinstance(p, Retangulo) or isinstance(p, Quadrado) or isinstance(p, Triangulo) or isinstance(p, TrianguloRetangulo):
            p.area()