package problems.SOLID.LibraryManagement.utilities.impl;

import problems.SOLID.LibraryManagement.utilities.StringUtils;

public class SimpleStringUtils implements StringUtils {
    // may not be appropriate to put in string utils , this is specific to storage mechanism
    // there is abstraction leak as the key will use pattern to split and return the value
    // But depending on usage it seems right , if we want to split generic string
    // Also naming is against cc as the name doesn't exactly speicify it trims spaces , this seems like side effect
    public  String getValueFromKeyValueString(String key,String pattern ){
        return key.trim().split(pattern)[1];
    }
}
