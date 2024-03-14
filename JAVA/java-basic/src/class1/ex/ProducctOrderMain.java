package class1.ex;

public class ProducctOrderMain {
    public static void main(String[] args) {
        ProdectOrder[] orders = new ProdectOrder[3];
        ProdectOrder order1 = new ProdectOrder();
        order1.prodeuctName = "두부";
        order1.price=2000;
        order1.quantity = 2;
        orders[0] = order1;

        ProdectOrder order2 = new ProdectOrder();
        order2.prodeuctName = "김치";
        order2.price=5000;
        order2.quantity = 1;
        orders[1] = order2;

        ProdectOrder order3 = new ProdectOrder();
        order3.prodeuctName = "콜라";
        order3.price=1500;
        order3.quantity = 2;
        orders[2] = order3;

        int totalprice = 0;
        for(int i=0; i<orders.length; i++){
            totalprice += orders[i].quantity*orders[i].price;
            System.out.println(orders[i].prodeuctName+ orders[i].price+"원" + orders[i].quantity+"개");
        }
        System.out.println("총 결제 금액: "+totalprice +"원 ");
    }
}
