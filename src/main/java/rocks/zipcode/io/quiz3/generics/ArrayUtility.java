package rocks.zipcode.io.quiz3.generics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author leon on 09/12/2018.
 */
public class ArrayUtility<SomeType> {
    private final SomeType[] array;

    public ArrayUtility(SomeType[] array) {
        this.array = array;
    }

    public SomeType findOddOccurringValue() {
        Predicate<SomeType> predicate = s -> (getNumberOfOccurrences(s) % 2) == 1;
        return findWhatIsNeeded(predicate);
    }

    public SomeType findEvenOccurringValue() {
        Predicate<SomeType> predicate = s -> (getNumberOfOccurrences(s) % 2) == 0;
        return findWhatIsNeeded(predicate);
    }

    private SomeType findWhatIsNeeded(Predicate<SomeType> predicate){
        SomeType result = null;
        for(SomeType st : array){
            if(predicate.test(st)){
                result = st;
                break;
            }
        }
        return result;
    }

    public Integer getNumberOfOccurrences(SomeType valueToEvaluate) {

        Predicate<SomeType> predicate = someType -> someType.equals(valueToEvaluate);
        Long result = Arrays.stream(array).filter(predicate).count();
        return result.intValue();

    }

    public SomeType[] filter(Function<SomeType, Boolean> predicate) {
        List<SomeType> list = Arrays.stream(array).filter(st -> predicate.apply(st)).collect(Collectors.toList());
        SomeType[] arr = (SomeType[]) Array.newInstance(array.getClass().getComponentType(),list.size());

        return list.toArray(arr);
    }
}
