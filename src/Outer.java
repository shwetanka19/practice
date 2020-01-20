public class Outer
{
    Outer()
    {
        System.out.print("out");
    }

    class Inner
    {
        Inner()
        {
            System.out.print("in");
        }
        public void go()
        {
            System.out.print("go_in");
        }
    }

    public static void main (String [] args)
    {
        String tem = "123.567";
        String[] ta = tem.split("\\.");
        System.out.println(ta[0]);
        Outer obj = new Outer();
        obj.fun();

        int x=20;
        String sup = (x < 15) ? "small" : (x < 22)? "tiny" : "huge";
        System.out.println(sup);

        int result = 0;

        Boolean b1 = new Boolean("TRUE");
        Boolean b2 = new Boolean("true");
        Boolean b3 = new Boolean("tRuE");
        Boolean b4 = new Boolean("false");

        if (b1 == b2)result = 1;
        if (b1.equals(b2))result = result + 10;
        if (b2 == b4)result = result + 100;
        if (b2.equals(b4))result = result + 1000;
        if (b2.equals(b3))result = result + 10000;
        System.out.println(result);
    }
    void fun()
    {
        (new Inner() {}).go();
    }
}
