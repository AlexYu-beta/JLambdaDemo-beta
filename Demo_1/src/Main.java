/*
    this demo introduces a simple way to create a stream and process it.
 */
import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList= Arrays.asList(1,2,3,4,5);// the initial list of integers
        /*
        Function<Point,Double> keyExtractor= p -> p.getX();
        Comparator<Double> keyComparer = (d1,d2) -> Double.compare(d1,d2);
        Comparator<Point> compareByX = (p1,p2) -> keyExtractor.apply(p1).compareTo(keyExtractor.apply(p2));
        */

        /*  decompose the comparator into keyExtractor(extract the keys from the list)
            and keyComparer(compare the Extracted Keys)
         */
        Comparator<Point> compareByX = Comparator.comparing(p->p.getX());
        //the method comparing contains the process of key-extracting and key-comparing
        intList.stream()
                .map(i -> new Point(i%3,i/3))
                .sorted(Comparator.comparing(p->p.distance(0,0)))
                .forEach(p->System.out.println(p.getX()+"  "+p.getY()));
    }
}
