package _02_03;

import java.io.*;

/**
 * Created by tangjialiang on 2018/5/19.
 */
enum SingletonC implements Serializable {
    INSTANCE;
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    // below is main function.
    public static void main(String[] args) {
        testEnum();
    }

    private static void testEnum() {
        File file = new File("singletonEnum");
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {

            oos = new ObjectOutputStream(new FileOutputStream(file));
            SingletonC singleton = SingletonC.INSTANCE;
            oos.writeObject(SingletonC.INSTANCE);
            oos.close();
            ois = new ObjectInputStream(new FileInputStream(file));
            SingletonC singleton2 = (SingletonC) ois.readObject();
            System.out.println(singleton == singleton2);//true

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}