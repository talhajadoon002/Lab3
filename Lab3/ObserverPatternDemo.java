public class ObserverPatternDemo {
    public static void main(String[] args) {
       Subject subject = new Subject();
 
    HexaObserver hexaObserver = new HexaObserver(subject);
    OctalObserver octalObserver = new OctalObserver(subject);
    BinaryObserver binaryObserver = new BinaryObserver(subject);
 
       System.out.println("First state change: 15");	
       subject.setState(15);

        System.out.println("Detaching Octal Observer and state change to 10");
        subject.detach(octalObserver);
        subject.setState(10);
        subject.attach(octalObserver);

       System.out.println("Reattach Octal Observer state change to 5");	
       subject.setState(5);
    }
 }
