package service;

import java.util.List;

public interface Exportable {
    void export(String filename, List<String> data);
}