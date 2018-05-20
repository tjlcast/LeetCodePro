package _02_03;

/**
 * Created by tangjialiang on 2018/5/19.
 */

import java.io.*;

/**
 * 在序列化和反序列换的时候也会出现多个不同的实例，如下：
 */
class SingletonB implements Serializable {
    private static SingletonB instance = new SingletonB() ;

    private SingletonB() {

    }

    public static SingletonB getInstance() {
        return instance ;
    }

    /**
     * below is main function and docs.
     * @param args
     */
    public static void main(String[] args) {
        File file = new File("singleton") ;
        ObjectOutputStream oos = null ;
        ObjectInputStream ois = null ;

        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            SingletonB SingletonB1 = SingletonB.getInstance();

            oos.writeObject(SingletonB1);
            oos.close();

            ois = new ObjectInputStream(new FileInputStream(file));
            SingletonB SingletonB2 = (SingletonB) ois.readObject();

            System.out.println(SingletonB1 == SingletonB2) ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这种情况也会出现有多个实例的问题，这个问题可以在类中添加readResolve()方法来避免
     * @return
     */
    // 不添加该方法则会出现 反序列化时出现多个实例的问题
    public Object readResolve() {
        return instance;
    }
}


