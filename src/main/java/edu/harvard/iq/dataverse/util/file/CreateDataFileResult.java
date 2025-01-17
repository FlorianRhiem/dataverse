package edu.harvard.iq.dataverse.util.file;

import edu.harvard.iq.dataverse.DataFile;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author adaybujeda
 */
public class CreateDataFileResult {

    private static final String BUNDLE_KEY_PREFIX = "dataset.file.error";

    private final String type;
    private final List<DataFile> dataFiles;
    private final List<String> errors;

    public CreateDataFileResult(String type, List<DataFile> dataFiles, List<String> errors) {
        this.type = type;
        this.dataFiles = dataFiles == null ? null : Collections.unmodifiableList(dataFiles);
        this.errors = errors == null ? Collections.emptyList() : Collections.unmodifiableList(errors);
    }

    public static CreateDataFileResult success(String type, List<DataFile> dataFiles) {
        return new CreateDataFileResult(type, dataFiles, null);
    }

    public static CreateDataFileResult error(String type) {
        return new CreateDataFileResult(type, null, Collections.emptyList());
    }

    public static CreateDataFileResult error(String type, List<String> errors) {
        return new CreateDataFileResult(type, null, errors);
    }

    public String getType() {
        return type;
    }

    public List<DataFile> getDataFiles() {
        return dataFiles;
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean success() {
        return dataFiles != null;
    }

    public String getBundleKey() {
        return String.format("%s.%s", BUNDLE_KEY_PREFIX, type);
    }
}
