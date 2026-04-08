import java.util.Scanner;
public class assignment2 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        BankAccount bank = new BankAccount();
        bank.AddName("Micah Bell", 300);
        bank.AddName("Arthur Morgan", 174);
        bank.AddName("Dutch Van Der Linde", 1000);
        MainScreen(bank, scanner);
        scanner.close();
    }
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
    public static void backScreen(BankAccount bank, Scanner scanner){
        System.out.println();
        System.out.print("Type 0 to return main screen:");
        int goBack = scanner.nextInt();
        if(goBack == 0){
            clearScreen();
            MainScreen(bank, scanner);
        }
        else{
            return;
        }
    }
    public static void MainScreen(BankAccount bank, Scanner scanner){
        System.out.println("Choose the operation.");
        System.out.println("1)Add a new account");
        System.out.println("2)Display all accounts");
        System.out.println("3)Search account by username");
        System.out.println("4)Sign in");
            int choose = scanner.nextInt();
            scanner.nextLine();
            clearScreen();
            if(choose == 1){
                System.out.print("Add a new account: ");
                    String newName = scanner.nextLine();
                    bank.AddName(newName);
                    System.out.println("The new acoount " + newName + " is in the database.");
                    backScreen(bank, scanner);
                }
            if(choose == 2){
                System.out.println("All data: ");
                bank.DisplayAll();
                backScreen(bank, scanner);
            }
            if(choose == 3){ 
                System.out.print("Searching for: ");
                String searchName = scanner.nextLine();
                User found = bank.SearchAcc(searchName);
                if(found != null){
                System.out.println(searchName + " is in database.");
                }
                else{
                    System.out.println("There is NO " + searchName + " in database.");
                }
                backScreen(bank, scanner);
            }
            if(choose == 4){
                System.out.print("Sign in: ");
                String signInName = scanner.nextLine();
                User foundUser = bank.SearchAcc(signInName);
                int state = 0;
                while(state != 1){
                    if(foundUser != null){
                        System.out.println("-------Signed in-------");
                        bank.ShowMoney(foundUser);
                        System.out.println("-----------------------");
                        System.out.println("Bank operations:");
                        System.out.println("1)Deposit money");
                        System.out.println("2)Withdraw money");
                        System.out.println("3)Transaction history");
                        System.out.println("4)Bill payments");
                        System.out.println("0)Exit");
                        int choose2 = scanner.nextInt();
                        scanner.nextLine();
                        if(choose2 == 1){
                            System.out.print("Deposit: ");
                            int toDeposit = scanner.nextInt();
                            scanner.nextLine();
                            bank.DepositMoney(toDeposit, foundUser, scanner);
                            System.out.println("-----------------------");
                            System.out.println("1)Continue");
                            System.out.println("0)Exit");
                            int choose3 = scanner.nextInt();
                            if(choose3 == 1){
                                clearScreen();
                            }
                            if(choose3 == 0){
                            state += 1;
                            backScreen(bank, scanner);
                            }
                        }
                        if(choose2 == 2){
                            System.out.print("Withdraw: ");
                            int toWighdraw = scanner.nextInt();
                            scanner.nextLine();
                            bank.WithdrawMoney(toWighdraw, foundUser, scanner);
                            System.out.println("-----------------------");
                            System.out.println("1)Continue");
                            System.out.println("0)Exit");
                            int choose3 = scanner.nextInt();
                            if(choose3 == 1){
                                clearScreen();
                            }
                            if(choose3 == 0){
                            state += 1;
                            backScreen(bank, scanner);
                            }
                        }
                        if (choose2 == 3) {
                            clearScreen();
                            System.out.println("--- Transaction history ---");
                            foundUser.history.printAll();
                            System.out.println("--------------------------");
                            backScreen(bank, scanner);
                        }
                        if (choose2 == 4) {
                        int billState = 0;
                        while (billState != 1) {
                            System.out.println("--- Bill Payment Queue ---");
                            System.out.println("1)Add bill payment");
                            System.out.println("2)Process next bill");
                            System.out.println("3)Display queue");
                            System.out.println("0)Exit");
                            int billChoice = scanner.nextInt();
                            scanner.nextLine();
                            clearScreen();

                            if (billChoice == 1) {
                                System.out.print("Bill description: ");
                                String desc = scanner.nextLine();
                                System.out.print("Amount: ");
                                double amount = scanner.nextDouble();
                                scanner.nextLine();
                                bank.billQueue.enqueue(new Bill(desc, amount));
                                System.out.println("Bill added to queue!");
                            }
                            if (billChoice == 2) {
                                Bill processed = bank.billQueue.dequeue();
                                if (processed != null) {
                                    System.out.println("Processed: " + processed);
                                }
                            }
                            if (billChoice == 3) {
                                System.out.println("--- Current Queue ---");
                                bank.billQueue.displayQueue();
                            }
                            if (billChoice == 0) {
                                billState = 1;
                                backScreen(bank, scanner);
                            }
                        }
                    }
                        if(choose2 == 0){
                            state += 1;
                            backScreen(bank, scanner);
                        }
                    }
                    else{
                        System.out.println("There is no such name in database.");
                        backScreen(bank, scanner);
                    }
                }
            }
        }
}
class BankAccount{
    private ListNode head;
    BillQueue billQueue = new BillQueue();
    public void AddName(String newName, double balance){
        User user = new User(newName);
        user.balance = balance;
        ListNode newNode = new ListNode(user);
        if(head == null){
            head = newNode;
        }
        else{
            ListNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void DepositMoney(int toDeposit, User u, Scanner scanner){
        System.out.println("-----------------------");
        System.out.println("Deposit: " + toDeposit + "$?");
        System.out.println("Y/n");
        String choose = scanner.nextLine();
        if(choose.equals("Y")){
            u.balance += toDeposit;
            u.history.push(new Transaction("DEPOSIT", toDeposit));
            System.out.println("Currernt bank is: " + u.balance + "$.");
        }
        else{
            System.out.println(choose);
        }
    }
    public void WithdrawMoney(int toWithdraw, User u, Scanner scanner){
        System.out.println("-----------------------");
        System.out.println("Withdraw: " + toWithdraw + "$?");
        System.out.println("Y/n");
        String choose = scanner.nextLine();
        if(choose.equals("Y")){
            if(u.balance - toWithdraw >=0){
                u.balance -= toWithdraw;
                u.history.push(new Transaction("WITHDRAW", toWithdraw));
            }
            else{
                System.out.println("You dont have enoght money.");
            }
            System.out.println("Currernt bank is: " + u.balance + "$.");
        }
        else{
            System.out.println("Error");
        }
    }
    public void AddName(String newName){
        User user = new User(newName);
        user.balance = 0;
        ListNode newNode = new ListNode(user);
        if(head == null){
            head = newNode;
        }
        else{
            ListNode current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void ShowMoney(User u){
        System.out.println("Balance: " + u.balance + "$");
    }
    public void DisplayAll(){
        ListNode current = head;
        while(current != null){
            User u = current.val;
            System.out.println(u.name);
            current = current.next;
        }
    }
    public User SearchAcc(String searchName){
            ListNode current = head;
            while(current != null){
                if(current.val.name.equals(searchName)){
                    return current.val;
                }
                current = current.next;
            }
            return null;
    }
}
class ListNode{
    User val;
    ListNode next;
    ListNode(User val){
        this.val = val;
        this.next = null;
    }
}
class User {
    String name;
    double balance;
    TransactionStack history = new TransactionStack();
    User(String name) {
        this.name = name;
        this.balance = 0;
    }
}
class Transaction {
    String type;
    double amount;
    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
    public String toString() {
        return type + ": " + amount + "$";
    }
}
class StackNode {
    Transaction val;
    StackNode next;
    StackNode(Transaction val) {
        this.val = val;
        this.next = null;
    }
}
class TransactionStack {
    private StackNode top;
    public void push(Transaction t) {
        StackNode newNode = new StackNode(t);
        newNode.next = top;
        top = newNode;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void printAll() {
        if (isEmpty()) {
            System.out.println("No history.");
            return;
        }
        StackNode current = top;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
class Bill {
    String description;
    double amount;
    Bill(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
    public String toString() {
        return description + " - " + amount + "$";
    }
}
class QueueNode {
    Bill val;
    QueueNode next;
    QueueNode(Bill val) {
        this.val = val;
        this.next = null;
    }
}
class BillQueue {
    private QueueNode front;
    private QueueNode rear;
    public void enqueue(Bill bill) {
        QueueNode newNode = new QueueNode(bill);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    public Bill dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Bill val = front.val;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return val;
    }
    public boolean isEmpty() {
        return front == null;
    }
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        QueueNode current = front;
        int i = 1;
        while (current != null) {
            System.out.println(i + ") " + current.val);
            current = current.next;
            i++;
        }
    }
}