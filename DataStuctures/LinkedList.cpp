#include <iostream>
#include <stdexcept>

using namespace std;

struct Node {
    Node* next;
    int data;
    Node(int value) : data(value), next(nullptr) {}
};

class LinkedList {
private:
    Node* head;

public:
    LinkedList() : head(nullptr) {}

    void insertAtBeginning(int value) {
        Node* new_node = new Node(value);
        new_node->next = head;
        head = new_node;
    }

    void append(int value) {
        Node* new_node = new Node(value);
        if (!head) {
            head = new_node;
            return;
        }
        Node* node = head;
        while (node->next != nullptr) {
            node = node->next;
        }
        node->next = new_node;
    }

    void print() {
        cout << "[";
        Node* current = head;
        while (current != nullptr) {
            cout << current->data;
            if (current->next != nullptr) {
                cout << "-->";
            }
            current = current->next;
        }
        cout << "]" << endl;
    }

    int getLength() {
        int count = 0;
        Node* current = head;
        while (current != nullptr) {
            current = current->next;
            count++;
        }
        return count;
    }

    void insert(int value, int index) {
        if (index < 0 || index > getLength()) {
            throw runtime_error("Invalid index");
        }

        if (index == 0) {
            insertAtBeginning(value);
            return;
        }

        int count = 0;
        Node* current = head;
        while (current != nullptr) {
            if (count == index - 1) {
                Node* temp = current->next;
                Node* newNode = new Node(value);
                newNode->next = temp;
                current->next = newNode;
                return;
            }
            current = current->next;
            count++;
        }
    }

    void removeAt(int index) {
        if (index < 0 || index >= getLength()) {
            throw runtime_error("Invalid index");
        }

        if (index == 0) {
            Node* temp = head;
            head = head->next;
            delete temp;
            return;
        }

        int count = 0;
        Node* current = head;
        while (current != nullptr) {
            if (count == index - 1) {
                Node* temp = current->next;
                current->next = temp->next;
                delete temp;
                return;
            }
            current = current->next;
            count++;
        }
    }
};

int main() {
    LinkedList l1;
    l1.insertAtBeginning(10);
    l1.append(20);
    l1.append(45);
    l1.print();

    return 0;
}
