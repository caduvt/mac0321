class Endereco {
    String logradouro;
    String complemento;
    int numero;
    int cep;
    String estado;
    String cidade;
}

public class Cliente {
    String nome;
    int cpf;
    int rg;
    Endereco endereco;
    boolean especial;

    public static void main(String[] args) {
        Cliente maria = new Cliente(
            "Maria",
            123456,
            654321,
            "Avenida Politénica",
            "Próximo à Poli",
            52,
            999999,
            "São Paulo",
            "SP"
        );

        Cliente joao = new Cliente(
            "João",
            121212,
            212121,
            "Avenida Politénica",
            "Próximo à Poli",
            52,
            999999,
            "São Paulo",
            "SP"
        );

        ClienteEspecial jorge = new ClienteEspecial(
            "Jorge",
            787878,
            878787,
            "Avenida Brasil",
            "Próximo ao Bandeco",
            13,
            11111,
            "São Paulo",
            "SP"
        );

        ContaPoupanca poupancaJoao = new ContaPoupanca("Itaú", 8888, joao);
        ContaPreferencial preferencialJorge = new ContaPreferencial("Crefisa", 0000, jorge);
        Conta conjunta = new Conta(null, 0, jorge);

    }

    Cliente(
        String nome,
        int cpf,
        int rg,
        String logradouro,
        String complemento,
        int numero,
        int cep,
        String cidade,
        String estado
    ) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco.logradouro = logradouro;
        this.endereco.complemento = complemento;
        this.endereco.numero = numero;
        this.endereco.cep = cep;
        this.endereco.cidade = cidade;
        this.endereco.estado = estado;
    }

    void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("RG: " + rg);
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Cliente especial? Não");
        System.out.println("");
    }
}

public class ClienteEspecial extends Cliente {
    ClienteEspecial(
        String nome,
        int cpf,
        int rg,
        String logradouro,
        String complemento,
        int numero,
        int cep,
        String cidade,
        String estado
    ) {
        super(
            nome,
            cpf,
            rg,
            logradouro,
            complemento,
            numero,
            cep,
            cidade,
            estado
        );
    }

    void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("RG: " + rg);
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nome);
        System.out.println("Cliente especial? Não");
        System.out.println("");
    }
}

public class Conta {
    String agencia;
    int numero;
    float saldo;
    Cliente cliente;
    double taxa;

    Conta(String agencia, int numero, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0;
        this.cliente = cliente;
        this.taxa = 0.1;
    }
    
    void exibir() {
        System.out.println("Essa conta pertence a " + this.cliente.nome + "e apresenta " + this.saldo + " reais de saldo.");
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
    }

    void transferir(float valor, Conta conta) {
        if (valor < this.saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            this.saldo -= valor;
            conta.saldo += valor * (1 - this.taxa);
            System.out.println("Depósito de " + valor + " reais realizado com sucesso! (" + valor * (1 - this.taxa) + " reais + taxa)");
        }
    }

    void sacar(float valor) {
        // Assumindo que não há taxas para saque
        this.saldo -= valor;
        System.out.println("Foram sacados " + valor + " reais de sua conta!");
    }

    void depositar(int valor) {
        this.saldo += valor;
        System.out.println("Foram depositados " + valor + " reais em sua conta!");
    }
}

public class ContaPoupanca extends Conta {
    ContaPoupanca(String agencia, int numero, Cliente cliente) {
        super(agencia, numero, cliente);
    }

    void transferir(int valor, Conta conta) {
        if (conta.cliente != this.cliente) {
            System.out.println("Transação bloqueada: saldos de poupanças só podem ser transferidos para outras contas do mesmo titular!");
        } else {
            super.transferir(valor, conta);
        }
    }
}

public class ContaPreferencial extends Conta {
    ContaPreferencial(String agencia, int numero, ClienteEspecial cliente) {
        super(agencia, numero, cliente);
    }

    void transferir(int valor, Conta conta) {
        this.taxa = this.saldo > 50000 ? 0 : 0.1;
        super.transferir(valor, conta);
    }
}