package intersection;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by eprijilevschi on 5/29/2017.
 */
public class Intersection {

    private static final String BEGIN = "НачПериода";
    private static final String END = "КонПериода";

    public String findAll(String input) {
        List<String> periodList = Arrays.asList(input.split(",")).stream().map(String::trim).collect(toList());
        String checkInfinity = checkInfinity(periodList);

        if(checkInfinity != null)
            return checkInfinity; // There is infinity

        List<String> intersections = new ArrayList<>(periodList.size());
        int isOpened = 0;
        int isIntersection = 0;

        for(String period : periodList){
            if(period.contains(BEGIN)){
                //set as True and add if already opened
                if(isOpened > 0) {
                    intersections.add(period);
                    isIntersection++;
                }
                isOpened++;
            } else {
                if (period.contains(END)){
                    if(isIntersection > 0) {
                        intersections.add(period);
                        isIntersection--;
                    }
                    isOpened--;
                }
            }

        }

        if(intersections.isEmpty())
            return "Пересечения нет";
        else
            return intersections.stream().collect(Collectors.joining(", "));

    }

    private String checkInfinity(List<String> periodList) {
        Map<Boolean, Long> groupedBeginEndMap = periodList.stream()
                .filter(el -> el.contains(BEGIN) || el.contains(END))
                .collect(Collectors.groupingBy(str -> str.contains(BEGIN), Collectors.counting()));
        String isInfinite = null;
        Long beginCount = groupedBeginEndMap.get(Boolean.TRUE) == null? 0L: groupedBeginEndMap.get(Boolean.TRUE);
        Long endCount = groupedBeginEndMap.get(Boolean.FALSE) == null? 0L: groupedBeginEndMap.get(Boolean.FALSE);
        if(beginCount > endCount) {
            isInfinite = "+бесконечность";
        } else if(beginCount < endCount) {
            isInfinite = "-бесконечность";
        }

        return isInfinite;
    }
}
