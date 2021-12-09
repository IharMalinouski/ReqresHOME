package objects;

import lombok.Data;

@Data
public class Salary {

    int from;
    int to;
    String currency;
    boolean gross;
}
