package edu.umb.cs680.hw03;

public class Singleton {

        private Singleton() {};
        private static Singleton instance = null;

        public static Singleton getInstance() {
            if(instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        public static void main(String[] args) {
            Singleton instance1 = Singleton.getInstance();
            Singleton instance2 = Singleton.getInstance();
            System.out.println("Instance 1 : "+instance1.hashCode()+"\nInstance 2 : "+instance2.hashCode());
        }

}