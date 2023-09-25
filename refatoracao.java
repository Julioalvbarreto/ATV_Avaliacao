import java.util.*;


class Item {
    private String nomeItem;
    private double precoItem;

    public Item(String nomeItem, double precoItem) {
        this.nomeItem = nomeItem;
        this.precoItem = precoItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }
}

class Pedido {
    private List<Item> itens = new ArrayList<>();
    public void adicionarItem(Item item) {
        itens.add(item);
    }
    
    public List<Item> getItens() {
        return itens;
    }
}

public double calcularTotalPedidos() {
    double total = 0;
    for (Item item : itens) {
        total += item.getPrecoItem();
    }
    return total;
}

public class SistemaDePedidos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();
        while (true) {
            System.out.println("1. Criar Pedido");
            System.out.println("2. Adicionar Item ao Pedido");
            System.out.println("3. Calcular Total do Pedido");
            System.out.println("4. Listar Itens do Pedido");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    Pedido novoPedido = new Pedido();
                    pedidos.add(novoPedido);
                    System.out.println("Pedido criado.");
                    break;
                case 2:
                    if (pedidos.isEmpty()) {
                        System.out.println("Crie um pedido primeiro.");
                        break;
                    }
                    System.out.print("Digite o nome do item: ");
                    String nomeItem = scanner.next();
                    System.out.print("Digite o preço do item: ");
                    double precoItem = scanner.nextDouble();
                    Item item = new Item(nomeItem, precoItem);
                    Pedido ultimoPedido = pedidos.get(pedidos.size() - 1);
                    ultimoPedido.adicionarItem(item);
                    System.out.println("Item adicionado ao pedido.");
                    break;
                case 3:
                    if (pedidos.isEmpty()) {
                        System.out.println("Crie um pedido primeiro.");
                        break;
                    }
                    Pedido pedidoAtual = pedidos.get(pedidos.size() - 1);
                    double total = pedidoAtual.calcularTotalPedidos();
                    System.out.println("Total do pedido: " + total);
                    break;
                case 4:
                    if (pedidos.isEmpty()) {
                        System.out.println("Crie um pedido primeiro.");
                        break;
                    }
                    Pedido pedidoParaListar = pedidos.get(pedidos.size() - 1);
                    List<Item> itensDoPedido = pedidoParaListar.getItens();
                    System.out.println("Itens do pedido:");
                    for (Item i : itensDoPedido) {
                        System.out.println(i.getNomeItem() + ": " + i.getPrecoItem());
                    }
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
