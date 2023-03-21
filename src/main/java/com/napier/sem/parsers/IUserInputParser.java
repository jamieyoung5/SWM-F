package com.napier.sem.parsers;

import java.util.Map;

public interface IUserInputParser {
    Map<String, String> parseUserInput(String path);
}
