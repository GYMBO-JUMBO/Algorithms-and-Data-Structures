# Bank Account System – Assignment 2
## Korostylev Dmitriy SE2513
## Classes

### BankAccount
Main bank class. Stores all user accounts as a linked list.
- AddName(name) - add new account
- AddName(name, balance) - add account with starting balance
- DepositMoney(amount, user, scanner) - deposit money into account
- WithdrawMoney(amount, user, scanner) - withdraw money from account
- SearchAcc(name) - find user by name
- DisplayAll() - print all accounts
- ShowMoney(user) - print user balance

### User
Represents a bank account holder.
- Fields: name, balance, history (transaction stack)

### ListNode
A node in the linked list. Holds a User and pointer to the next node.

---

## Stack - Transaction History

### Transaction
Stores one transaction: type (DEPOSIT / WITHDRAW) and amount.

### StackNode
A node in the transaction stack. Holds a Transaction and pointer to next.

### TransactionStack
Custom stack that stores transaction history per user.
- push(transaction) - add new transaction on top
- isEmpty() - check if stack is empty
- printAll() - display full transaction history

---

## Queue - Bill Payments

### Bill
Stores one bill payment: description and amount.

### QueueNode
A node in the bill queue. Holds a Bill and pointer to next.

### BillQueue
Custom queue for bill payment requests.
- enqueue(bill) - add bill to the end of queue
- dequeue() - process and remove the first bill
- isEmpty() - check if queue is empty
- displayQueue() - display all pending bills

---
### Ive been using Ai for this block
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
becouse of skill issue and straight love of beauty.
### Screenshots from terminal
![](assignment2/Снимок_экрана_от_2026-04-08_16-11-17.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-11-49.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-12-02.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-12-17.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-12-34.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-13-00.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-13-21.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-13-34.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-14-03.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-14-26.png)
![](assignment2/Снимок_экрана_от_2026-04-08_16-14-36.png)