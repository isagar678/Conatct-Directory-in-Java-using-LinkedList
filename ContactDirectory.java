import java.util.Scanner;

class LinkedList{
    Scanner sc=new Scanner(System.in);
    Node head;
    class Node{
        Node next;
        String email;
        long mobile;
        String name;
        public Node(String email, long mobile, String name) {
            this.email = email;
            this.mobile = mobile;
            this.name = name;
            Node next=null;
        }
        @Override
        public String toString() {
            return "Contact [email=" + email + ", mobile=" + mobile + ", name=" + name + "]";
        }
        
    }
    public void addContact(String email,long mobile,String name)
    {
        
        Node new_contact=new Node(email, mobile, name);
        if(head==null)
        {
            head=new_contact;
            
        }
        else{
            Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=new_contact;
        }
        
        System.out.println("contact "+name+" added");
    }
    public  Node searchContactString(String input )
    {
        boolean flag=true;
        Node temp=head;
        while (temp!=null) {
            if(temp.email.equalsIgnoreCase(input) || temp.name.equalsIgnoreCase(input))
            {
                System.out.println(temp);
                flag=false;
                break;
            }
            temp=temp.next;
        }
        if (flag==false) {
            return temp;
        } 
        else{
            System.out.println("No Such Contact Found");
            return null;
        }
    }
    public Node searchContactLong(Long input)
    {
        boolean flag=true;
        Node temp=head;
        while (temp!=null) {
            if(temp.mobile==input)
            {
                System.out.println(temp);
                flag=false;
                break;
            }
            temp=temp.next;
        }
        if (flag==false) {
            return temp;
        } 
        else{
            System.out.println("No Such Contact Found");
            return null;
        }
    }
    public void updateContact(Node current)
    {
        if(current==null)
        {
            return;
        }
        System.out.println("ENTER NEW NAME");
        String new_name=sc.nextLine();
        System.out.println("ENTER NEW MOBILE");
        long new_number=(long)sc.nextLong();
        System.out.println("ENTER NEW EMAIL");
        String new_email=sc.next();
        current.email=new_email;
        current.mobile=new_number;
        current.name=new_name;
        System.out.println("Contact updated!!");
        System.out.print("New "+current);
    }
    public void deleteContact(Node temp)
    {
        if(temp==null)
        {
            return;
        }
        if(temp==head)
        {
            head=head.next;
            System.out.println("Deleted "+temp);
            return;
        }
        Node flag=head;
        while(flag.next!=temp)
        {
            flag=flag.next;
        }
        flag.next=temp.next;
        temp.next=null;
        System.out.println("Deleted "+temp);

    }
    
    public void displayAllContacts()
    {
        if (head==null)
        {
            System.out.println("no contact added");
            return;
        }
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.name);

            temp=temp.next;
        }
    }
}

public class ContactDirectory {
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
         Scanner sc=new Scanner(System.in);
         int choice,searchBy;
         long inputMobile;
         String name_deltetion,inputMail;
         System.out.println("\n\n\n      WELCOME TO YOUR PERSONALISED CONTACT DIRECTORY\n");
            System.out.println("\n*Enter Passkey to continue");
            String passkey=sc.next();

            while (!passkey.equals("hello")) {
                System.out.println("    WRONG PASSKEY ENTER AGAIN");
                passkey=sc.next();
            }
            System.out.println("        WELCOME");

        do {
            
            System.out.println("\n\n\n	MENU");
            System.out.println("\n 1. ADD A CONTACT\n 2. DELETE CONTACT\n 3. UPDATE CONTACT\n 4.SEARCH CONTACT\n 5.DISPALY ALL CONTACTS\n 6.EXIT");

            choice=sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name");
                    String name=sc.next();
                    System.out.println("Enter Mobile Number");
                    long mb=sc.nextLong();
                    System.out.println("Enter email");
                    String email=sc.next();
                    ll.addContact(email, mb, name);

                    break;
                case 2:
                    System.out.println("Enter name of the contact you want to delete");
                    name_deltetion=sc.next();
                    ll.deleteContact(ll.searchContactString(name_deltetion));
                    break;
                case 3:
                    System.out.println("Enter name of the contact you want to update");
                    name_deltetion=sc.next();
                    ll.updateContact(ll.searchContactString(name_deltetion));
                    break;
                case 4:
                    System.out.println("Press 1 to search by name, 2 to search by email, 3 to search by phone number");
                    searchBy=sc.nextInt();
                    if(searchBy==1 || searchBy==2)
                    {
                        inputMail=sc.next();
                        ll.searchContactString(inputMail);
                        
                    }
                    else if(searchBy==3)
                    {
                        inputMobile=sc.nextLong();
                    }
                    else{
                        System.out.println("wrong choice");
                    }
                    break;
                case 5:
                    ll.displayAllContacts();
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;
            }

        } while (choice!=6);
    }
}
