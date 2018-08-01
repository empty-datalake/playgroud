import java.util.concurrent.atomic.AtomicBoolean;

public class JavaStringCompare {
    public String singleThreadStringConcat(int count_p) {
        String temp = "";
        for(int i=0; i < count_p; i++) {
            temp += "i";
        }
        return temp;
    }

    public String singleThreadStringBufferAppend(int count_p) {
        StringBuffer temp = new StringBuffer();
        for(int i=0; i < count_p; i++) {
            temp.append("i");
        }
        return temp.toString();
    }

    public String singleThreadStringBuilderAppend(int count_p) {
        StringBuilder temp = new StringBuilder();
        for(int i=0; i < count_p; i++) {
            temp.append("i");
        }
        return temp.toString();
    }

    public String multiThreadStringBufferAppend(int count_p) throws InterruptedException {
        StringBuffer temp = new StringBuffer();
        AtomicBoolean flagOne = new AtomicBoolean(false);
        AtomicBoolean flagTwo = new AtomicBoolean(false);

        new Thread(() -> {
            for(int i=0; i<count_p; i++) {
                temp.append("i");
            }
            flagOne.set(true);
        }).start();

        new Thread(() -> {
            for(int i=0; i<count_p; i++) {
                temp.append("i");
            }
            flagTwo.set(true);
        }).start();

        while(flagOne.get()==false && flagTwo.get()==false) {
            Thread.sleep(10L);
        }

        return temp.toString();
    }

    public String multiThreadStringBuilderAppend(int count_p) throws InterruptedException {
        StringBuilder temp = new StringBuilder();
        AtomicBoolean flagOne = new AtomicBoolean(false);
        AtomicBoolean flagTwo = new AtomicBoolean(false);

        new Thread(() -> {
            for(int i=0; i<count_p; i++) {
                temp.append("i");
            }
            flagOne.set(true);
        }).start();

        new Thread(() -> {
            for(int i=0; i<count_p; i++) {
                temp.append("i");
            }
            flagTwo.set(true);
        }).start();

        while(flagOne.get()==false && flagTwo.get()==false) {
            Thread.sleep(10L);
        }

        return temp.toString();
    }

}
