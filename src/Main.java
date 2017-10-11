public class Main {

    private void doItInTheOldWay(){
        MyFunctionalInterface objImplementation = new MyFunctionalInterface() {
            @Override
            public void doSomethingFunctional( String txt ) {
                System.out.println(txt);
            }
        };
        objImplementation.doSomethingFunctional("Hello in the old way!");
    }

    private void doItWithLambdas(){
        MyFunctionalInterface objImplementationOne = (String x) -> System.out.println(x);
        objImplementationOne.doSomethingFunctional("Hello from lambda fashion!");

        MyFunctionalInterface objImplementationTwo = x -> System.out.println(x);
        objImplementationTwo.doSomethingFunctional("Hello from short syntax!");

        MyFunctionalInterface objImplementationThree = x -> {
            objImplementationTwo.doSomethingFunctional("Hello from complex syntax!");
            System.out.println(x);
            System.out.println("Bye from complex syntax!");
        };
        objImplementationThree.doSomethingFunctional("Regular code from complex syntax!");

        doSomeHighOrder(objImplementationThree);
    }

    private void doSomeHighOrder( MyFunctionalInterface behaviour ) {
        behaviour.doSomethingFunctional("in high order way");
    }

    public static void main(String[] args ) {
        Main mainInstance = new Main();
        mainInstance.doItInTheOldWay();
        mainInstance.doItWithLambdas();

//        MyFunctionalInterface aBehaviour = System.out::println;
//        mainInstance.doSomeHighOrder(aBehaviour);

        MyFunctionalInterface bBehaviour = x -> {
            x = "Doing something ".concat(x);
            System.out.println(x);
            System.out.println("Making Java great again!");
        };
        mainInstance.doSomeHighOrder(bBehaviour);

    }

}
