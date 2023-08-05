package com.epam.rd.autotasks;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Words {

    public String countWords(List<String> lines) {
        return Collections.list(new StringTokenizer(lines.toString(),
                        "[] .,‘’(“—/:?!”;*)'\\\"-")).stream()
                .map(t -> (String) t)
                .map(String::toLowerCase)
                .filter(t -> t.length() > 3)
                .collect(Collectors.groupingBy(Function.identity(), HashMap::new,
                        Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .filter(t -> t.getValue() > 9)
                .map(e -> e.getKey() + " - " + e.getValue())
                .collect(Collectors.joining("\n"));
    }
}
