import java.io.Serializable;
import java.util.*;
import order.CrossBorderOrder;
import order.DomesticOrder;
import order.OrderInput;
import order.OrderKind;

public class OrderManager implements Serializable {
    private static final long serialVersionUID = -6293942809715024164L;
    private ArrayList<OrderInput> orders = new ArrayList<OrderInput>();
    private transient Scanner input;

    public OrderManager(Scanner input) {
        this.input = input;
    }

    public void addOrder() {
        int kind = 0;
        OrderInput orderInput;
        while (kind < 1 || kind > 2) {
            try {
                System.out.println("1. Domestic");
                System.out.println("2. Cross-Border");
                System.out.print("Select num for Order Kind: ");
                kind = input.nextInt();
                if (kind == 1) {
                    orderInput = new DomesticOrder(OrderKind.Domestic);
                    orderInput.getUserInput(input);
                    orders.add(orderInput);
                    break;
                } else if (kind == 2) {
                    orderInput = new CrossBorderOrder(OrderKind.CrossBorder);
                    orderInput.getUserInput(input);
                    orders.add(orderInput);
                    break;
                } else {
                    System.out.print("Select num for Order Kind between 1 and 2: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer between 1 and 2!");
                if (input.hasNext()) {
                    input.next();
                }
                kind = -1;
            }
        }
    }

    public void deleteOrder() {
        System.out.print("Name: ");
        String checkName = input.next();
        System.out.print("Phone Number: ");
        String checkPhone = input.next();

        int index = findIndex(checkName, checkPhone);
        removeFromOrder(index);
    }

    public int findIndex(String checkName, String checkPhone) {
        int index = -1;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getName().equals(checkName) && orders.get(i).getPhone().equals(checkPhone)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int removeFromOrder(int index) {
        if (index >= 0) {
            orders.remove(index);
            System.out.println("Order Cancellation Complete.");
            return 1;
        } else {
            System.out.println("Order history is missing or the information is invalid.");
            return -1;
        }
    }

    public void editOrder() {
        System.out.print("Name: ");
        String checkName = input.next();
        System.out.print("Phone Number: ");
        String checkPhone = input.next();

        for (int i = 0; i < orders.size(); i++) {
            OrderInput order = orders.get(i);
            if (order.getName().equals(checkName) && order.getPhone().equals(checkPhone)) {
                int editNum = -1;
                while (editNum != 4) {
                    showEditMenu();
                    editNum = input.nextInt();

                    switch (editNum) {
                        case 1:
                            order.setOrderAddress(input);
                            break;
                        case 2:
                            order.setOrderProduct(input);
                            break;
                        case 3:
                            order.setOrderAddress(input);
                            order.setOrderProduct(input);
                            break;
                        default:
                            continue;
                    }
                    System.out.println("Edit Complete.");
                }
            } else {
                System.out.println("Order history is missing or the information is invalid.");
                return;
            }
            break;
        }
    }

    public void viewOrders() {
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).printInfo();
        }
    }

    public void showEditMenu() {
        System.out.println("Choose What to Change.");
        System.out.println("=================================");
        System.out.println("1. Address");
        System.out.println("2. Product Order Name");
        System.out.println("3. Address and Product Order Name");
        System.out.println("=================================");
    }
    
    public void setInput(Scanner input) {
        this.input = input;
    }
}
