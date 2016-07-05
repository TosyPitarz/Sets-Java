/**
 * Created by TosinPeters on 16-05-02.
 */
import java.util.Arrays;
public class Sets {
    public static void main(String[] args)
    {

        Set set1;
        set1 = new Set();


        Set set2 = new Set();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(9);
        set1.add(10);
        set1.add(2);

        set2.add(3);
        set2.add(4);
        /*set2.add(4);
        set2.add(5);*/

        //System.out.println(set1.difference(set2));

        System.out.println(set1.cartesian(set2));

/*

        Set set3 = new Set();

        Set set4 = new Set();
        Set set5 = new Set();
        Set set6 = new Set();
        
        System.out.println("   Test 1: Equal but different position: (Must come to true) ");
        System.out.println("Comparing set 1 to set 2... ");
        set1.add(1);
        set1.add(20);
        set1.add(90);
        set1.add(24);
        set1.add(98);

        set2.add(20);
        set2.add(1);
        set2.add(24);
        set2.add(90);
        set2.add(98);
        System.out.println(set1.equals(set2));

        System.out.println("   \n   Test 2: Not equal: (Must come to false) ");
        System.out.println("Comparing set 3 to set 4... ");
        set3.add(2);
        set3.add(300);
        set3.add(120);
        set3.add(240);
        set3.add(900);
        set3.add(980);

        set4.add(21);
        set4.add(67);
        set4.add(120);
        set4.add(240);
        set4.add(900);
        set4.add(980);
        System.out.println(set3.equals(set4));

        System.out.println("   \n  Test 3: Equal and the same position: (Must come to true) ");
        System.out.println("Comparing set 5 to set 6... ");
        set5.add(1);
        set5.add(20);
        set5.add(90);
        set5.add(24);
        set5.add(98);

        set6.add(1);
        set6.add(20);
        set6.add(90);
        set6.add(24);
        set6.add(98);
        System.out.println(set5.equals(set6));

        System.out.println("\n\n");
        System.out.println("SET1: " + set1);
        System.out.println("SET2: " + set2 + "\n");
        System.out.println("SET3: " + set3);
        System.out.println("SET4: " + set4 + "\n");
        System.out.println("SET5: " + set5);
        System.out.println("SET6: " + set6);
*/

        System.out.println("\nEND OF PROCESSING");
    }
}


class Set
{
    private int[] data;
    private int size;

    public Set()
    {
        data = new int[1];
        size = 0;

    }

    public void add(int value)
    {
        int[] copy;

        //avoiding duplicates
        if ( !in(value) )
        {

            if ( size >= data.length )
            {
                copy = new int[data.length + 1];

                System.arraycopy(data, 0, copy,0,data.length);

                data = copy;
            }
            data[size] = value;


            size++;
        }
        else
        {
            System.out.println("You are trying to insert a number that's already here ---> " + value);
        }

    }

    public String toString()
    {
        String result = "{";
        for(int i = 0; i < size; i++)
        {
            result += "" + data[i];
            //Add a comma after all but the last item
            if ( i < size - 1 )
            {
                result += ",";
            }

        }
        result += "}";
        return result;
    }

    public boolean in(int value)
    {
        boolean result = false;

        for(int i = 0; i < size; i++)
        {
            if ( data[i] == value )
            {
                result = true;
            }
        }

        return result;
    }

    public Set intersection(Set other)
    {
        Set result = new Set();

        for ( int i = 0; i < size; ++i )
        {
            if ( other.in(data[i]) )
            {
                result.add(data[i]);
            }
        }
        return result;
    }

    public boolean equals(Set other)
    {
        boolean result = false;

        int count = 0;

        for ( int i = 0; i < size; ++i ) //iterating over this
        {
            if ( other.in(data[i]) )
            {
                count++;
            }

            if ( count == size )
            {
                result = true;
            }
        }
        return result;
    }

    public Set difference(Set other)
    {
        Set result = new Set();

        for(int i = 0; i < size; ++i)
        {
            if ( !other.in(data[i]) )
            {
                result.add(data[i]);
            }
        }

        return result;
    }

    public String cartesian (Set other)
    {
        String [] cart = new String [this.size * other.size];

        int k = 0;
        for (int i : this.data)
        {
            for (int j : other.data)
            {
                cart[k++] = "(" + i + "," + j + ")";
            }
        }

        return Arrays.toString(cart).replaceAll("\\[","{").replaceAll("]","}");
    }

    public Set union(Set other) {
        Set result = (Set)other.clone();
        for (int i = 0; i < size; i++) {
            result.add(data[i]);
        }
        return result;
    }

    public Object clone() {
        Set result = new Set();
        for (int i = 0; i < size; i++) {
            result.add(data[i]);
        }
        return result;
    }
}