
    public class Pedido {
        private ItemMenu[] itens;
        private Cliente cliente;
        private double total;
        private String status;
    
        public Pedido(Cliente cliente, ItemMenu[] itens) {
            this.cliente = cliente;
            this.itens = itens;
            this.total = calcularTotal();
            this.status = "Em preparação";
        }
    
        public void adicionarItem(ItemMenu item) {
     
        }
    
        public double calcularTotal() {
            double total = 0;
            for (ItemMenu item : itens) {
                total += item.getPreco();
            }
            return total;
        }
    
        public void atualizarStatus(String status) {
            this.status = status;
        }
    
        @Override
        public String toString() {
            StringBuilder detalhes = new StringBuilder("Pedido para: " + cliente.toString() + "\nStatus: " + status + "\nItens:\n");
            for (ItemMenu item : itens) {
                detalhes.append(item.toString()).append("\n");
            }
            detalhes.append("Total: R$").append(total);
            return detalhes.toString();
    }
    }
    

