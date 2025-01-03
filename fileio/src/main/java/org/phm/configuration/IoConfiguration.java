package org.phm.configuration;

import org.apache.commons.lang3.StringUtils;
import org.phm.exception.FileIoException;

public class IoConfiguration {

    public static final String FILE_PATH = "file.path";
    public static final String READ_FILE = "readFile.txt";

    public String getReadFilePath() throws FileIoException {
        return getResourcePath() + READ_FILE;
    }

    private static String getResourcePath() throws FileIoException {
        String filePath = System.getProperty(FILE_PATH);
        if (StringUtils.isBlank(filePath)) {
            throw new FileIoException("File path is empty or null");
        }
        return filePath;
    }

}
