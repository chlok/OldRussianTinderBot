package ru.liga.oldrussiantinderbot.repository;

import ru.liga.oldrussiantinderbot.utils.TextFileParser;

import java.util.List;

public class NamesRepository implements FileRepository {
    String NAMES_FILE_PATH = "/names.txt";

    @Override
    public List<String> getWords() {
        return TextFileParser.parse(NAMES_FILE_PATH);
    }
}
