package com.simul.vision.utils;

import java.util.List;
import java.util.Set;

public class ListUtils {

    public static <T> boolean isValid(List<T> inList) {
        if (inList == null) {
            return false;
        } else {
            return !inList.isEmpty();
        }
    }

    public static <T> boolean isInValid(List<T> inList) {
        return !isValid(inList);
    }

    public static <T> boolean isValid(Set<T> inSet) {
        if (inSet == null) {
            return false;
        } else {
            return !inSet.isEmpty();
        }
    }

    public static <T> boolean isInValid(Set<T> inSet) {
        return !isValid(inSet);
    }

}
