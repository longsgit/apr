package com.herbalife.examples;

public class InnerClassesExample {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        TV sony = new TV();
        TV.Remote sonyRemote = sony.new Remote();
        sonyRemote.increaseVolume();
        sonyRemote.decreaseVolume();
    }
}

class TV {
    private int volume;

    public void increaseVolume() {
        volume++;
    }

    public void decreaseVolume() {
        volume--;
    }

    //Inner classes can access private members of their parent class
    class Remote {
        public void increaseVolume() {
            volume++;
        }

        public void decreaseVolume() {
            volume--;
        }
    }
}

class Outer {
    class Inner {

    }
}
