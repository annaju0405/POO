import java.util.Scanner;

public class Principal {
    private static Cliente[] clientes = new Cliente[100];
    private static ItemMenu[] menu = new ItemMenu[10];
    private static Pedido[] pedidos = new Pedido[100];
    private static int clienteCount = 0;
    private static int menuCount = 0;
    private static int pedidoCount = 0;

    public static void main(String[] args) {
        inicializarMenu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Visualizar Menu");
            System.out.println("3. Realizar Pedido");
            System.out.println("4. Acompanhar Pedido");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    visualizarMenu();
                    break;
                case 3:
                    realizarPedido(scanner);
                    break;
                case 4:
                    acompanharPedido(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void inicializarMenu() {
        menu[menuCount++] = new ItemMenu("Pizza", "Principal", 29.90);
        menu[menuCount++] = new ItemMenu("Lasanha", "Principal", 34.90);
        menu[menuCount++] = new ItemMenu("Refrigerante", "Bebida", 5.00);
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        clientes[clienteCount++] = new Cliente(nome, endereco, telefone);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void visualizarMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuCount; i++) {
            System.out.println(menu[i].toString());
        }
    }

    private static void realizarPedido(Scanner scanner) {
        System.out.println("Escolha um cliente:");
        for (int i = 0; i < clienteCount; i++) {
            System.out.println(i + 1 + ". " + clientes[i].getNome());
        }
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine(); 

        System.out.println("Escolha os itens do pedido (digite o número do item e depois a quantidade, separado por espaço, e digite '0 0' para terminar):");
        ItemMenu[] itensPedido = new ItemMenu[10];
        int itemCount = 0;
        while (true) {
            visualizarMenu();
            System.out.print("Número do item: ");
            int itemIndex = scanner.nextInt() - 1;
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 

            if (itemIndex < 0 || itemIndex >= menuCount || quantidade <= 0) {
                if (itemIndex == -1) break;
                System.out.println("Item inválido. Tente novamente.");
                continue;
            }

            for (int i = 0; i < quantidade; i++) {
                itensPedido[itemCount++] = menu[itemIndex];
            }
        }

        pedidos[pedidoCount++] = new Pedido(clientes[clienteIndex], itensPedido);
        System.out.println("Pedido realizado com sucesso.");
    }

    private static void acompanharPedido(Scanner scanner) {
        System.out.println("Pedidos:");
        for (int i = 0; i < pedidoCount; i++) {
            System.out.println(i + 1 + ". " + pedidos[i].toString());
        }
        System.out.print("Escolha o número do pedido para acompanhar: ");
        int pedidoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); 

        if (pedidoIndex < 0 || pedidoIndex >= pedidoCount) {
            System.out.println("Pedido inválido.");
        } else {
            System.out.println(pedidos[pedidoIndex].toString());
        }
    }
}

